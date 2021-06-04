import { Unit as Entry} from "@/model/Unit";

export interface IUnitState {
    units: Array<Entry>;
}

export const state: IUnitState = {
    units: []
};
