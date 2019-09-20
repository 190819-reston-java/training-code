'use strict';

console.log("hi from closure.js");

let button = document.querySelector(".btn");
let clickDisplay = document.querySelector("#click-display");

// let clickCount = 0;

// button.addEventListener("click", () => {
//   clickCount++;
//   clickDisplay.innerText =
//      `This has been clicked ${clickCount} times`;
// });

// Closure in 3 parts: outer f, inner f, variable to close over
let outerFunction = () => {
  let count = 0;
  let incrementCount = () => {
    return ++count;
  }
  return incrementCount;
}

// Control access to count, but don't control access
//  to closureClickCounter
const closureClickCounter = outerFunction();

button.addEventListener("click", () => {
  clickDisplay.innerText =
      `This has been clicked ${closureClickCounter()} times`;
});

const secondCounter = outerFunction();
console.log(secondCounter());

let makeNounCounter = (noun) => {
  let count = 0;
  let nounCounter = () => {
    return `${noun} count is : ${++count}`;
  }
  return nounCounter;
};

let fruitCounter = makeNounCounter("Fruit");

console.log(fruitCounter());
console.log(fruitCounter());
console.log(fruitCounter());

//Getter and Setter that enforces same type
let makeGetterSetter = (startValue) => {
  let field = startValue;
  const type = typeof startValue;
  let getter = () => {
    return field;
  }
  let setter = (newField) => {
    if(typeof newField === type) {
      field = newField;
    }
  }
  return [getter, setter];
}