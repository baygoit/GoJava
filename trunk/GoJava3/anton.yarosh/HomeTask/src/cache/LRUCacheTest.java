package cache;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LRUCacheTest {
    LRUCache cache = new LRUCache(5);

    @Before
    public void cacheInitialization() {
	cache.set(1, 1);
	cache.set(2, 2);
	cache.set(3, 3);
	cache.set(4, 4);
	cache.set(5, 5);
    }

    @Test
    public void noElementTest() {
	LRUCache cache = new LRUCache(5);
	cache.set(1, 1);
	int expected = -1;
	int actual = (int) cache.get(2);
	assertEquals(expected, actual);
    }

    @Test
    public void getElementTest() {
	LRUCache cache = new LRUCache(5);
	cache.set(1, 1);
	int expected = 1;
	int actual = (int) cache.get(1);
	assertEquals(expected, actual);
    }

    @Test
    public void deletingLeastRecentlyUsedTest() {
	cache.set(6, 6);
	int expected = -1;
	int actual = (int) cache.get(1);
	assertEquals(expected, actual);
    }

    @Test
    public void checkLeastRecentlyUsedAfterGetTest() {
	cache.set(6, 6);
	cache.set(2, 2);
	int expected = 3;
	int actual = (int) cache.get(3);
	assertEquals(expected, actual);
    }
}
