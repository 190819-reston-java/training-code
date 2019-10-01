import { Component, OnInit } from '@angular/core';
import { MovieHttpService } from '../movie-http.service';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-display-table',
  templateUrl: './display-table.component.html',
  styleUrls: ['./display-table.component.css']
})
export class DisplayTableComponent implements OnInit {

  objects : any = [
    {"name":"default", "num":3},
    {"name":"adam", "num":4}
    ];
  templateKeys : any = Object.keys(this.objects[0]);

  constructor(private movieHttp : MovieHttpService, private auth : AuthService) { }

  ngOnInit() {
    this.movieHttp.getMovies().subscribe(
      (data)=>{
        this.templateKeys = Object.keys(data[0]);
        this.objects = data;
      },
      (error)=>{
        console.error(error);
      }
    )
  }

}
