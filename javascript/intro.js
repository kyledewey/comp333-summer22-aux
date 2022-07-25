function foo(x) {
    if (x < 10) {
        return 3;
    } else {
        return "hello";
    }
}

function add(x, y) {
    return x + y;
}

function testFunction() {
    let localVariable = 7; // in scope in testFunction
    if (true) {
        const otherVariable = 8; // in scope in the if
    }
    console.log(otherVariable);
}
