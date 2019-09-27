import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SecretService {

  //declare field and methods like a Java class, more or less
  private clearanceLevel : number = 0;

  incrementClearance(): void {
    this.clearanceLevel++;
  }

  getClearance(): number {
    return this.clearanceLevel;
  }

  constructor() { }
}
