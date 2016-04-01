package ua.nenya.main;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Ignore;

@Ignore
public class KickstarterInitilizerTest {
	private DaoInitilizer initilizer = new DaoInitilizer();
	
	
	@Test
	public void kikstarterInitilizerTest1() {
		initilizer.initDao("memory");
		assertNotNull(initilizer.getCategoryDao().getCategories());
	}
	
	
	@Test
	public void kikstarterInitilizerTest2() {
		initilizer.initDao("file");
		assertNotNull(initilizer.getCategoryDao().getCategories());
	}
	
	
	@Test
	public void kikstarterInitilizerTest3() {
		initilizer.initDao("db");
		assertNotNull(initilizer.getCategoryDao().getCategories());
	}

}
