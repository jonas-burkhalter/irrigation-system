import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

// RootState
export interface IRootState {
    version: string;
}
export const RootState: IRootState = {
    version: '0.0.1'
};

// Modules
import alert from '@/plugins/store/alert';
import { ALERT } from '@/plugins/store/alert/name';

import authenticate from '@/areas/authenticate/store';
import { AUTHENTICATE } from '@/areas/authenticate/store/name';

import pot, { NAME as POT } from "@/areas/pot/store"
import unit, { NAME as UNIT } from "@/areas/unit/store"

export const store = new Vuex.Store({
    modules: {
        [ALERT]: alert,
        // AREAS
        [AUTHENTICATE]: authenticate,
        [POT]: pot,
        [UNIT]: unit
    },
    state: RootState
});

export default store;
