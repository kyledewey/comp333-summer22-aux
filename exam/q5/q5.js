// Expected output:
//
// hi
// hi
// ---
// bye
// bye
// bye
//

function callTimesHelper(thisFunction, remainingTimes) {
    if (remainingTimes > 0) {
        thisFunction();
        callTimesHelper(thisFunction, remainingTimes - 1);
    }
}

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
// function(functionToCall) {
//     for (let index = 0; index < 2; index++) {
//         functionToCall();
//     }
// };

let callThree = callTimes(3);
// function(functionToCall) {
//     for (let index = 0; index < 3; index++) {
//         functionToCall();
//     }
// };

callTwo(printHi);
// function being called:
// function(functionToCall) {
//     for (let index = 0; index < 2; index++) {
//         printHi();
//     }
// };
//
// parameter:
// function printHi() {
//    console.log("hi");
//}


console.log("---");
callThree(printBye);
