import { Pot } from "@/model/Pot";

export interface IPotService {
    create(entity: Pot): Promise<Pot>;
    delete(id: number): Promise<any>;
    edit(entity: Pot): Promise<Pot>;
    get(id: number): Promise<Pot>;
    get_all(): Promise<Array<Pot>>;
}
