import { IRootState } from '@/plugins/store';
import { ActionTree } from 'vuex';
import { IUnitState } from './state';

import { unitService as service } from '@/areas/unit/services/UnitService';
import { ENTITIES } from '@/areas/unit/store/mutations';
import { Unit as Entity } from '@/model/Unit';

export const CREATE = 'create';
export const DELETE = 'delete';
export const EDIT = 'edit';
export const GET = 'get';
export const GET_ALL = 'getAll';

export const actions: ActionTree<IUnitState, IRootState> = {
    async [CREATE]({ dispatch }: any, entity: Entity) {
        return service.create(entity).then(() => {
            dispatch(GET_ALL);
        });
    },
    async [DELETE]({ dispatch }: any, entity: Entity) {
        return service.delete(entity.id).then(() => {
            dispatch(GET_ALL);
        });
    },
    async [EDIT]({ dispatch }: any, entity: Entity) {
        return service.edit(entity).then(() => {
            dispatch(GET_ALL);
        });
    },
    async [GET]({}: any, id: number) {
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
