public class IsOdd implements Matcher {
    public boolean isMatch(int value) {
        return value % 2 != 0;
    }
}
