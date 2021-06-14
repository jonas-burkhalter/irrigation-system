import { Pot } from '@/model/Pot';
import BaseService from '@/services/BaseService';
import { IPotService } from '@/areas/pot/services/IPotService';

export default class PotService extends BaseService implements IPotService {
    private RESOURCE_URL: string;

    constructor() {
        super();
        this.RESOURCE_URL = `${this.BASE_URL}/pot`;
    }

    public async create(entity: Pot): Promise<Pot> {
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

    public async edit(entity: Pot): Promise<Pot> {
        return super
            .PUT(`${this.RESOURCE_URL}/${entity.id}`, entity)
            .then((response: any) => {
                return response.data;
            });
    }

    public async get(id: number): Promise<Pot> {
        return super
            .GET(`${this.RESOURCE_URL}/${id}`)
            .then((response: any) => {
                return response.data;
            });
    }

    public async get_all(): Promise<Array<Pot>> {
        return super
            .GET(this.RESOURCE_URL)
            .then((response: any) => {
                return response.data;
            });
    }
}

export const potService = new PotService();
