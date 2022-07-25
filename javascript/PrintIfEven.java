public class PrintIfEven implements ComparisonOperation {
    public boolean shouldPrint(int element) {
        return element % 2 == 0;
    }
}
