'use strict';

console.log("Hi from api-query.js!");

let swapiForm = document.getElementById("swapi-form");
let swapiResults = document.getElementById("swapi-results");

swapiForm.addEventListener("submit", (event) => {
  // Prevent default form submission
  event.preventDefault();

  // Grab the values input by the user
  let type = swapiForm.swapiType.value;
  let num = swapiForm.idNum.value;
  console.log(`User input received:  ${type}, ${num}`);

  getSwapiObject(type, num, (jsonString) => {
    let swapiObject = JSON.parse(jsonString);
    console.log(swapiObject);

    swapiResults.innerHTML = "";

    //for-in to loop through keys on object
    for(let k in swapiObject) {
      let resultItem = document.createElement("li");
      resultItem.innerText = `${k} : ${swapiObject[k]}`;
      swapiResults.appendChild(resultItem);
    }
  });
});

function getSwapiObject(type, num, onSuccess) {

  // This object is provided by the browser to let us do AJAX
  let xhr = new XMLHttpRequest();

  // We can listen for changes to the "ready state" of the request
  // ready state of 4 means we have the response
  xhr.addEventListener("readystatechange", () => {
    // Here we can do granualar things, but we'll just check for 4
    //console.log(xhr.readyState);
    if(xhr.readyState === xhr.DONE) {
      let response = xhr.response;
      console.log(`Response received: ${response}`);

      // Before we declare victory and call onSuccess, let's
      // check the status code:
      if(xhr.status >= 200 && xhr.status < 300) {
        onSuccess(response);
      } else {
        console.error(`Failure with status ${xhr.status}`);
      }
    }
  });

  // prepares the request for sending
  xhr.open("get", `https://www.swapi.co/api/${type}/${num}`);

  // actually sends the request
  xhr.send();
}