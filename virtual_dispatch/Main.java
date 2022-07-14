// Program: reads input from user determining where to write
// Does some calculation
// Prints the output of this calculation to wherever the user said
//
// Change: get continual status during the computation
// Change: add support for network connections
public class Main {
    public static void writeThing(boolean userWantsConsole,
                                  String fileToWriteTo,
                                  int valueToWrite) throws IOException {
        if (userWantsConsole) {
            System.out.println(valueToWrite);
        } else {
            File file = new File(fileToWriteTo);
            FileOutputStream stream = new FileOutputStream(file, append=true);
            stream.writeln(valueToWrite);
            stream.close();
        }
    }

    // does some computation
    // takes a LONG time, lots of intermediate results
    //
    // Bad things:
    // -Big chunk of code is repeated
    // -Loses work if process stops unexpectedly
    // -Unhandled exceptions
    // -Extra parameter (if userWantsConsole is true, fileToWriteTo makes no sense)
    // -File needs to stay open
    public static int doComputation(boolean userWantsConsole,
                                    String fileToWrite) throws IOException {
        // ...
        int intermediateValue = ...;
        // TODO: should be in a loop
        writeThing(userWantsConsole, fileToWrite, intermediateValue);

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
        int value = doComputation(userWantsConsole, fileToWrite);

        writeThing(userWantsConsole, fileToWrite, value);
    }
}
