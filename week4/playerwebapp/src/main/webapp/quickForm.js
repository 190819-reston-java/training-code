'use strict';

let demo = document.getElementById("demo");

fetch("/playerwebapp/api/players")
  //chained thens are typical in Promises
  .then((response)=>{
    //.json returns a promise for the object produced from JSON
    return response.json();
  })
  .then((playerJson)=> {
    demo.innerText = playerJson;
  })
  .catch(console.log);

  // fetch("/playerwebapp/api/players", { method: "POST" })
