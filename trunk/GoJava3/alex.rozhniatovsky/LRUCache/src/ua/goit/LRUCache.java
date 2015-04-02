package ua.goit;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    public static final int CAPACITY = 2;
    private Map<Integer, Integer> numbers = null;
    private CacheList keyList = null;

    public LRUCache(int capacity) {
        numbers = new HashMap<Integer, Integer>(capacity);
        keyList = new CacheList();
    }

    public int get(int i) {
        Integer number = numbers.get(i);
        if(number == null) {
            return -1;
        }
        keyList.refresh(number);
        return number;
    }

    public void set(int key, int value) {
        int size = numbers.size();
        if (size < CAPACITY) {
            numbers.put(key, value);
            keyList.refresh(key);
        } else if (size == CAPACITY) {
            int theLeastRecUsedKey = keyList.getFirstElement();
            numbers.remove(theLeastRecUsedKey);
			keyList.refresh(key);
            numbers.put(key, value);
        }
    }
	
	public int getCapacity() {
		return numbers.size();
	}
}
