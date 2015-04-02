package ua.goit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LRUCacheTest {
    private LRUCache cache = new LRUCache(LRUCache.CAPACITY);

    @Before
    public void init() {
        cache.set(1, 1);
        cache.set(2, 2);
        cache.set(3, 3);
    }

    @Test
    public void testGetNotExistValue() {
        int expectedResult = -1;
        int actualResult = cache.get(-1);

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetExistValue() {
        int expectedResult = 2;
        int actualResult = cache.get(2);

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCapacity() {
        int expectedResult = LRUCache.CAPACITY;
        int actualResult = cache.getCapacity();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCacheHighPriority() {
        int expectedResult = 3;
        int actualResult = cache.get(3);

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCacheFlushedElement() {
        int expectedResult = -1;
        int actualResult = cache.get(1);

        Assert.assertEquals(expectedResult, actualResult);
    }
}