public class FileWriter implements Writer {
    // duplicated fileToWriteTo four times
    private final String fileToWriteTo;

    public FileWriter(String fileToWriteTo) {
        this.fileToWriteTo = fileToWriteTo;
    }

    // duplicated this one line
    public void writeThing(int valueToWrite) throws IOException {
        File file = new File(fileToWriteTo);
        FileOutputStream stream = new FileOutputStream(file, append=true);
        stream.writeln(valueToWrite);
        stream.close();
    }
}
