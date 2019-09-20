'use strict';

console.log('hello from equality.js!');

//There are two types of equals in js:
// double equals : ==
//      compares value without comparing type
// triple equals : ===
//      compares value and type

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

compare(45, "blue");
compare(45, "45");
compare(1, 1);
compare("", 0);
compare(1, 1.0);
compare(0, {});
compare(null, {});

//Punchline: always use ===
