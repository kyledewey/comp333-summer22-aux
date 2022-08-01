// expected output:
//
// 5
// 2
// 7
// 9
// ----
// ----
// 8
// 5
// 10
// 12

public class MissingComponents {
    public static void forEach(int[] input, IntToVoidOp op) {
        for (int index = 0; index < input.length; index++) {
            int element = input[index];
            op.apply(element);
        }
    }
    
    public static int[] map(int[] input, IntToIntOp op) {
        int[] retval = new int[input.length];
        for (int index = 0; index < retval.length; index++) {
            int element = input[index];
            int curResult = op.apply(element);
            retval[index] = curResult;
        }
        return retval;
    }
    
    public static void main(String[] args) {
        int[] array1 = new int[]{ 5, 2, 7, 9 };
        // needed: AddAmount class
        //   -Needs to extend / implement IntToIntOp
        //   -Constructor that takes an integer
        // needed: PrintValue class
        //   -Needs to extend / implement IntToVoidOp
        //   -Constructor that takes no parameters
        // needed: IntToIntOp class / interface
        //   -Needs an apply method, takes an int, returns int
        // needed: IntToVoidOp class / interface
        //   -Needs an apply method, takes an int, returns void
        IntToIntOp addAmount = new AddAmount(3);
        IntToVoidOp printValue = new PrintValue();

        forEach(array1, printValue);
        System.out.println("----");
        System.out.println("----");

        int[] array2 = map(array1, addAmount);
        forEach(array2, printValue);
    }
}
