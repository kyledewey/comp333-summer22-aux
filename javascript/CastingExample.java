// casting is only needed in statically-typed languages
public class CastingExample {
    public static void integerDoubleCast() {
        double doubleValue = 3.99;
        // does a conversion between two types - work is done in the cast
        int intValue = (int)doubleValue;
        System.out.println(intValue);
    }


    // In JavaScript:
    // let foo = new Object();
    // let fooAsString = foo.toString();
    public static void classCasting() {
        //Object foo = "hello";
        Object foo = new Object();

        // at runtime - check if foo is a String.  If so, just return the
        // value (don't do anything else).  If foo is NOT a String, throw
        // an exception.  Example of strong typing in action.
        String fooAsString = (String)foo;
        System.out.println(fooAsString.charAt(0));
    }
    
    public static void main(String[] args) {
        classCasting();
    }
}
