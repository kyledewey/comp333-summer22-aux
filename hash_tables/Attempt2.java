// restrictions:
// - keys must be integers
public class Attempt2 {
    private final Entry[] entries;

    private class Entry {
        public int key;
        public String value;
        public Entry nextEntry;

        public Entry(final int key,
                     final String value,
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
    
    public Attempt2(int size) {
        entries = new Entry[size];
    }

    // returns null if it's not in the map
    public String lookup(int key) {
        // problem: collisions
        // if entries.length == 50, collisions with
        // 49 and 99999 (49 % 50 == 49;
        // 99999 % 50 == 49)
        // int afterMod = key % entries.length;
        // return entries[afterMod];

        int afterMod = key % entries.length;
        Entry entry = entries[afterMod];
        while (entry != null) {
            if (entry.key == key) {
                return entry.value;
            }
            entry = entry.nextEntry;
        }

        return null;
    }

    // return true if it updated
    private boolean updateWithoutAdding(Entry head, int key, String value) {
        while (head != null) {
            if (head.key == key) {
                head.value = value;
                return true;
            } else {
                head = head.nextEntry;
            }
        }

        return false;
    }
    
    public void update(int key, String value) {
        // int afterMod = key % entries.length;
        // entries[afterMod] = value;

        int afterMod = key % entries.length;
        if (!updateWithoutAdding(entries[afterMod], key, value)) {
            entries[afterMod] = new Entry(key, value, entries[afterMod]);
        }
    }

    public void printContents() {
        for (int index = 0; index < entries.length; index++) {
            System.out.println(index + ": " + entries[index]);
        }
    }
    
    public static void main(String[] args) {
        Attempt2 map = new Attempt2(50);
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
}
