package ua.nenya.main;

import static org.junit.Assert.*;

import org.junit.Test;

public class KickstarterInitilizerTest {
	private KickstarterInitilizer initilizer = new KickstarterInitilizer();
	
	
	@Test
	public void kikstarterInitilizerTest1() {
		initilizer.initKickstarter("memory");
		assertNotNull(initilizer.getCategoryDao().getCategories());
	}
	
	
	@Test
	public void kikstarterInitilizerTest2() {
		initilizer.initKickstarter("file");
		assertNotNull(initilizer.getCategoryDao().getCategories());
	}
	
	
	@Test
	public void kikstarterInitilizerTest3() {
		initilizer.initKickstarter("db");
		assertNotNull(initilizer.getCategoryDao().getCategories());
	}

}
