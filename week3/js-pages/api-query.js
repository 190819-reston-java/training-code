'use strict';

console.log("Hi from api-query.js!");

let swapiForm = document.getElementById("swapi-form");

swapiForm.addEventListener("submit", (event) => {
  // Prevent default form submission
  event.preventDefault();

  // Grab the value input by the user
  let num = swapiForm.personNum.value;
  console.log(`User input received: ${num}`);

  getSwapiPerson(num, (jsonString) => {
    let swapiPerson = JSON.parse(jsonString);
    console.log(swapiPerson);
  });

});

function getSwapiPerson(num, onSuccess) {
  // demo passing around functions:
  // onSuccess(`{"num":${num}}`);

  // This object is provided by the browser to let us do AJAX
  let xhr = new XMLHttpRequest();

  // We can listen for changes to the "ready state" of the request
  // ready state of 4 means we have the response
  xhr.addEventListener("readystatechange", () => {
    // Here we can do granualar things, but we'll just check for 4
    if(xhr.readyState === 4) {
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
  xhr.open("get", `https://www.swapi.co/api/people/${num}`);

  // actually sends the request
  xhr.send();
}