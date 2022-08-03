// restrictions:
// - keys must be integers in range 0 <= key < size
public class Attempt1 {
    private final String[] array;
    
    public Attempt1(int size) {
        array = new String[size];
    }

    // returns null if it's not in the map
    public String lookup(int key) {
        return array[key];
    }

    public void update(int key, String value) {
        array[key] = value;
    }
}
