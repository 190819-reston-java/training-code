'use strict';

console.log('hello from equality.js!');

//define a function compare
function compare(a, b) {
    console.log('Comparing ' + a + ' and ' + b + ':');
    //instead we use String interpolation:
    //Uses backticks ` and ${}
    //This does the same as above:
    console.log(`Comparing ${a} and ${b}:`);

    console.log(`a==b : ${a==b}`);
    console.log(`a===b : ${a===b}`);
}

//Punchline: always use ===

//TODO: add examples in script
