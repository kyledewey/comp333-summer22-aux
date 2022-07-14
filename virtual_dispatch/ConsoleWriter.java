public class ConsoleWriter implements Writer {
    public ConsoleWriter() {}
    
    // one line of duplication
    public void writeThing(int valueToWrite) throws IOException {
        System.out.println(valueToWrite);
    }
}
