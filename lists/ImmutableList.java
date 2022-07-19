// what toString, hashCode, equals do? - hit yes
//
// -toString: converts an object to a String
// -hashCode: converts an object to an integer; - using hash tables
// know what a hash table is - hit yes
// -equals: compares two objects; returns true if they are equal, else false
public interface ImmutableList {
    public boolean equals(final Object other);
    public String toString();
    public int hashCode();

    // NOT provided:
    public int length();
    public int sum(); // empty list sum is defined as 0
    public ImmutableList append(final ImmutableList other);
    public boolean contains(final int value);

    // example methods
    public boolean isEmpty();

    // new Cons(1, new Cons(2, new Cons(3, new Nil()))).addAmount(5)
    // ^ equivalent
    // [].addAmount(3) --> []
    // [0, 7].addAmount(2) --> [2, 9] ([0 + 2, 7 + 2])
    // [1, 2, 3].addAmount(5) --> [6, 7, 8] ([1 + 5, 2 + 5, 3 + 5])
    public ImmutableList addAmount(final int value);
} // ImmutableList
