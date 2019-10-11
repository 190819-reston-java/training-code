import { Component, OnInit } from '@angular/core';
import { MovieHttpService } from '../movie-http.service';

@Component({
  selector: 'app-actors-dash',
  templateUrl: './actors-dash.component.html',
  styleUrls: ['./actors-dash.component.css']
})
export class ActorsDashComponent implements OnInit {

  actorList : any;
  formInputs : any[];

  constructor(private movieHttp : MovieHttpService) { }

  ngOnInit() {
    this.movieHttp.getActors().subscribe(
      (data)=>{
        this.actorList = data;
      },
      console.error
    );
  }

  handleKeyChange(event) {
    this.formInputs = event;
  }

}
