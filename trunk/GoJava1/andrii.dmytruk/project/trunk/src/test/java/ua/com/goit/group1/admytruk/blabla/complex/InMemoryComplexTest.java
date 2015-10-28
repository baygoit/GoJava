package ua.com.goit.group1.admytruk.blabla.complex;

import static org.junit.Assert.*;

import org.junit.Test;

public class InMemoryComplexTest extends AbstractComplexTest {

	private DataManager dataManager;
	
	@Override
	public DataManager getDataManager() {
		if (this.dataManager == null) {
			System.setProperty(DataManagerFactory.PROPERTY_NAME, "inMemory");
			dataManager = DataManagerFactory.createDataManager(); 
		}
		return dataManager;
	}
	
	@Test
	public void dataManagerClassTest() {
		assertEquals(DataManagerInMemory.class, getDataManager().getClass());
	}
	

}
