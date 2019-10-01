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
    DirectorsDashComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
