export class Role {
    id: number;
    title: string;

    constructor(id: number, title: string) {
        this.id = id;
        this.title = title;
    }
}

export const roles = {
    MANAGER: new Role(1, 'MANAGER'),
    EMPLOYEE: new Role(2, 'EMPLOYEE'),
    ADMIN: new Role(3, 'ADMIN'),
    NOAUTH: new Role(0, 'NOAUTH'),
 };
