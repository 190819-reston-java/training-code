import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { DisplayTableComponent } from './display-table/display-table.component';
import { ImageDisplayerComponent } from './image-displayer/image-displayer.component';
import { SearchbarComponent } from './searchbar/searchbar.component';
import { SidenavComponent } from './sidenav/sidenav.component';
import { LogoComponent } from './logo/logo.component';
import { FooterComponent } from './footer/footer.component';
import { MoviesDashComponent } from './movies-dash/movies-dash.component';
import { ActorsDashComponent } from './actors-dash/actors-dash.component';
import { DirectorsDashComponent } from './directors-dash/directors-dash.component';
import { MovieEditorComponent } from './movie-editor/movie-editor.component';
import { LoginComponent } from './login/login.component';
import { ActorEditorComponent } from './actor-editor/actor-editor.component';
import { DirectorEditorComponent } from './director-editor/director-editor.component';
import { SignoutComponent } from './signout/signout.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    DisplayTableComponent,
    ImageDisplayerComponent,
    SearchbarComponent,
    SidenavComponent,
    LogoComponent,
    FooterComponent,
    MoviesDashComponent,
    ActorsDashComponent,
    DirectorsDashComponent,
    MovieEditorComponent,
    LoginComponent,
    ActorEditorComponent,
    DirectorEditorComponent,
    SignoutComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
