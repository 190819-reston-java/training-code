import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MovieHttpService {

  private MOVIES_URL = "https://my-json-server.typicode.com/AdamRev/moviejson/movies";
  private ACTORS_URL = "https://my-json-server.typicode.com/AdamRev/moviejson/actors";
  private DIRECTORS_URL = "https://my-json-server.typicode.com/AdamRev/moviejson/directors";

  constructor(private http : HttpClient) { }

  getMovies() {
    return this.http.get(this.MOVIES_URL);
  }

  getActors() {
    return this.http.get(this.ACTORS_URL);
  }

  getDirectors() {
    return this.http.get(this.DIRECTORS_URL);
  }

}
