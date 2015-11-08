package ua.goit.alg;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCache {

  @Test
  public void testCache() {
    LRUCache cache = new LRUCache(5);
    cache.put(1,10);
    cache.put(2,20);
    assertEquals(2, cache.getSize());
  }

  @Test
  public void testCacheReplace() {
    LRUCache cache = new LRUCache(5);
    cache.put(1,10);
    cache.put(2,20);
    cache.put(3,30);
    cache.put(2,200);
    assertEquals(3, cache.getSize());
  }

  @Test
  public void testCacheLong() {
    LRUCache cache = new LRUCache(5);
    cache.put(1,10);
    cache.put(2,20);
    cache.put(3,30);
    cache.put(2,200);
    cache.get(2);
    cache.put(4,40);
    cache.put(5,50);
    cache.put(2,20);
    //String expectedResult = {1, 3, 4, 5, 2};
    String expectedResult = "1 3 4 5 2 ";
    assertEquals(expectedResult, cache.getStringValue());
  }

  @Test
  public void testCacheEx() {
    LRUCache cache = new LRUCache(5);
    cache.put(2,1);
    cache.get(2);
    cache.put(3,2);
    cache.get(2);
    cache.get(3);
    cache.put(4,2);
    cache.put(5,2);
    cache.put(6,2);
    cache.put(7,2);
    cache.put(8,2);
    cache.put(7,2);
    assertEquals(5, cache.getSize());
  }
 }
