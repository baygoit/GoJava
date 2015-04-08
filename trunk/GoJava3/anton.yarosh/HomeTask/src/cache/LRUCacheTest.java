package cache;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LRUCacheTest {
    
    @Test
    public void shouldReturnMinusOneWhenNotFoundTest() {
	LRUCache cache = new LRUCache(5);
	cache.set(1, 1);
	int expected = -1;
	int actual = cache.get(2);
	assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnValueWhenCallGetWithKeyTest() {
	LRUCache cacheOneElement = new LRUCache(5);
	cacheOneElement.set(1, 1);
	int expected = 1;
	int actual = cacheOneElement.get(1);
	assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnMinusOneAfterLatestKeyGetTest() {
	LRUCache cache = new LRUCache(5);
	cache.set(1, 1);
	cache.set(2, 2);
	cache.set(3, 3);
	cache.set(4, 4);
	cache.set(5, 5);
	cache.set(6, 6);
	int expected = -1;
	int actual = cache.get(1);
	assertEquals(expected, actual);
    }
    
    @Test
    public void shouldReturnMinusOneAfterAllKeysShiftingTest() {
	LRUCache cache = new LRUCache(4);
	cache.set(1, 1);
	cache.set(2, 2);
	cache.set(3, 3);
	cache.set(4, 4);
	cache.get(1);
	cache.get(2);
	cache.get(3);
	cache.set(5, 5);
	int expected = -1;
	int actual = cache.get(4);
	assertEquals(expected, actual);
    }
}
