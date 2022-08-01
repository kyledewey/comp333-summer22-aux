// Expected output:
//
// hi
// hi
// ---
// bye
// bye
// bye
//

function callTimes(numberOfTimesToCall) {
    return function(functionToCall) {
        for (let index = 0; index < numberOfTimesToCall; index++) {
            functionToCall();
        }
    };
}

function printHi() {
    console.log("hi");
}

function printBye() {
    console.log("bye");
}

// callTimes is a function that takes one parameter
//   -Returns a function that takes one parameter
//      -The parameter is a function that takes no parameters
let callTwo = callTimes(2);
let callThree = callTimes(3);

callTwo(printHi);
console.log("---");
callThree(printBye);
