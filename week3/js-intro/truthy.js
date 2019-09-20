'use strict';

function convertToBool(x) {
    //explicit conversion to boolean
    console.log(`${x} as boolean: ${Boolean(x)}`);
}

convertToBool(3 === 2);
convertToBool(1);
convertToBool(null);
convertToBool(undefined);
convertToBool(30);
convertToBool(-2);
convertToBool("");
convertToBool("adam");
convertToBool("   ");
convertToBool(Infinity/-Infinity);
convertToBool({});
convertToBool([]);
convertToBool(NaN);
convertToBool({ name:"myObj" });

//falsy values:
//null
//undefined
//""
//false
//NaN
//0
//-0 (dont use this)

//everything else is truthy