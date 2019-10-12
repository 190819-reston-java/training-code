import { CoreModule } from './../core/core.module';
import { SharedModule } from './../shared/shared.module';
import { NgModule } from '@angular/core';

import { EmployeeRoutingModule } from './employee-routing.module';
import { HomeComponent } from './home/home.component';
import { LayoutComponent } from './layout/layout.component';

@NgModule({
  declarations: [HomeComponent, LayoutComponent,],
  imports: [
    SharedModule,
    CoreModule,
    EmployeeRoutingModule,
  ],
  exports: [
  ],
})
export class EmployeeModule { }
