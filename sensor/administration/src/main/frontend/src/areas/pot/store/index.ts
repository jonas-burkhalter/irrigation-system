import Vue from 'vue';
import Vuex, { Module } from 'vuex';
import { IRootState } from '@/plugins/store';

import { actions } from './actions';
import { getters } from './getters';
import { mutations } from './mutations';
import { IPotState, state } from './state';

Vue.use(Vuex);

export const NAME = 'pot';

export const store: Module<IPotState, IRootState> = {
    actions,
    getters,
    modules: {},
    mutations,
    namespaced: true,
    state
};

export default store;
