import { IRootState } from '@/plugins/store';
import { ActionTree } from 'vuex';
import { IAlertState } from './state';
import { ALERT } from './name';

import { ERROR as MUT_ERROR, INFO as MUT_INFO, SUCCESS as MUT_SUCCESS, VISIBLE, WARNING as MUT_WARNING } from './mutations';

export const CLOSE = 'close';
export const ERROR = 'error';
export const INFO = 'info';
export const SUCCESS = 'success';
export const WARNING = 'warning';

export const actions: ActionTree<IAlertState, IRootState> = {
    [CLOSE]({ commit }: any, text: string) {
        console.debug(ALERT + '::' + CLOSE);
        commit(VISIBLE, false);
    },
    [ERROR]({ commit }: any, text: string) {
        console.debug(ALERT + '::' + ERROR, 'text', text);
        commit(MUT_ERROR, text);
    },
    [INFO]({ commit }: any, text: string) {
        console.debug(ALERT + '::' + INFO, 'text', text);
        commit(MUT_INFO, text);
    },
    [SUCCESS]({ commit }: any, text: string) {
        console.debug(ALERT + '::' + SUCCESS, 'text', text);
        commit(MUT_SUCCESS, text);
    },
    [WARNING]({ commit }: any, text: string) {
        console.debug(ALERT + '::' + WARNING, 'text', text);
        commit(MUT_WARNING, text);
    }
};
