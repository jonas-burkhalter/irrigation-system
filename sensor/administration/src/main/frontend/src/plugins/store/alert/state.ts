export interface IAlertState {
    text: string;
    type: string;
    visible: boolean;
}

export const state: IAlertState = {
    text: '',
    type: 'success',
    visible: false
};
