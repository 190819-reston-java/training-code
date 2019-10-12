import { Router } from '@angular/router';
import { Role, roles } from './role';
import { UserSession } from './user-session';
import { Injectable } from '@angular/core';

// This authorization service essentially just sits on top of
// LocalStorage, and retrieves users/JWTs as approrpriate.

@Injectable({
  providedIn: 'root'
})
export class AuthorizationService {

  constructor(private router: Router) { }

  // probably should not be used outside of this class -- if i loop back around here
  // i'll make it private
  getUser(): UserSession {
    const user: UserSession = JSON.parse(localStorage.getItem('user'));
    if (user) {
      return user;
    } else {
      return null;
    }
  }

  getRole(): Role {
    const user: UserSession = this.getUser();
    if (user) {
      return user.role;
    } else {
      return roles.NOAUTH;
    }
  }

  getToken(): string {
    const user: UserSession = this.getUser();
    if (user) {
      return user.token;
    } else {
      return null;
    }
  }

  checkLogin(): void {
    const user: UserSession = this.getUser();
    if (!user) {
      this.router.navigate(['/login']);
    }
  }

}
