import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MoviesDashComponent } from './movies-dash/movies-dash.component';
import { ActorsDashComponent } from './actors-dash/actors-dash.component';
import { DirectorsDashComponent } from './directors-dash/directors-dash.component';

const routes: Routes = [
  {
    path : "movies",
    component : MoviesDashComponent,
  },
  {
    path : "actors",
    component : ActorsDashComponent,
  },
  {
    path : "directors",
    component : DirectorsDashComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
