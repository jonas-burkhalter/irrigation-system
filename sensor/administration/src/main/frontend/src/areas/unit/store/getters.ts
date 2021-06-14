import { IRootState } from '@/plugins/store';
import { GetterTree } from 'vuex';
import { IUnitState } from './state';

export const ENTITIES = 'entities';

export const getters: GetterTree<IUnitState, IRootState> = {
    [ENTITIES]: (state) => state.units
};
