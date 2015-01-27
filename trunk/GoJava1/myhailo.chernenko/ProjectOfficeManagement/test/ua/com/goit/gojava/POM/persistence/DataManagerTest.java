package ua.com.goit.gojava.POM.persistence;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataManagerTest {
	
	private DataManager dataManager;

	@Before
	public void setUp() throws Exception {
		
		dataManager = new DataManager();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReadData() {
		
		assertNotNull(dataManager);

	}
	
	@Test
	public void testGetObjectListEmptyString() {
		
		List<DataObject> objectList = dataManager.getObjectList("");
		
		assertNotNull(objectList);

	}
	
	@Test
	public void testGetObjectListNullString() {
		
		List<DataObject> objectList = dataManager.getObjectList(null);
		
		assertNotNull(objectList);

	}
	
	@Test
	public void testGetObjectListSomeString() {
		
		List<DataObject> objectList = dataManager.getObjectList("CostItem");
		
		assertNotNull(objectList);

	}

}
