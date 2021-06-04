import { User } from '../types/User';

export interface IAuthenticateService {
    login(user: User): Promise<string>;
    register(user: User): Promise<string>;
}
