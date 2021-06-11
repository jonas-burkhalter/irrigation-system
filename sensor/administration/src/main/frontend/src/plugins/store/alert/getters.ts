import { IRootState } from '@/plugins/store';
import { GetterTree } from 'vuex';
import { IAlertState } from './state';

export const TEXT = 'text';
export const TYPE = 'type';
export const VISIBLE = 'visible';

export const getters: GetterTree<IAlertState, IRootState> = {
    [TEXT]: (state) => state.text,
    [TYPE]: (state) => state.type,
    [VISIBLE]: (state) => state.visible
};
