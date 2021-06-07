import { IRootState } from '@/plugins/store';
import { GetterTree } from 'vuex';
import { IPotState } from './state';

export const ENTITIES = 'entities';

export const getters: GetterTree<IPotState, IRootState> = {
    [ENTITIES]: (state) => state.pots
};
