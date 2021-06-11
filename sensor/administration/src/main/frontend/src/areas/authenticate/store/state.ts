import { JSON_WEB_TOKEN } from '@/services/BaseService';

export interface IAuthenticateState {
    state: string;
    token: string;
}

export const state: IAuthenticateState = {
    state: '',
    token: localStorage.getItem(JSON_WEB_TOKEN) || ''
};
