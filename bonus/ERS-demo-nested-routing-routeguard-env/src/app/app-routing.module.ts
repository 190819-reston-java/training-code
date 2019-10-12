import { AuthorizationService } from './core/authorization.service';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { roles } from './core/role';
import { RoleGuard } from './core/role.guard';

const routes: Routes = [
  { path: '',
    canLoad: [RoleGuard],
    data: {roles: [roles.NOAUTH, roles.EMPLOYEE, roles.MANAGER, roles.ADMIN]},
    loadChildren: './public/public.module#PublicModule'},
  { path: 'employee',
    canLoad: [RoleGuard],
    data: {roles: [roles.EMPLOYEE, roles.ADMIN]},
    loadChildren: './employee/employee.module#EmployeeModule'},
  { path: 'manager',
    canLoad: [RoleGuard],
    data: {roles: [roles.MANAGER, roles.ADMIN]},
    loadChildren: './manager/manager.module#ManagerModule'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
