import { Pot as Entity} from "@/model/Pot";

export interface IPotState {
    pots: Array<Entity>;
}

export const state: IPotState = {
    pots: []
};
