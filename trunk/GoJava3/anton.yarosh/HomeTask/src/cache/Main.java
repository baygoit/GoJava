package cache;

public class Main {

 
    public static void main(String[] args) {
	LRUCache cache = new LRUCache(5);
	cache.set(1, 1);
	cache.set(2, 2);
	cache.set(3, 3);
	cache.set(4, 4);
	cache.set(5, 5);
	cache.set(6, 6);
	cache.get(1);
	
	}
}
