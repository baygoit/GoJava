package ua.goit.alg.LRUCache;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class LRUCacheTest {
    @Test
    public void testingSetMethod() {
        LRUCache lru = new LRUCache(6);
        lru.set(1, 9);
        lru.set(2, 8);
        lru.set(3, 7);
        assertNotNull(lru.getMap().get(1));
        assertNotNull(lru.getMap().get(2));
        assertNotNull(lru.getMap().get(3));
    }

    @Test
    public void testingNodesInterconnection() {
        LRUCache lru = new LRUCache(6);
        lru.set(1, 9);
        lru.set(2, 8);
        lru.set(3, 7);
        Node expectedResult1 = lru.getMap().get(1);
        Node expectedResult2 = lru.getMap().get(2);
        Node expectedResult3 = lru.getMap().get(3);
        assertTrue(expectedResult1.after == expectedResult2);
        assertTrue(expectedResult3.before == expectedResult2);
    }

    @Test
    public void testingDeletingLastUsedItem() {
        LRUCache lru = new LRUCache(6);
        lru.set(1, 9);
        lru.set(2, 8);
        lru.set(3, 7);
        lru.set(4, 6);
        lru.set(5, 5);
        lru.set(6, 4);
        lru.set(7, 3);
        assertTrue(lru.getMap().size() == 6);
        assertNotNull(lru.getMap().get(2));
        assertNotNull(lru.getMap().get(3));
        assertNotNull(lru.getMap().get(4));
        assertNotNull(lru.getMap().get(5));
        assertNotNull(lru.getMap().get(6));
        assertNotNull(lru.getMap().get(7));
        assertFalse(lru.getMap().containsKey(1));
    }

    @Test
    public void testingGetMethodWithExistKey() {
        LRUCache lru = new LRUCache(6);
        lru.set(1, 9);
        lru.set(2, 8);
        lru.set(3, 7);
        lru.set(4, 6);
        int actualResult = lru.get(1);
        int expectedResult = 9;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testingGetMethodWithWrongKey() {
        LRUCache lru = new LRUCache(6);
        lru.set(1, 9);
        lru.set(2, 8);
        lru.set(3, 7);
        lru.set(4, 6);
        int actualResult = lru.get(10);
        int expectedResult = -1;
        assertEquals(expectedResult, actualResult);
    }
}

