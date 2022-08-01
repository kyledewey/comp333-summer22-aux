public class PrintValue implements IntToVoidOp {
    public PrintValue() {}
    public void apply(int value) {
        System.out.println(value);
    }
}
