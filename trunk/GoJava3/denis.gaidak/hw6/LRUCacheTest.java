
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LRUCacheTest {

  @Test
  public void testLRUCacheSetter() {
    LRUCache lruCache = new LRUCache(5);
    assertEquals(lruCache.capacity, 5);
  }

  @Test
  public void testLRUCache() {
    LRUCache lruCache = new LRUCache(4);
    lruCache.set(5,5);
    lruCache.set(1,1);
    lruCache.set(2,2);
    lruCache.set(3,3);
    lruCache.set(4,4);
    lruCache.set(1,1);
    lruCache.set(1,1);
    lruCache.set(2,2);
    lruCache.set(4,4);
    lruCache.set(6,6);

    assertEquals(-1, lruCache.get(3));
  }

  @Test
  public void testCacheNotContainKey() {
    LRUCache lruCache = new LRUCache(5);
    int actualResult = lruCache.get(4);
    assertEquals(-1, actualResult);
  }

  @Test
  public void testGetValue() {
    LRUCache lruCache = new LRUCache(5);
    lruCache.set(1,1);
    lruCache.set(2,3);

    assertEquals(1,lruCache.get(1));
    assertEquals(3,lruCache.get(2));

  }

  @Test
  public void testLastValue() {
    LRUCache lruCache = new LRUCache(5);
    lruCache.set(1,1);
    assertEquals(1, lruCache.getLastValue());

    lruCache.set(2,2);
    lruCache.set(3,3);
    assertEquals(3, lruCache.getLastValue());

    lruCache.set(4,4);
    lruCache.set(1,1);
    assertEquals(1, lruCache.getLastValue());

  }

  @Test
  public void testFirstValue() {
    LRUCache lruCache = new LRUCache(5);
    lruCache.set(1,1);
    assertEquals(1, lruCache.getFirstValue());

    lruCache.set(2,2);
    lruCache.set(3,3);
    assertEquals(1, lruCache.getFirstValue());

    lruCache.set(4,4);
    lruCache.set(1,1);
    assertEquals(2, lruCache.getFirstValue());
  }

  @Test
  public void testCacheSize() {
    LRUCache lruCache = new LRUCache(5);
    lruCache.set(1,1);
    lruCache.set(2,2);
    lruCache.set(3,3);
    lruCache.set(4,4);
    lruCache.set(1,1);
    assertEquals(4, lruCache.getCacheSize());
  }

  @Test
  public void testCachePutSet() {
    LRUCache lruCache = new LRUCache(2);
    lruCache.set(2,1);
    lruCache.set(1,1);
    int actual = lruCache.get(2);
    assertEquals(actual, 1);
    lruCache.set(4, 1);
    actual = lruCache.get(1);
    assertEquals(actual, -1);
    actual = lruCache.get(2);
    assertEquals(actual, 1);

  }
}