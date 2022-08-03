public class IntToIntOp {
    public int apply(int value) {
        // body doesn't matter
        return 0;
    }
}

// fails to compile:
//  IntToIntOp myOp = new IntToIntOp();
//  myOp.apply(123); // apply isn't defined
public abstract class IntToIntOp {
    public abstract int apply(int value);
}

public abstract class Foo extends IntToIntOp {}

public interface IntToIntOp {
    public int apply(int value);
}
