import { Component, OnInit } from '@angular/core';
import { MovieHttpService } from '../movie-http.service';

@Component({
  selector: 'app-directors-dash',
  templateUrl: './directors-dash.component.html',
  styleUrls: ['./directors-dash.component.css']
})
export class DirectorsDashComponent implements OnInit {

  directorList : any;
  formInputs : any[];

  constructor(private movieHttp : MovieHttpService) { }

  ngOnInit() {
    this.movieHttp.getDirectors().subscribe(
      (data)=>{
        this.directorList = data;
      },
      console.error
    );
  }
  
  handleKeyChange(event) {
    this.formInputs = event;
  }

}
