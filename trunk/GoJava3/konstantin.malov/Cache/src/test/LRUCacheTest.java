package test;

import main.LRUCache;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LRUCacheTest {
  private LRUCache cache;

  @Before
  public void createAndFillInCache() {
    cache = new LRUCache(5);
    cache.set(0, 0);
    cache.set(1, 1);
    cache.set(2, 2);
    cache.set(3, 3);
    cache.set(4, 4);
  }

  @Test
  public void fullCache_gettingExistedValue_returnExistingValue() {
    Assert.assertEquals(cache.get(1), 1);
  }

  @Test
  public void fullCache_gettingNotExist_returnMinusOne() {
    Assert.assertEquals(cache.get(12), -1);
  }

  @Test
  public void fullCache_setExistedKeyByNewValue_returnNewValue() {
    cache.set(3, 2);
    Assert.assertEquals(cache.get(3), 2);
  }

  @Test
  public void fullCache_setNotExistedKey_returnValueOfNewKey() {
    cache.set(18, 2);
    Assert.assertEquals(cache.get(18), 2);
  }

  @Test
  public void fullCache_setOneMoreElementAndCheckCacheSize_returnCacheSize() {
    cache.set(8, 8);
    Assert.assertEquals(cache.getCacheSize(), 5);
  }

  @Test
  public void fullCache_setNotExistedKeyAndTryToGetFirstAddedEntity_returnMinusOne() {
    cache.set(18, 2);
    Assert.assertEquals(cache.get(0), -1);
  }

  @Test
  public void emptyCache_setNotExistedKeyAndTryToGetIt_returnValueThatWasSetBefore() {
    cache.clearCache();
    cache.set(8, 8);
    Assert.assertEquals(cache.get(8), 8);
  }

  @Test
  public void emptyCache_setNotExistedKeyAndCheckCacheSize_returnCacheSize() {
    cache.clearCache();
    cache.set(8, 8);
    Assert.assertEquals(cache.getCacheSize(), 1);
  }

  @Test
  public void notFullCache_setNotExistedKeyAndCheckCacheSize_returnCacheSize() {
    cache.clearCache();
    cache.set(8, 8);
    cache.set(10, 10);
    Assert.assertEquals(cache.get(10), 10);
  }
}
