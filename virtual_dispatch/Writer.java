public interface Writer {
    public void writeThing(int valueToWrite) throws IOException;
}


    /*
    // N number of destinations
    // N space to save ALL destinations
    private final boolean userWantsConsole;
    private final boolean userWantsNetwork;
    private final String fileToWriteTo;
    private final String ipAddress;

    // no-args: write to console
    public Writer() {
        userWantsConsole = true;
        userWantsNetwork = false;
        fileToWriteTo = null;
        ipAddress = null;
    }

    public Writer(File file) { ... }
    public Writer(IpAddress ipAddres) { ... }
    
    public Writer(boolean userWantsConsole,
                  boolean userWantsNetwork,
                  String fileToWriteTo,
                  String ipAddress) {
        this.userWantsConsole = userWantsConsole;
        this.userWantsNetwork = userWantsNetwork;
        this.fileToWriteTo = fileToWriteTo;
        this.ipAddress = ipAddress;
    }
    
    public void writeThing(int valueToWrite) throws IOException {
        // N number of destinations
        // writeThing: O(N) to figure out which destination to write to ALWAYS
        if (userWantsConsole) {
            System.out.println(valueToWrite);
        } else if (userWantsNetwork) {
            // use ipAddress to make a socket...
        } else {
            File file = new File(fileToWriteTo);
            FileOutputStream stream = new FileOutputStream(file, append=true);
            stream.writeln(valueToWrite);
            stream.close();
        }
    }
    }*/
