import { Pot as Entry} from "@/model/Pot";

export interface IPotState {
    pots: Array<Entry>;
}

export const state: IPotState = {
    pots: []
};
