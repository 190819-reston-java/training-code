'use strict';

let innermost = document.getElementById("innermost");
let inner = document.querySelector("#inner");
let outer = document.querySelector("#outer");

let alertClick = (message) => {
  return (event) => { alert(message); };
};

// innermost.addEventListener("click", (event) => {
//     alert("Innermost was clicked : bubble");
//     event.stopPropagation();
// });

innermost.addEventListener("click",
  alertClick("Innermost was clicked : bubble"));

inner.addEventListener("click",
  alertClick("Inner was clicked : bubble"));

outer.addEventListener("click",
  alertClick("Outer was clicked : bubble"));

inner.addEventListener("click",
  alertClick("Inner was clicked : capture"), true);

outer.addEventListener("click",
  alertClick("Outer was clicked : capture"), true);

innermost.addEventListener("click",
  alertClick("Innermost was clicked : capture"), true);