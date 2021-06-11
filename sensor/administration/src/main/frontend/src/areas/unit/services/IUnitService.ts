import { Unit } from "@/model/Unit";

export interface IUnitService {
    create(entity: Unit): Promise<Unit>;
    delete(id: number): Promise<any>;
    edit(entity: Unit): Promise<Unit>;
    get(id: number): Promise<Unit>;
    get_all(): Promise<Array<Unit>>;
}
