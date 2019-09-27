import { Component, OnInit } from '@angular/core';
import { SecretService } from '../secret.service';

@Component({
  selector: 'app-secret-page',
  templateUrl: './secret-page.component.html',
  styleUrls: ['./secret-page.component.css']
})
export class SecretPageComponent implements OnInit {

  //Dependency inject SecretService:
  // you need the private, you need the type, the name can change
  constructor(private secretService : SecretService) { }

  ngOnInit() {
    console.log(this.secretService.getClearance());
  }

}
