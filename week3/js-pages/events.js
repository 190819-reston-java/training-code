'use strict';

let innermost = document.getElementById("innermost");
let inner = document.querySelector("#inner");
let outer = document.querySelector("#outer");

let alertClick = (message)=>{
    return (event)=>{alert(message);};
};

innermost.addEventListener("click", (event)=>{
    alert("Innermost was clicked");
    event.stopPropagation();
});

inner.addEventListener("click", alertClick("Inner was clicked"));

outer.addEventListener("click", alertClick("Outer was clicked"));

