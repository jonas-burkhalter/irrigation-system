import { Unit } from '@/model/Unit';
import BaseService from '@/services/BaseService';
import { IUnitService } from '@/areas/unit/services/IUnitService';

export default class UnitService extends BaseService implements IUnitService {
    private RESOURCE_URL: string;

    constructor() {
        super();
        this.RESOURCE_URL = `${this.BASE_URL}/units`;
    }

    public async create(entity: Unit): Promise<Unit> {
        return super
            .POST(this.RESOURCE_URL, entity)
            .then((response: any) => {
                return response;
            });
    }

    public async delete(id: number): Promise<any> {
        return super
            .DELETE(`${this.RESOURCE_URL}/${id}`)
            .then((response: any) => {
                return response.data;
            });
    }

    public async edit(entity: Unit): Promise<Unit> {
        return super
            .PUT(`${this.RESOURCE_URL}/${entity.id}`, entity)
            .then((response: any) => {
                return response.data;
            });
    }

    public async get(id: number): Promise<Unit> {
        return super
            .GET(`${this.RESOURCE_URL}/${id}`)
            .then((response: any) => {
                return response.data;
            });
    }

    public async get_all(): Promise<Array<Unit>> {
        return super
            .GET(this.RESOURCE_URL)
            .then((response: any) => {
                return response.data;
            });
    }
}

export const unitService = new UnitService();
