public class PrintingExample {
    // (Person p) -> p.hasName("Alice")
    // hasName takes a String and returns a boolean
    // Java doesn't have this: Person => Boolean
    public static void printAllMatching(int[] array, ComparisonOperation op) {
        for (int index = 0; index < array.length; index++) {
            int element = array[index];
            if (op.shouldPrint(element)) {
                System.out.println(element);
            }
        }
    }

    public static void printAllGreaterThan(int[] array, int value) {
        printAllMatching(array, new PrintIfGreaterThan(value));
    }
}
