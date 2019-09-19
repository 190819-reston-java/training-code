'use strict';

console.log("Hello 'from' inside types.js");
console.log('hi from "single" quotes');

//types in JS:
let x; // x is undefined.  Other undefined:
x = undefined; // don't do this
x = {}.name; // object with property
x = "abc"[5]; // access character by index

console.log(x);

//Objects are defined with {}
//key-value pairs, with the keys being strings:

let obj = {
    adam : 3,
    b : "hi",
    c : null,
    d : true
};

//You can try to get or set whatever properties you like
console.log(obj.adam2); //undefined
obj.adam2 = 'what'; //sets property

//There's another way to access properties, by name:
console.log(obj['adam2']);

//functions ARE objects, though typeof will say function
//null is its own type, though typeof will say object
//NaN is a number

//in summation: number, string, boolean, Object,
// null, undefined
//also Symbol, but don't sweat it.
