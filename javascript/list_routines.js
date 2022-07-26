// functional programming languages: need higher-order functions
//   - Discourage loops, or don't have them at all
//      - Forced into recursion
//   - ...hardly ever use recursion

// map is like this, but saves results
function forEachExample(arr, operation) {
    for (let index = 0; index < arr.length; index++) {
        let element = arr[index];
        // do something with the element
        operation(element);
    }
}

// predicate: function that returns a boolean
function filterExample(arr, predicate) {
    for (let index = 0; index < arr.length; index++) {
        let element = arr[index];
        if (predicate(element)) {
            // save the element
        } else {
            // discard the element
        }
    }
}

// add all array elements together
function sum(arr) {
    let retval = 0;
    for (let index = 0; index < arr.length; index++) {
        let element = arr[index];
        retval = retval + element;
    }
    return retval;
}

// multiply all array elements together
function product(arr) {
    let retval = 1;
    for (let index = 0; index < arr.length; index++) {
        let element = arr[index];
        retval = retval * element;
    }
    return retval;
}

function reduce(arr, initialValue, operation) {
    let accumulator = initialValue;
    for (let index = 0; index < arr.length; index++) {
        let element = arr[index];
        accumulator = operation(accumulator, element);
    }
    return accumulator;
}

function sumRefactored(arr) {
    return reduce(arr, 0, (a, e) => a + e);
}

function productRefactored(arr) {
    return reduce(arr, 1, (a, e) => a * e);
}

// foldLeft:  takes an initial value, moves left to right through the array
// foldRight: takes an initial value, moves right to left through the array
// reduceLeft:  doesn't take an initial value, moves left to right through the array
// reduceRight: doesn't take an initial value, moves right to left through the array
