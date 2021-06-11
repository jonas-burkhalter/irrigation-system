import { IRootState } from '../../../plugins/store';
import { ActionTree } from 'vuex';
import { IAuthenticateState } from './state';

import { JSON_WEB_TOKEN } from '@/services/BaseService';

import { authenticateService } from '../services/AuthenticateService';
import { AUTHENTICATE } from './name';
import { User } from '../types/User';
import { AUTHENTICATION_ERROR, AUTHENTICATION_LOGOUT, AUTHENTICATION_REQUEST, AUTHENTICATION_SUCCESS } from './mutations';

export const LOGIN = 'login';
export const LOGOUT = 'logout';
export const REGISTER = 'register';

export const actions: ActionTree<IAuthenticateState, IRootState> = {
    async [LOGIN]({ commit }: any, user: User) {
        console.debug(AUTHENTICATE + '::' + LOGIN, 'user', user);

        commit(AUTHENTICATION_REQUEST);

        return authenticateService
            .login(user)
            .then((token: any) => {
                localStorage.setItem(JSON_WEB_TOKEN, token);
                commit(AUTHENTICATION_SUCCESS, token);
            })
            .catch((error) => {
                commit(AUTHENTICATION_ERROR, error);
                localStorage.removeItem(JSON_WEB_TOKEN);
            });
    },
    [LOGOUT]({ commit }: any) {
        console.debug(AUTHENTICATE + '::' + LOGOUT);

        commit(AUTHENTICATION_LOGOUT);
        localStorage.removeItem(JSON_WEB_TOKEN);
    },
    async [REGISTER]({ dispatch }: any, user: User) {
        console.debug(AUTHENTICATE + '::' + REGISTER, 'user', user);

        return authenticateService.register(user).then(() => {
            dispatch(LOGIN, user);
        });
    }
};
