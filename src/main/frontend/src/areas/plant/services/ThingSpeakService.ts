import BaseService from '@/services/BaseService';

import { store } from '@/plugins/store';
import { ALERT } from '@/plugins/store/alert/name';
import { ERROR, SUCCESS } from '@/plugins/store/alert/actions';

export default class ThingSpeakService extends BaseService {
    private RESOURCE_URL: string;

    constructor() {
        super();
        this.RESOURCE_URL = "https://api.thingspeak.com/channels/1402332/feeds.json?api_key=W15TSVWM0JN7071N&days=1";

        console.debug('thingSpeakService::constructor', this.RESOURCE_URL);
    }

    public async get(): Promise<any> {
        return super
            .GET(this.RESOURCE_URL)
            .then((response: any) => {
                return response.data;
            })
            .catch((error: any) => {
                console.log(error);
                store.dispatch(`${ALERT}/${ERROR}`, `areas.todos.messages.get_all.${error.status}`);
                throw error;
            });
    }
}

export const thingSpeakService = new ThingSpeakService();
