package ua.goit.cache;

import static org.junit.Assert.*;

import org.junit.Test;

public class LRUCacheTest {

  @Test
  public void whenCapasity2_andAdded3UniqueElements_thenFirstIsGone() {
    //given
    LRUCache cache = new LRUCache(2);
    
    //when
    cache.set(1, 1);
    cache.set(2, 2);
    cache.set(3, 3);
    
    //then
    int actual = cache.get(1);
    int expected = -1;
    assertEquals(expected, actual);
  }
  
  @Test
  public void whenCapasity2_andAdded2UniqueElements_thenFirstIsNotGone() {
    //given
    LRUCache cache = new LRUCache(2);
    
    //when
    cache.set(1, 1);
    cache.set(2, 2);
    
    //then
    int actual = cache.get(1);
    int expected = 1;
    assertEquals(expected, actual);
  }
  
  @Test
  public void testDublicatedValuesWithDifferentKeys() {
    //given
    LRUCache cache = new LRUCache(2);
    
    //when
    cache.set(1, 1);
    cache.set(2, 1);
    
    //then
    int actual = cache.get(2);
    int expected = 1;
    assertEquals(expected, actual);
  }

}
