import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SecretPageComponent } from './secret-page/secret-page.component';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { SummaryPageComponent } from './summary-page/summary-page.component';

const routes: Routes = [
  {
    path: "home",
    component: HomeComponent,
  },
  {
    path: "about",
    component: AboutComponent,
  },
  {
    path: "secret",
    component: SecretPageComponent,
  },
  {
    path: "summary",
    component: SummaryPageComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
