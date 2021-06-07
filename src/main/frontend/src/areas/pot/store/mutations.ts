import { Pot } from '@/model/Pot';
import { MutationTree } from 'vuex';
import { IPotState } from './state';

export const ENTITIES = 'entities';

export const mutations: MutationTree<IPotState> = {
    [ENTITIES](state, value: Array<Pot>) {
        state.pots = value;
    }
};
