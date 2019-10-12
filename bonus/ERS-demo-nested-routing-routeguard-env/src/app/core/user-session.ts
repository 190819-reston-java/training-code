import { Role, roles } from './role';

export class UserSession {
    account: Account;
    role: Role; // convenience, so we don't have to get it from account every time
    token: string;
}

export const debugUser = new UserSession();
debugUser.role = roles.ADMIN;
