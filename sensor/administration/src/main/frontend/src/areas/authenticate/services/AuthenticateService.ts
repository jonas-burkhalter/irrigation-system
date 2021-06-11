import BaseService from '../../../services/BaseService';
import { IAuthenticateService } from './IAuthenticateService';
import { User } from '../types/User';

import { store } from '@/plugins/store';
import { ALERT } from '@/plugins/store/alert/name';
import { ERROR, SUCCESS } from '@/plugins/store/alert/actions';

export default class AuthenticateService extends BaseService implements IAuthenticateService {
    private USERS_URL: string;

    constructor() {
        super();
        this.USERS_URL = `${this.BASE_URL}/users`;

        console.debug('authenticateService::constructor', this.USERS_URL);
    }

    login(user: User): Promise<string> {
        return super
            .POST(`${this.USERS_URL}/login`, null, {
                method: 'POST',
                headers: {
                    Authorization: 'Basic ' + btoa(`${user.name}:${user.password}`)
                }
            })
            .then((response: any) => {
                store.dispatch(`${ALERT}/${SUCCESS}`, `areas.authenticate.messages.login.${response.status}`);
                return response.data;
            })
            .catch((error: any) => {
                store.dispatch(`${ALERT}/${ERROR}`, `areas.authenticate.messages.login.${error.status}`);
                throw error;
            });
    }

    register(user: User): Promise<string> {
        return super
            .POST(this.USERS_URL, user, {
                method: 'POST'
            })
            .then((response: any) => {
                store.dispatch(`${ALERT}/${SUCCESS}`, `areas.authenticate.messages.register.${response.status}`);
                return response.data;
            })
            .catch((error: any) => {
                store.dispatch(`${ALERT}/${ERROR}`, `areas.authenticate.messages.register.${error.status}`);
                throw error;
            });
    }
}

export const authenticateService = new AuthenticateService();
