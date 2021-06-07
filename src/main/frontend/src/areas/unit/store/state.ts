import { Unit as Entity} from "@/model/Unit";

export interface IUnitState {
    units: Array<Entity>;
}

export const state: IUnitState = {
    units: []
};
