import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Player } from './player';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PlayerHttpService {

  constructor(private http : HttpClient) { }

  // Returns an Observable of Player arrays
  getPlayers() : Observable<Player[]> {
    return this.http.get<Player[]>(
      "http://localhost:8080/playerwebapp/api/players"
    );
  }

}
