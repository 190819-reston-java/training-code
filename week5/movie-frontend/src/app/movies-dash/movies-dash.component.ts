import { Component, OnInit } from '@angular/core';
import { MovieHttpService } from '../movie-http.service';

@Component({
  selector: 'app-movies-dash',
  templateUrl: './movies-dash.component.html',
  styleUrls: ['./movies-dash.component.css']
})
export class MoviesDashComponent implements OnInit {

  movieList : any;

  constructor(private movieHttp :MovieHttpService) { }

  ngOnInit() {
    this.movieHttp.getMovies().subscribe(
      (data)=>{
        this.movieList = data;
      },
      (error)=>{
        console.error(error);
      }
    );
  }

}
