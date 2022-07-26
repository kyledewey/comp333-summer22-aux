// semicolon inference
function callMe(foo) { // foo is a variable
    console.log("callMe begin") // semicolon should be here
    foo() // calling foo as a function
    console.log("callMe end")
}

// let f = () => console.log("hello"); // creates a function, binds to f 
// callMe(f);

// Write a function named indirectIf which takes a boolean and two functions.
// If the boolean is true, call the first function. Otherwise, call the
// second function.

function indirectIf(someBoolean, first, second) {
    // truthy and falsy
    if (someBoolean) {
        first();
    } else {
        second();
    }
}

function indirectWhile(f1, f2) {
    // while (f1 as condition) {
    //   f2 as some code
    // }
    if (f1()) {
        f2();
        indirectWhile(f1, f2);
    }
}

let x = 0;
function loopBody() {
    console.log(x);
    x++;
}

function returnParam(param) { return param; }

function wrapAdd(takenFunction, integer) {
    return function (param) {
        return takenFunction(param + integer);
    }
}

let f = wrapAdd(returnParam, 5);
// f: function (param) { return returnParam(param + 5); }
let temp1 = f(2);
// returnParam(2 + 5) -> 7

