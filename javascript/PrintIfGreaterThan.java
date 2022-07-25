public class PrintIfGreaterThan implements ComparisonOperation {
    public final int value;

    public PrintIfGreaterThan(final int value) {
        this.value = value;
    }

    public boolean shouldPrint(int element) {
        return element > value;
    }
}
