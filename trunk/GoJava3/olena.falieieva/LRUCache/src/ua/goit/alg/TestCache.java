package ua.goit.alg;

import org.junit.Assert;
import org.junit.Test;

public class TestCache {

    @Test
    public void shouldReturnExistedValue() {
	LRUCache cache = new LRUCache(5);
	cache.set(2, 0);
	Assert.assertEquals(cache.get(2), 0);
    }

    @Test	
    public void shouldReturnMinusOneForMissingValue() {
	LRUCache cache = new LRUCache(5);
	cache.set(0, 0);
	Assert.assertEquals(cache.get(6), -1);
    }

    @Test
    public void shouldReturnLastStoredValue_IfNumberOfStoredValuesIncreasesCacheCapacity() {
	LRUCache cache = new LRUCache(3);
	cache.set(0, 0);
	cache.set(1, 1);
	cache.set(4, 4);
	cache.set(5, 5);
	Assert.assertEquals(cache.get(5), 5);
    }

    @Test
    public void shouldReturnNewValueForExistedKey() {
	LRUCache cache = new LRUCache(3);
	cache.set(0, 0);
	cache.set(1, 1);
	cache.set(2, 2);
	cache.set(2, 100500);
	Assert.assertEquals(cache.get(2), 100500);
    }	

    @Test
    public void shouldReturnMinusOneForMissingValue_DeletedFromHeadAfrerGetSetInvokations() {
	LRUCache cache = new LRUCache(5);
	cache.set(0, 0);
	cache.set(1, 1);
	cache.set(2, 2);
	cache.set(3, 3);
	cache.set(4, 4);
	cache.set(9, 9);
	cache.get(2);
	cache.set(5, 5);
	cache.get(3);
	cache.set(8, 8);
	Assert.assertEquals(cache.get(4), -1);
    }
}


