import { IRootState } from '@/plugins/store';
import { ActionTree } from 'vuex';
import { IUnitState } from './state';

import { unitService as service } from '@/areas/unit/services/UnitService';
import { ENTRIES } from '@/areas/unit/store/mutations';
import { Unit as Entry } from '@/model/Unit';

export const CREATE = 'create';
export const DELETE = 'delete';
export const EDIT = 'edit';
export const GET = 'get';
export const GET_ALL = 'getAll';

export const actions: ActionTree<IUnitState, IRootState> = {
    async [CREATE]({ dispatch }: any, todo: Entry) {
        return service.create(todo).then(() => {
            dispatch(GET_ALL);
        });
    },
    async [DELETE]({ dispatch }: any, todo: Entry) {
        return service.delete(todo.id).then(() => {
            dispatch(GET_ALL);
        });
    },
    async [EDIT]({ dispatch }: any, todo: Entry) {
        return service.edit(todo).then(() => {
            dispatch(GET_ALL);
        });
    },
    async [GET]({ commit }: any, id: number) {
        return service.get(id).then((response: Entry) => {
            return response;
        });
    },
    async [GET_ALL]({ commit }: any) {
        return service.get_all().then((response: Array<Entry>) => {
            commit(ENTRIES, response);
        });
    }
};
