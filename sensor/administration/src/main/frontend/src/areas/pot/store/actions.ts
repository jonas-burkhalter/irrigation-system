import { IRootState } from '@/plugins/store';
import { ActionTree } from 'vuex';
import { IPotState } from './state';

import { potService as service } from '@/areas/pot/services/PotService';
import { ENTITIES } from '@/areas/pot/store/mutations';
import { Pot as Entity } from '@/model/Pot';

export const CREATE = 'create';
export const DELETE = 'delete';
export const EDIT = 'edit';
export const GET = 'get';
export const GET_ALL = 'getAll';

export const actions: ActionTree<IPotState, IRootState> = {
    async [CREATE]({ dispatch }: any, todo: Entity) {
        return service.create(todo).then(() => {
            dispatch(GET_ALL);
        });
    },
    async [DELETE]({ dispatch }: any, todo: Entity) {
        return service.delete(todo.id).then(() => {
            dispatch(GET_ALL);
        });
    },
    async [EDIT]({ dispatch }: any, todo: Entity) {
        return service.edit(todo).then(() => {
            dispatch(GET_ALL);
        });
    },
    async [GET]({ commit }: any, id: number) {
        return service.get(id).then((response: Entity) => {
            return response;
        });
    },
    async [GET_ALL]({ commit }: any) {
        return service.get_all().then((response: Array<Entity>) => {
            commit(ENTITIES, response);
        });
    }
};
