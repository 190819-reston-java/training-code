'use strict';

let header = document.getElementById("original-header");

header.innerHTML = "<code>Hello from JavaScript</code>";

header.style.backgroundColor = "blanchedalmond";
header.style.height = "200px";
header.style.width = "200px";

header.addEventListener("mouseout", ()=>{
    console.log("mouseout!");
    console.log(1+2+2+1);

    header.innerText = 
            "has been moused out at least once";
});

header.addEventListener("mouseover", ()=>{
    console.log("mouseenter!");

    header.innerHTML = "<em>mouse entered</em>";
});

header.addEventListener("click", ()=>{
    console.log("click!");

    let newElement = document.createElement("h3");
    newElement.innerText = "I'm new";
    document.body.appendChild(newElement);
})