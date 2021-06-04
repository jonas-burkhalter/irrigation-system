import { Unit as Entry } from '@/model/Unit';
import { MutationTree } from 'vuex';
import { IUnitState } from './state';

export const ENTRIES = 'entries';

export const mutations: MutationTree<IUnitState> = {
    [ENTRIES](state, value: Array<Entry>) {
        state.units = value;
    }
};
