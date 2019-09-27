import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-secret-square',
  templateUrl: './secret-square.component.html',
  styleUrls: ['./secret-square.component.css']
})
export class SecretSquareComponent implements OnInit {

  message : string = "Hi from REDACTED :)";

  constructor() { }

  ngOnInit() {
  }

}
