// pseudocode for algebraic data type declaration
//
//                constructor          constructor
// type IntList = Cons(Int, IntList) | Nil;
//
// Scala rough equivalent:
// sealed trait IntList
// case class Cons(head: Int, tail: IntList) extends IntList
// case object Nil extends IntList
//
// Java rough equivalent:
// public interface IntList {}
// public class Cons implements IntList {
//   public final int head;
//   public final IntList tail;
//   public Cons(final int head, final IntList tail) {
//     this.head = head;
//     this.tail = tail;
//   }
// }
// public class Nil implements IntList {}
//
// Key differences:
// 1.) A lot less code
// 2.) Constructor part is hard-coded
// 3.) Fields are unnamed
// 4.) Cons and Nil are NOT types, but constructors for type IntList

// IntList
indirect enum IntList {
    case Cons(Int, IntList)
    case Nil
}

// [1, 2, 3]
let list: IntList = IntList.Cons(1, IntList.Cons(2, IntList.Cons(3, IntList.Nil)));
// let list: IntList = IntList.Nil;

switch list {
case .Cons(let head, _):
    // In Java:
    // System.out.println("Hello: " + 1);
    // implicit type coercion (at compile time):
    // System.out.println("Hello: " + Integer.toString(1))
    
    print("Head: " + String(head))
    //print("Tail: " + String(tail))
case .Nil:
    print("Empty list")
}

// Problem: binary trees can be either:
// - An internal node, holding two subtrees and a value
// - A leaf node, containing no data
//
//       5
//      / \
//     2   7
//    /|   |\
//   X X   X X
//
// 1.) Write the enum declaration for this tree (multiple answers possible)
// 2.) Encode the above tree with these enums
// 3.) Write a function that recursively computes the sum of all the values
//     in the tree.  The sum of a leaf if 0.
