public class Cons implements ImmutableList {
    public final int head;
    public final ImmutableList tail;
    public Cons(final int head, final ImmutableList tail) {
        this.head = head;
        this.tail = tail;
    }
    public int countMatches(Matcher matcher) {
        // recursive call
        int restCount = tail.countMatches(matcher);
        if (matcher.isMatch(head)) {
            // add 1
            return restCount + 1;
        } else {
            // use as-is
            return restCount;
        }
    }
}
