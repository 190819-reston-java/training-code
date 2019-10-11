import { debugUser } from './../../core/user-session';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserSession } from 'src/app/core/user-session';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private http: HttpClient) { }

  adminLogin(): boolean {
    localStorage.setItem('user', JSON.stringify(debugUser));
    return true;
  }

  async attemptLogin(un: string, pw: string): Promise<boolean> {
    try {
      const user: UserSession = await this.http.post<UserSession>(environment.loginUrl, { username: un, password: pw }).toPromise();
      await localStorage.setItem('user', JSON.stringify(user));
      return true;
    } catch (err) {
      console.log(err);
      return false;
    }
  }

  logout(): boolean {
    try {
      localStorage.removeItem('user');
      return true;
    } catch (err) {
      return false;
    }
  }
}
