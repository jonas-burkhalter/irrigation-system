import { IRootState } from '../../../plugins/store';
import { GetterTree } from 'vuex';
import { IAuthenticateState } from './state';

export const AUTHENTICATION_STATE = 'authState';
export const IS_AUTHENTICATED = 'isAuthenticated';

export const getters: GetterTree<IAuthenticateState, IRootState> = {
    [AUTHENTICATION_STATE]: (state) => state.state,
    [IS_AUTHENTICATED]: (state) => !!state.token
};
