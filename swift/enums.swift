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

// public class ListNode {
//   public int value;
//                     Node = Node | null;
//   public Node rest; // rest is null if the rest of the list is empty
// }

indirect enum BinaryTree {
    case Root(BinaryTree, Int, BinaryTree)
    case Leaf
}

let tree: BinaryTree =
  BinaryTree.Root(BinaryTree.Root(BinaryTree.Leaf, 2, BinaryTree.Leaf),
                  5,
                  BinaryTree.Root(BinaryTree.Leaf, 7, BinaryTree.Leaf));

//
// Type theory: theory of types.  int, String, boolean, ...
//  |
//  Equivalent to logic.
//  |
//  Product types (holds multiple things at the same time) - AND
//    |
//    Classes (multiple instance variables)
//  |
//  Sum types (you have exactly one thing among a choice of things) - OR
//    |
//    Algebraic data types
//

// monomorphization
// public interface BinaryTree {
//   public int sum();
// }
// public class Root implements BinaryTree {
//   public final int value;
//   public final BinaryTree left;
//   public final BinaryTree right;
//   public Root(final int value, final BinaryTree left, final BinaryTree right) {
//     this.value = value;
//     this.left = left;
//     this.right = right;
//   }
//   public int sum() {
//     return value + left.sum() + right.sum();
//   }
// }
// public class Leaf implements BinaryTree {
//   public int sum() {
//     return 0;
//   }
// }
//
// arr:
// 0: address of case 0
// 1: address of case 1
// 2: address of case 2
// ...
//
// jump arr[my_value]
//
// switch my_value {
//   case 0:
//   case 1:
//   case 2: ...
// }
func sum(node: BinaryTree) -> Int {
    switch node {
    case let .Root(.Leaf, 5, .Root(let innerValue, _, _)):
        // if (node instanceof Root) {
        //   Root nodeAsRoot = (Root)node;
        //   if (nodeAsRoot.left instanceof Leaf &&
        //       nodeAsRoot.value == 5 &&
        //       nodeAsRoot.right == Root) {
        //     int innerValue = ((Root)nodeAsRoot.right).value;
        //   
        
    case let .Root(leftTree, value, rightTree):
        return value + sum(node: leftTree) + sum(node: rightTree)
    case .Leaf: return 0;
    }
}

print(sum(node: tree))

// switch sum{
// case .Branch( let root1, let val, let root2):
//     return(root1.sum + val + root2.sum)
    
// case .Leaf:
//     return 0
// }
