public class PrintIfLessThan implements ComparisonOperation {
    public final int value;

    public PrintIfLessThan(final int value) {
        this.value = value;
    }

    public boolean shouldPrint(int element) {
        return element < value;
    }
}

