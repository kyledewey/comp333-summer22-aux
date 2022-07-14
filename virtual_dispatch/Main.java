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
       
    public static void main(String[] args) throws IOException {
        boolean userWantsConsole = doesUserWantConsole(args);
        String fileToWrite = fileUserWants(args);

        // fileToWrite will be null if userWantsConsole = true
        Writer writer = new Writer(userWantsConsole,
                                   doesUserWantNetwork(args),
                                   fileToWrite,
                                   ipAddressUserWants(args));
        int value = doComputation(writer);

        writer.writeThing(value);
    }
}
