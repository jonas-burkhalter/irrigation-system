import { Unit as Entity } from '@/model/Unit';
import { MutationTree } from 'vuex';
import { IUnitState } from './state';

export const ENTITIES = 'entities';

export const mutations: MutationTree<IUnitState> = {
    [ENTITIES](state, value: Array<Entity>) {
        state.units = value;
    }
};
