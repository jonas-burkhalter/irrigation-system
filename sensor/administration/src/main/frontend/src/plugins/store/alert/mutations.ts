import { MutationTree } from 'vuex';
import { IAlertState } from './state';

export const ERROR = 'error';
export const INFO = 'info';
export const SUCCESS = 'success';
export const VISIBLE = 'visible';
export const WARNING = 'warning';

export const mutations: MutationTree<IAlertState> = {
    [ERROR]: (state, text) => {
        state.text = text;
        state.type = 'error';
        state.visible = true;
    },
    [INFO]: (state, text) => {
        state.text = text;
        state.type = 'info';
        state.visible = true;
    },
    [SUCCESS]: (state, text) => {
        state.text = text;
        state.type = 'success';
        state.visible = true;
    },
    [VISIBLE]: (state, visible) => {
        state.visible = visible;
    },
    [WARNING]: (state, text) => {
        state.text = text;
        state.type = 'warning';
        state.visible = true;
    }
};
