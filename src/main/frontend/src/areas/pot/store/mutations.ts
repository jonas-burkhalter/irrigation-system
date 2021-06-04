import { Pot } from '@/model/Pot';
import { MutationTree } from 'vuex';
import { IPotState } from './state';

export const ENTRIES = 'entries';

export const mutations: MutationTree<IPotState> = {
    [ENTRIES](state, value: Array<Pot>) {
        state.pots = value;
    }
};
