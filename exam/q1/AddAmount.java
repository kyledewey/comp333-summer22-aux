// struct AddAmount: public IntToIntOp {
//   ...
// }
//
// class AddAmount: public IntToIntOp {
//   ...
// }
//public class AddAmount implements IntToIntOp {
public class AddAmount extends IntToIntOp {
    private final int savedValue;
    public AddAmount(int value) {
        savedValue = value;
    }
    
    public int apply(int value) {
        return value + savedValue;
    }
}
