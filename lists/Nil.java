public class Nil implements ImmutableList {
    public Nil() {}

    public boolean equals(final Object other) {
        return other instanceof Nil;
    } // equals
    
    public String toString() {
        return "Nil";
    } // toString

    public int hashCode() {
        return 0;
    } // hashCode

    public int length() { return 0; }
    public int sum() { return 0; }
    public ImmutableList append(final ImmutableList other) {
        // this: an instance of Nil
        return this;
        //return other;
    }
    public boolean contains(final int value) {
        return true;
    }

    // example methods
    public boolean isEmpty() {
        return true;
    }

    // [].addAmount(1) --> []
    // [].addAmount(3) --> []
    // [].addAmount(5) --> []
    public ImmutableList addAmount(final int value) {
        return this; // this: Nil
        //return new Nil(); // also works
    }
} // Nil
    
