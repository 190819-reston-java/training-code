'use strict';

let demo = document.getElementById("demo");

fetch("/playerwebapp/api/players")
  .then(console.log);