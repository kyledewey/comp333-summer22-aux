import java.util.ArrayList;

// Key and Value are type variables
public class Attempt4<Key, Value> {
    private final ArrayList<Entry> entries;

    private class Entry {
        public Key key;
        public Value value;
        public Entry nextEntry;

        public Entry(final Key key,
                     final Value value,
                     final Entry nextEntry) {
            this.key = key;
            this.value = value;
            this.nextEntry = nextEntry;
        }

        public String toString() {
            return ("Entry(" + key + ", " +
                    value + ", " +
                    nextEntry + ")");
        }
    }
    
    public Attempt4(int size) {
        // entries = new Entry[size];
        entries = new ArrayList<Entry>(size);
        while (size > 0) {
            entries.add(null);
            size--;
        }
        
    }

    public Value lookup(Key key) {
        int afterMod = Math.abs(key.hashCode()) % entries.size();
        Entry entry = entries.get(afterMod);
        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.nextEntry;
        }

        return null;
    }

    // return true if it updated
    private boolean updateWithoutAdding(Entry head, Key key, Value value) {
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return true;
            } else {
                head = head.nextEntry;
            }
        }

        return false;
    }

    public void update(Key key, Value value) {
        int afterMod = Math.abs(key.hashCode()) % entries.size();
        if (!updateWithoutAdding(entries.get(afterMod), key, value)) {
            entries.set(afterMod,
                        new Entry(key, value, entries.get(afterMod)));
        }
    }

    public void printContents() {
        for (int index = 0; index < entries.size(); index++) {
            System.out.println(index + ": " + entries.get(index));
        }
    }

    public static void attempt2MainPorted() {
        Attempt4<Integer, String> map = new Attempt4<Integer, String>(50);
        map.update(0, "foo");
        map.update(49, "bar");
        map.update(99999, "baz");

        System.out.println(map.lookup(0));
        System.out.println(map.lookup(49));
        System.out.println(map.lookup(99999));

        System.out.println(map.lookup(1));

        System.out.println("internal representation:");
        map.printContents();
    }

    public static void main(String[] args) {
        Attempt4<String, Integer> map = new Attempt4<String, Integer>(5);
        map.update("foo", 0);
        map.update("bar", 49);
        map.update("baz", 99999);
        map.update("alpha", 1);
        map.update("beta", 2);
        map.update("gamma", 3);
        map.update("delta", 4);
        map.update("epsilon", 5);

        System.out.println(map.lookup("baz"));
        System.out.println(map.lookup("beta"));
        System.out.println(map.lookup("epsilon"));

        System.out.println(map.lookup("qwerty"));

        System.out.println("internal representation:");
        map.printContents();

        System.out.println("-----");
        System.out.println("Ported attempt 2:");
        attempt2MainPorted();        
    }
}
