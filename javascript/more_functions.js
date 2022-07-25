// higher-order functions, closures, lambdas, anonymous functions, all same thing

// first-order function: defined at toplevel


// equivalent to:
// printAllMatching = function (arr, shouldPrint) { ... };
function printAllMatching(arr, shouldPrint) {
    for (let index = 0; index < arr.length; index++) {
        let element = arr[index];
        // shouldPrint: (elem) => elem > value
        if (shouldPrint(element)) {
            console.log(element);
        }
    }
}

function printAllRefactored1(arr) {
    // anonymous function: has no name
    // functions are data that can be assigned to variables
    // variables can hold functions
    // f: holding this function
    let f = function (elem) {
        // in printAllMatching, elem will be element
        return true;
    };

    // passes f (the function) to printAllMatching
    // in printAllMatching: shouldPrint is the same function as f
    printAllMatching(arr, f);
}

function printAllRefactored2(arr) {
    printAllMatching(arr,
                     function (elem) {
                         return true;
                     });
}

function printAllRefactored3(arr) {
    // when (elem) => true is used, it's equivalent to
    // function (elem) { return true; }
    printAllMatching(arr, (elem) => true);
}

function printAll(arr) {
    // index++: side-effect (mutation)
    for (let index = 0; index < arr.length; index++) {
        let element = arr[index];
        // printing something out (I/O): side-effect
        if (true) {
            console.log(element); // Node's printf / cout / System.out.println
        }
    }
    // return "hello";
}

function printAllLessThanRefactored(arr, value) {
    // Order of calls:
    // 1.) printAllLessThanRefactored
    //        |
    //        printAllMatching
    //           |
    //           (elem) => elem < value (called once for each array element)
    printAllMatching(arr, (elem) => elem < value);
}

function printAllLessThan(arr, value) {
    for (let index = 0; index < arr.length; index++) {
        let element = arr[index];
        if (element < value) {
            console.log(element);
        }
    }
}

function printAllGreaterThanRefactored(arr, value) {
    // when function made: value must be saved somewhere in memory
    // when a function must save a value: closure (said to "close over"
    // another value / variable)
    printAllMatching(arr, (elem) => elem > value);
}

function printAllGreaterThan(arr, value) {
    for (let index = 0; index < arr.length; index++) {
        let element = arr[index];
        if (element > value) {
            console.log(element);
        }
    }
}

function printAllEvensRefactored(arr) {
    printAllMatching(arr, (elem) => elem % 2 == 0);
}

function printAllEvens(arr) {
    for (let index = 0; index < arr.length; index++) {
        let element = arr[index];
        if (element % 2 == 0) {
            console.log(element);
        }
    }
}

function foo() {
    return 17;
}

function isEven(value) {
    return value % 2 == 0;
}
