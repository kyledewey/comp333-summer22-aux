public class Main {
    public static void main(String[] args) {
        // [3, 8, 7, 9]
        ImmutableList list =
            new Cons(3, new Cons(8, new Cons(7, new Cons(9, new Nil()))));
        int numEvens = list.countMatches(new IsEven());
        int numOdds = list.countMatches(new IsOdd());
        System.out.println("Num evens: " + numEvens);
        System.out.println("Num odds: " + numOdds);
    }
}
