package miscel;

import org.junit.Test;
import static org.junit.Assert.*;

public class LRUCacheTest {

  @Test
  public void putFourValuesInCacheWithSizeThree() {
    LRUCache cache = new LRUCache(3);
    cache.put(1, 1);
    cache.put(2, 2);
    cache.put(3, 3);
    cache.put(4, 4);
    String result = cache.toString();
    String expected = "2:2, 3:3, 4:4, ";
    assertEquals(expected, result);
  }

  @Test
  public void priorityChangeAfterGet() {
    LRUCache cache = new LRUCache(3);
    cache.put(1, 1);
    cache.put(2, 2);
    cache.put(3, 3);
    cache.put(4, 4);
    cache.get(2);
    String result = cache.toString();
    String expected = "3:3, 4:4, 2:2, ";
    assertEquals(expected, result);
  }
/*
  @Test
  public void getNoSuchKey() {

  }

  @Test
  public void zeroCapacity() {
  LRUCache cache = new LRUCache(0);
  cache.put(1, 1);
    cache.put(2, 2);
    String result = cache.toString();
    String expected = "";
    assertEquals(expected, result);

  }

  public void oneValueCapacity() {
  LRUCache cache = new LRUCache(1);
  cache.put(1, 1);
    cache.put(2, 2);
    String result = cache.toString();
    String expected = "";
    assertEquals(expected, result);

  }

  */
}