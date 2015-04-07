package ua.goit.alg;

import org.junit.*;

public class TestCache{

	LRUCache cache  = new LRUCache(5);

	@Before
	public void putIntoCache(){
		cache.put(0,0);
		cache.put(1,1);
		cache.put(2,2);
		cache.put(3,3);
		cache.put(4,4);
	}

	@Test	
	public void getExistValue () {
			Assert.assertEquals(cache.get(2), 2);
	}

	@Test	
	public void getNotExistValue () {
			Assert.assertEquals(cache.get(6), -1);
	}

	@Test
	public void putValue_returnExistLatestValue(){
			cache.put(5,5);
			Assert.assertEquals(cache.get(5), 5);
	}
	@Test
	public void putLatestValue_returnNotExistLatestValue_deletedFromHead(){
			cache.put(5,5);
			Assert.assertEquals(cache.get(0), -1);
	}

}