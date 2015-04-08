package ua.goit.alg;

import org.junit.*;

public class TestCache {

	LRUCache cache  = new LRUCache(5);

	@Before
	public void putIntoCache() {
		cache.put(0, 0);
		cache.put(1, 1);
		cache.put(2, 2);
		cache.put(3, 3);
		cache.put(4, 4);
	}

	@Test	
	public void getExistValue() {
		Assert.assertEquals(cache.get(2), 2);
	}

	@Test	
	public void getNotExistValue() {
		Assert.assertEquals(cache.get(6), -1);
	}

	@Test
	public void putValue_returnValue() {
		cache.put(5, 5);
		Assert.assertEquals(cache.get(5), 5);
	}
	@Test
	public void putLatestValue_returnNotExistLatestValue_deletedFromHead() {
		cache.put(5, 5);
		Assert.assertEquals(cache.get(0), -1);
	}

	@Test
	public void putValueWithExistedKey_getValueWithExistedKey() {
		cache.put(3,100500);
		Assert.assertEquals(cache.get(3), 100500);
	}
	
	@Test
	public void putValueWithNotExistedKey_getValueWithNotExistedKey() {
		cache.put(100500,3);
		Assert.assertEquals(cache.get(100500), 3);
	}
	
	@Test
	public void cleanCache_returnCacheSize() {
		cache.cleanCache();
		Assert.assertEquals(cache.getCacheSize(), 0);
		
	}
	@Test
	public void cleanCache_returnNotExistedVal() {
		cache.cleanCache();
		Assert.assertEquals(cache.get(3), -1);
		
	}
	
	@Test
	public void putValueToEmtyCache_chekSize() {
		cache.cleanCache();
		cache.put(1,1);
		cache.put(2,2);
		Assert.assertEquals(cache.getCacheSize(), 2);
	}
}


