import { Component, OnInit, Input, OnChanges } from '@angular/core';
import { MovieHttpService } from '../movie-http.service';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-display-table',
  templateUrl: './display-table.component.html',
  styleUrls: ['./display-table.component.css']
})
export class DisplayTableComponent implements OnInit, OnChanges {

  @Input("objects")
  objects : any = [
    {"name":"default", "num":3},
    {"name":"adam", "num":4}
    ];
  templateKeys : any;

  constructor() { }

  ngOnInit() {
    
  }

  ngOnChanges() {
    this.templateKeys = Object.keys(this.objects[0]);
  }

}
