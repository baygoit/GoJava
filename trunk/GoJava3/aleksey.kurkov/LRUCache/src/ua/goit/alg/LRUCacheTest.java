package ua.goit.alg;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LRUCacheTest {

  @Test
  public void checkCacheCapacity() {
    LRUCache cache = new LRUCache(3);
    int expectedValue = 3;
    int actualValue = cache.getCapacity();
    assertEquals(expectedValue, actualValue);
  }

  @Test
  public void checkCacheSize_AfterTwoOperations() {
    LRUCache cache = new LRUCache(5);
    cache.put(0, 0);
    cache.put(1, 10);
    int expectedValue = 2;
    int actualValue = cache.getSize();
    assertEquals(expectedValue, actualValue);
  }

  @Test
  public void checkCacheSize_AfterFifteenOperations() {
    LRUCache cache = new LRUCache(5);
    for (int i = 0; i < 16; i++) {
      cache.put(i, i * 10);
    }
    int expectedValue = 5;
    int actualValue = cache.getSize();
    assertEquals(expectedValue, actualValue);
  }

  @Test
  public void checkIfKeyNotExists() {
    LRUCache cache = new LRUCache(5);
    int expectedValue = -1;
    int actualValue = cache.get(3);
    assertEquals(expectedValue, actualValue);
  }

  @Test
  public void
  setCacheValues_countLessCacheSize_getThirdValue_checkIfItEqualsToSetValue() {
    LRUCache cache = new LRUCache(10);
    cache.put(0, 0);
    cache.put(1, 10);
    cache.put(2, 20);
    cache.put(3, 30);
    int expectedValue = 30;
    int actualValue = cache.get(3);
    assertEquals(expectedValue, actualValue);
  }

  @Test
  public void
  setCacheValues_countMoreCacheSize_getThirdValue_checkIfItEqualsToSetValue() {
    LRUCache cache = new LRUCache(5);
    cache.put(0, 0);
    cache.put(1, 10);
    cache.put(2, 20);
    cache.put(3, 30);
    cache.put(4, 40);
    cache.put(5, 50);
    cache.put(6, 60);
    int expectedValue = 30;
    int actualValue = cache.get(3);
    assertEquals(expectedValue, actualValue);
  }

  @Test
  public void
  checkIfTheOldestKey_IsDeleted_AfterGetAndPutOperations() {
    LRUCache cache = new LRUCache(4);
    cache.put(1, 10);
    cache.put(2, 20);
    cache.put(3, 30);
    cache.put(4, 40);
    cache.get(1);
    cache.put(5, 50);
    int expectedValue = 30;
    int actualValue = cache.get(3);
    assertEquals(expectedValue, actualValue);
  }

  @Test
  public void
  LRUCache_1_put_2_1_get_2_put_3_2_get_2_get_3() {
    LRUCache cache = new LRUCache(1);
    cache.put(2, 1);
    cache.get(2);
    cache.put(3, 2);
    cache.get(2);
    cache.get(3);
    int expectedValue = 2;
    int actualValue = cache.get(3);
    assertEquals(expectedValue, actualValue);
  }
}