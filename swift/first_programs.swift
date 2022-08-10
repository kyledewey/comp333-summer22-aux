// types you must declare
// - Parameter types
// - Return types
// - Instance variable types
// - Types in an enum
// 
// Java equivalent:
// public static int myFunction() { ... }
func myFunction() -> Int { // declaring a function
    // Swift is statically typed - using type inference
    // Swift has semicolon inference
    let temp: Int = 18
    return temp
}

// Java equivalent:
// public static void printInt(int value) { ... }
// formal parameter name: value
func printInt(value: Int) {
    print(value)
}

// main starts whenever you drop out of a function
// result is type inferrred to be Int
let result = myFunction()
print(result)

// actual parameter: 5
// by default: formal parameter needs to be passed along
printInt(value: 5)

// external parameter name: param
// internal parameter name: b
func printBool(param b: Bool) {
    print(b)
}

printBool(param: true)

// _: external name is fully omitted
func printString(_ s: String) {
    print(s)
}

printString("hello")

func printChar(_ c: Character) {
    print(c)
}

printChar("a")

func foobar(
  value: Int,
  ifGreaterThan: Int,
  returnThis: Int,
  otherwiseReturn: Int) -> Int {
    if (value > ifGreaterThan) {
        return returnThis
    } else {
        return otherwiseReturn
    }
}

// func append(s1: String, s2: String) -> String { ... }

// swift supports higher-order functions
//
// (Character) -> Void: a function that takes a Character and returns
// Void
let f1: (Character) -> Void = printChar
f1("b")

// (Int, Int) -> Int: a function type, takes two Ints, returns an Int
//
// add: (Int, Int) -> Int   add is of the above type
//
// { (x, y) in x + y }: function that takes two Ints, adds them,
// and returns the result.  Equivalent to (JS): (x, y) => x + y, or:
// function (x, y) { return x + y; }
//
//let add: (Int, Int) -> Int = { (x, y) in x + y }

// <T>(T, T) -> T
// <A,B,C>(A, B) -> C; want: for some type A, for some type B, for some type C
//                     have: for all types A, for all types B, for all types C
let add = { (x, y) in x + y }; // Swift has local type inference
print(add(3, 4))
