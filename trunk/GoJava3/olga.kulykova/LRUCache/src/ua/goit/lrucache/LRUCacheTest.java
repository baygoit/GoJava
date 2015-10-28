package ua.goit.lrucache;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LRUCacheTest {

  @Test
  public void replaceMiddleElementToTail() {
    LRUCache cache = new LRUCache(5);
    cache.set(1, 1);
    cache.set(2, 2);
    cache.set(3, 3);
    cache.set(4, 4);
    cache.set(5, 5);
    cache.get(3);
    String expected = "1 2 4 5 3 ";
    String actual = cache.toString();
    assertEquals(expected, actual);
  }

  @Test
  public void getAbsentElement() {
    LRUCache cache = new LRUCache(5);
    cache.set(1, 1);
    cache.set(2, 2);
    cache.set(3, 3);
    cache.set(4, 4);
    cache.set(5, 5);
    int result = cache.get(6);
    assertEquals(-1, result);
  }

  @Test
  public void putExtraElement() {
    LRUCache cache = new LRUCache(5);
    cache.set(1, 1);
    cache.set(2, 2);
    cache.set(3, 3);
    cache.set(4, 4);
    cache.set(5, 5);
    cache.set(6, 6);
    String expected = "2 3 4 5 6 ";
    String actual = cache.toString();
    assertEquals(expected, actual);
  }

  @Test
  public void putNewValueWithOldKey() {
    LRUCache cache = new LRUCache(5);
    cache.set(1, 1);
    cache.set(2, 2);
    cache.set(3, 3);
    cache.set(4, 4);
    cache.set(5, 5);
    cache.set(2, 6);
    String expected = "1 3 4 5 6 ";
    String actual = cache.toString();
    assertEquals(expected, actual);
  }

  @Test
  public void putIntoOneCapacityCache() {
    LRUCache cache = new LRUCache(1);
    cache.set(1, 1);
    cache.set(2, 2);
    cache.set(3, 3);
    String expected = "3 ";
    String actual = cache.toString();
    assertEquals(expected, actual);
  }

  @Test
  public void putIntoZeroCapacityCache() {
    LRUCache cache = new LRUCache(0);
    cache.set(1, 1);
    cache.set(2, 2);
    cache.set(3, 3);
    String expected = "";
    String actual = cache.toString();
    assertEquals(expected, actual);
  }
}