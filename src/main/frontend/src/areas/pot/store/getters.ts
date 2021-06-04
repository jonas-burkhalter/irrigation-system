import { IRootState } from '@/plugins/store';
import { GetterTree } from 'vuex';
import { IPotState } from './state';

export const ENTRIES = 'entries';

export const getters: GetterTree<IPotState, IRootState> = {
    [ENTRIES]: (state) => state.pots
};
