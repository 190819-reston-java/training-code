import { AuthorizationService } from './../../../core/authorization.service';
import { AuthenticationService } from './../authentication.service';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {
    submitted = false;

    constructor(
        private router: Router,
        private authenticationService: AuthenticationService,
        private authorizationService: AuthorizationService,
    ) {
    }

    ngOnInit() {
    }

    debugSubmit() {
        this.submitted = true;
        this.authenticationService.adminLogin();
    }
}