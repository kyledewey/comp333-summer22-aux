public class Writer {
    private boolean userWantsConsole;
    private boolean userWantsNetwork;
    private String fileToWriteTo;
    private String ipAddress;
    
    public class Writer(boolean userWantsConsole,
                        boolean userWantsNetwork,
                        String fileToWriteTo,
                        String ipAddress) {
        this.userWantsConsole = userWantsConsole;
        this.userWantsNetwork = userWantsNetwork;
        this.fileToWriteTo = fileToWriteTo;
        this.ipAddress = ipAddress;
    }
    
    public void writeThing(int valueToWrite) throws IOException {
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
}
