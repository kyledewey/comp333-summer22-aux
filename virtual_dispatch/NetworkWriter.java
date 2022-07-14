public class NetworkWriter implements Writer {
    private final String ipAddress;

    public NetworkWriter(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void writeThing(int valueToWrite) throws IOException {
        // use ipAddress to write to a network location
    }
}
