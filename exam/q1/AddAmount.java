public class AddAmount implements IntToIntOp {
    private final int savedValue;
    public AddAmount(int value) {
        savedValue = value;
    }
    
    public int apply(int value) {
        return value + savedValue;
    }
}
