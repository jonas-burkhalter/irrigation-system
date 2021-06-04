import { MutationTree } from 'vuex';
import { IAuthenticateState } from './state';

export const AUTHENTICATION_ERROR = 'authenticationError';
export const AUTHENTICATION_LOGOUT = 'authenticationLogout';
export const AUTHENTICATION_REQUEST = 'authenticationRequest';
export const AUTHENTICATION_SUCCESS = 'authenticationSuccess';

export const mutations: MutationTree<IAuthenticateState> = {
    [AUTHENTICATION_ERROR]: (state) => {
        state.state = 'error';
    },
    [AUTHENTICATION_LOGOUT]: (state) => {
        state.state = '';
        state.token = '';
    },
    [AUTHENTICATION_REQUEST]: (state) => {
        state.state = 'loading';
    },
    [AUTHENTICATION_SUCCESS]: (state, token) => {
        state.state = 'success';
        state.token = token;
    }
};
