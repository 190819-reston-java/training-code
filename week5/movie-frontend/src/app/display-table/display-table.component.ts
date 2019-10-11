import { Component, OnInit, Input, OnChanges, Output, EventEmitter } from '@angular/core';
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
  //Use this guy to emit the keys when they change
  @Output()
  keyChange = new EventEmitter();
  templateKeys : any;

  constructor() { }

  ngOnInit() {
    
  }

  ngOnChanges() {
    if(!(this.objects==null)){
      this.templateKeys = Object.keys(this.objects[0]);
      this.keyChange.emit(this.templateKeys);
    }
  }

}
