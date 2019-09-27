import { Component, OnInit } from '@angular/core';
import { PlayerHttpService } from '../player-http.service';
import { Player } from '../player';

@Component({
  selector: 'app-players-table',
  templateUrl: './players-table.component.html',
  styleUrls: ['./players-table.component.css']
})
export class PlayersTableComponent implements OnInit {

  players : Player[] = [];

  constructor(private playerHttp : PlayerHttpService) { }

  //This guy is a lifecycle hook.  We have 7(?) to granularly
  // setup and teardown component
  ngOnInit() {
    this.playerHttp.getPlayers().subscribe(
      (data)=>{console.log(data);},
      console.error
    );
  }

}
