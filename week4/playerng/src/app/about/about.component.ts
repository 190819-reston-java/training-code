import { Component, OnInit } from '@angular/core';
import { SecretService } from '../secret.service';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent implements OnInit {

  constructor(private secretService : SecretService) { }

  ngOnInit() {
  }

}
