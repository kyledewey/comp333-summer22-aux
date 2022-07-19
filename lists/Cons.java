public class Cons implements ImmutableList {
    // ---BEGIN INSTANCE VARIABLES---
    public final int head; // element itself
    public final ImmutableList tail; // rest of the list
    // ---END INSTANCE VARIABLES---

    public Cons(final int head, final ImmutableList tail) {
        this.head = head;
        this.tail = tail;
    } // Cons

    public boolean equals(final Object other) {
        if (other instanceof Cons) {
            final Cons otherCons = (Cons)other;
            return head == otherCons.head && tail.equals(otherCons.tail);
        } else {
            return false;
        }
    } // equals
    
    public String toString() {
        return "Cons(" + head + ", " + tail.toString() + ")";
    } // toString

    public int hashCode() {
        return sum();
    } // hashCode

    // writing method stubs
    public int length() { return 0; }
    public int sum() { return 0; }
    public ImmutableList append(final ImmutableList other) {
        // this: an instance of Cons
        return other;
    }
    public boolean contains(final int value) {
        return true;
    }

    // example methods
    public boolean isEmpty() {
        // this: Cons
        return false;
    }

    // [0, 7].addAmount(2) --> [2, 9] ([0 + 2, 7 + 2])
    //   new Cons(0, new Cons(7, new Nil())) --> new Cons(2, new Cons(9, new Nil()))
    //   new Cons(0, new Cons(7, new Nil())) --> new Cons(2, new Nil()) // end up instead
    // [1, 2, 3].addAmount(5) --> [6, 7, 8] ([1 + 5, 2 + 5, 3 + 5])
    //
    // [5].addAmount(3) --> [8]
    //    new Cons(5, new Nil()) --> new Cons(8, new Nil())
    public ImmutableList addAmount(final int value) {
        // calling on `this`
        int some_element = head + value; // 8
        ImmutableList rest_of_list = this.tail.addAmount(value);
        // if (tail instanceof Cons) {
        //   callConsAddAmount(...);
        // } else if (tail instanceof Nil) {
        //   callNilAddAmount(...);
        // }
        return new Cons(some_element, rest_of_list);
        // return new Cons(head + value, tail.addAmount(value));
    }
} // Cons
