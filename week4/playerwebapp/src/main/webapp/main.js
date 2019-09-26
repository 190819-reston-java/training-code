'use strict';

const BASE_URL = "/playerwebapp/api";
const PLAYER_URL = `${BASE_URL}/players`;

let singlePlayerGet = document.getElementById("single-player-get");
let createPlayer = document.getElementById("create-player");
let updatePlayer = document.getElementById("update-player");
let playerDisplay = document.getElementById("player-display");
let getAllPlayers = document.getElementById("get-all-players");

getAllPlayers.addEventListener("click", (event)=>{
  fetch(PLAYER_URL, { method: "GET" })
      .then((response)=>{
        return response.json();
      })
      .then((playersJson)=>{
        clearDisplay();
        for(let player in playersJson) {
          console.log(playersJson[player]);
          createLi(playersJson[player]);
        }
      })
      .catch(console.log);
});

singlePlayerGet.addEventListener("submit", (event)=>{
  event.preventDefault();

  let playerId = singlePlayerGet.playerId.value;
  fetch(`${PLAYER_URL}/${playerId}`)
      .then((response)=>{
        return response.json();
      })
      .then((playerJson)=>{
        clearDisplay();
        createLi(playerJson);
      })
      .catch((error)=> {
        console.error(error);
        alert(`Failed to find player : ${playerId}`);
      });
});

createPlayer.addEventListener("submit", (event)=>{
  event.preventDefault();
  console.log(playerFromForm(createPlayer));
  fetch(PLAYER_URL,
      { method: "POST", body: JSON.stringify(playerFromForm(createPlayer)) }
      )
      .then((response)=> {
        console.log(response);
        if(response.status >= 200 && response.status < 300) {
          alert("Player created");
        } else {
          alert("Failed to create player");
        }
      })
      .catch(console.error);
});

updatePlayer.addEventListener("submit", (event) => {
  event.preventDefault();
  fetch(PLAYER_URL,
    { method: "PUT", body: JSON.stringify(playerFromForm(updatePlayer))}
    )
    .then((response) => {
      if(response.status >= 200 && response.status < 300) {
        alert("Player updated");
      } else {
        alert("Failed to update player");
      }
      updatePlayer.hidden = true;
    })
})

let playerFromForm = (form) => {
  let player = {};
  player.name = form.name.value || "Default Name";
  player.num = form.num.value || 0;
  player.position = form.position.value || 'RF';
  player.battingAverage = form.battingAverage.value || 0.3;
  player.id = form.id.value || 0;
  return player;
}

let clearDisplay = () => {
  playerDisplay.innerHTML = "";
}

let createLi = (player) => {
  let li = document.createElement("li");
  li.innerText = `${player.name} : Number ${player.num}, ${player.position}`;
  li.addEventListener("click", () => {
    updatePlayer.id.value = player.id;
    updatePlayer.name.value = player.name;
    updatePlayer.num.value = player.num;
    updatePlayer.battingAverage.value = player.battingAverage;
    updatePlayer.position.value = player.position;
    updatePlayer.hidden = false;
    clearDisplay();
  });
  playerDisplay.append(li);
}