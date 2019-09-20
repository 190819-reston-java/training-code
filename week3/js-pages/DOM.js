'use strict';

console.log("Hi from DOM.js");

// We're using CSS selectors for convenience
let text = document.querySelector("#main-text");
let demoDiv = document.querySelector(".dom-demo");
let button = document.querySelector(".btn");

let clickerCounter = 0;
let hasBeenClicked = false;

// Make elements using document
let newButton = document.createElement("button");
newButton.innerText = "Reset Counter";
// array with single string: btn
// sets the class to btn to use Bootstrap button:
newButton.classList = ["btn"];
newButton.addEventListener("click", () => {
  clickerCounter = 0;
  text.innerText = "Counter was reset";
});

// Most DOM manipulation happens in callbacks:
button.addEventListener("click", () => {
  clickerCounter++;
  text.innerText = `Button has been clicked ${clickerCounter} times`;

  if(!hasBeenClicked) {
    hasBeenClicked = true;
    // Need to append new elements for them to appear
    demoDiv.appendChild(newButton);
  }
});

let toggle = false;
demoDiv.addEventListener("mouseover", () => {
  toggle = !toggle;
  if (toggle) {
    demoDiv.style.backgroundColor = "white";
  } else {
    demoDiv.style.backgroundColor = "blanchedalmond";
  }
});