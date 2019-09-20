'use strict';

console.log("Hi from DOM.js");

// We're using CSS selectors for convenience
let text = document.querySelector("#main-text");
let demoDiv = document.querySelector(".dom-demo");
let button = document.querySelector(".btn");

let clickerCounter = 0;

// Most DOM manipulation happens in callbacks:
button.addEventListener("click", ()=>{
  clickerCounter++;
  text.innerText = `Button has been clicked ${clickerCounter} times`;
});

// Make elements using document
let newButton = document.createElement("button");
newButton.innerText = "Reset Counter";
newButton.addEventListener("click", ()=>{
  clickerCounter = 0;
  text.innerText = "Counter was reset";
});

// Need to append new elements for them to appear
demoDiv.appendChild(newButton);