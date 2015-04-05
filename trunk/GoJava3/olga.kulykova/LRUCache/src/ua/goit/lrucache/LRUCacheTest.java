package ua.goit.lrucache;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LRUCacheTest {

  @Test
  public void givenCacheCapacityFive_WhenGetThirdElement_ThenItShouldReplaceToLastElement() {
    LRUCache cache = new LRUCache(5);
    cache.set(1, 1);
    cache.set(2, 2);
    cache.set(3, 3);
    cache.set(4, 4);
    cache.set(5, 5);
    cache.get(3);
    LRUCache.Node node = cache.getTail();
    assertEquals(3, node.getValue());
  }

}