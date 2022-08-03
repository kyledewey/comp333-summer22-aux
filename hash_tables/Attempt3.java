// keys are Strings
// values are integers
public class Attempt3 {
    private final Entry[] entries;

    private class Entry {
        public String key;
        public int value;
        public Entry nextEntry;

        public Entry(final String key,
                     final int value,
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
    
    public Attempt3(int size) {
        entries = new Entry[size];
    }

    // hashing function (hash code)
    // hashing function: data => int
    public Integer lookup(String key) {
        int afterMod = Math.abs(key.hashCode()) % entries.length;
        Entry entry = entries[afterMod];
        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.nextEntry;
        }

        return null;
    }

    // return true if it updated
    private boolean updateWithoutAdding(Entry head, String key, int value) {
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

    public void update(String key, int value) {
        int afterMod = Math.abs(key.hashCode()) % entries.length;
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
        Attempt3 map = new Attempt3(5);
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
    }
}

