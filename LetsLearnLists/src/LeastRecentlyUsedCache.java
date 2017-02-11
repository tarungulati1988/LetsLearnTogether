import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * Created by tgulati on 2/4/17.
 */
public class LeastRecentlyUsedCache extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    public LeastRecentlyUsedCache(int capacity) {
        super(capacity+1, 1.0f, true);  // for access order
        this.capacity = capacity;
    }

    public int get(int key) {
        if(super.get(key) == null)
            return -1;
        else
            return ((int) super.get(key));
    }

    public void set(int key, int value) {
        super.put(key, value);
    }

    protected boolean removeEldestEntry(Entry entry) {
        return (size() > this.capacity);
    }
}