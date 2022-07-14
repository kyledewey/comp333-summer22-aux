// Program: reads input from user determining where to write
// Does some calculation
// Prints the output of this calculation to wherever the user said
//
// Change: get continual status during the computation
// Change: add support for network connections
public class Main {
    // does some computation
    // takes a LONG time, lots of intermediate results
    //
    // Bad things:
    // -Big chunk of code is repeated
    // -Loses work if process stops unexpectedly
    // -Unhandled exceptions
    // -Extra parameter (if userWantsConsole is true, fileToWriteTo makes no sense)
    // -File needs to stay open
    public static int doComputation(Writer writer) throws IOException {
        // ...
        int intermediateValue = ...;
        // TODO: should be in a loop
        writer.writeThing(intermediateValue);

        return ...;
    }

    // returns the file the user wants to write to,
    // or null if they don't want to write to a file
    public static String fileUserWants(String[] args) {
        // ...
    }

    // Polymorphism
    // 1.) Ad-hoc polymorphism (virtual dispatch / dynamic dispatch)
    // 2.) Subtyping polymorphism (ConsoleWriter is a Writer)
    // 3.) Parametric polymorphism (later - Swift)
    //
    public static Writer makeWriter(String[] args) {
        if (doesUserWantConsole(args)) {
            // ConsoleWriter is a subtype of Writer
            // subtyping polymorphism
            return new ConsoleWriter();
        } else if (doesUserWantNetwork(args)) {
            // subtyping polymorphism
            return new NetworkWriter(ipAddressUserWants(args));
        } else {
            // subtyping polymorphism
            return new FileWriter(fileUserWants(args));
        }
    }
    
    public static void main(String[] args) throws IOException {
        Writer writer = makeWriter(args);
        int value = doComputation(writer);

        // at runtime, the correct version of writeThing is chosen in O(1)
        // uses ad-hoc polymorphism (AKA virtual dispatch)
        writer.writeThing(value);
    }
}
