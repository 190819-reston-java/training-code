import { Component, OnInit, Input, OnChanges } from '@angular/core';
import { MovieHttpService } from '../movie-http.service';

@Component({
  selector: 'app-table-based-form',
  templateUrl: './table-based-form.component.html',
  styleUrls: ['./table-based-form.component.css']
})
export class TableBasedFormComponent implements OnInit, OnChanges {

  @Input()
  formInputs: any[];
  model: any = {};

  constructor(private movieHttp: MovieHttpService) { }

  onSubmit() {
    this.movieHttp.postDirector(JSON.stringify(this.model))
        .subscribe(console.log, console.error);
    this.model = {};
  }

  clear() {
    this.model = {};
  }

  ngOnInit() {
  }

  ngOnChanges() {
  }

}
