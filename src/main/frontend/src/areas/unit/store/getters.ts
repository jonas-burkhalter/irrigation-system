import { IRootState } from '@/plugins/store';
import { GetterTree } from 'vuex';
import { IUnitState } from './state';

export const ENTRIES = 'entries';

export const getters: GetterTree<IUnitState, IRootState> = {
    [ENTRIES]: (state) => state.units
};
