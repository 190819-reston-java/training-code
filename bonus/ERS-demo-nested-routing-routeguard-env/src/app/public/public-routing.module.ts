import { AboutModule } from './about/about.module';
import { AboutComponent } from './about/about/about.component';

import { LoginModule } from './login/login.module';
import { LoginFormComponent } from './login/login-form/login-form.component';

import { LayoutComponent } from './layout/layout.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [
  {path: '', component: LayoutComponent, children: [
    {path: 'login', component: LoginFormComponent },
    {path: 'about', component: AboutComponent },
  ]},
];

@NgModule({
  imports: [LoginModule, AboutModule, RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PublicRoutingModule { }
