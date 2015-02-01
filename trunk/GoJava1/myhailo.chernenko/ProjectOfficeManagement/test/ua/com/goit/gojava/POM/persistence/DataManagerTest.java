package ua.com.goit.gojava.POM.persistence;

import static org.junit.Assert.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava.POM.dataModel.CostItem;

public class DataManagerTest {
	
	private static final String CLASS_NAME = "CostItem";
	private DataManager dataManager;

	@Before
	public void setUp() throws Exception {
		
		dataManager = new DataManager();
		for (int i = dataManager.getObjectList(CLASS_NAME).size() - 1; i >= 0 ;i--) {
			Object obj = dataManager.getObjectList(CLASS_NAME).get(i);
			dataManager.deleteObject(obj, CLASS_NAME);
		}
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreationAndReadData() {
		
		assertNotNull(dataManager);

	}
	
	@Test
	public void testGetObjectListEmptyString() {
		
		List<Object> objectList = dataManager.getObjectList("");
		
		assertNotNull(objectList);

	}
	
	@Test
	public void testGetObjectListNullString() {
		
		List<Object> objectList = dataManager.getObjectList(null);
		
		assertNotNull(objectList);

	}
	
	@Test
	public void testGetObjectListSomeString() {
		
		List<Object> objectList = dataManager.getObjectList(CLASS_NAME);
		
		assertNotNull(objectList);

	}
	
	@Test
	public void testSaveObjectAndGetNotEmptyList() {
		
		CostItem costItem = new CostItem();
		dataManager.saveObject(costItem, CLASS_NAME);
		
		assertEquals(dataManager.getObjectList(CLASS_NAME).size(), 1);

	}
	
	@Test
	public void testSaveObjectTwise() {
		
		CostItem costItem = new CostItem();
		dataManager.saveObject(costItem, CLASS_NAME);
		dataManager.saveObject(costItem, CLASS_NAME);
		
		assertEquals(dataManager.getObjectList(CLASS_NAME).size(), 1);

	}
	
	@Test
	public void testDeleteObject() {
		
		CostItem costItem = new CostItem();
		dataManager.saveObject(costItem, CLASS_NAME);
		dataManager.deleteObject(costItem, CLASS_NAME);
		
		assertEquals(dataManager.getObjectList(CLASS_NAME).size(), 0);

	}
	
	@Test
	public void testDeleteNotSavedObject() {
		
		CostItem costItem = new CostItem();
		dataManager.deleteObject(costItem, CLASS_NAME);
		
		assertEquals(dataManager.getObjectList(CLASS_NAME).size(), 0);

	}
	
	@Test
	public void testSavedData() {
		
		dataManager.saveData();
		assertNotNull(dataManager);

	}

	@Test
	public void testReadEmptyData() {
		
		DataManager tempDataManager = new DataManager() {
			
			public void saveData() {

				FileOutputStream fos;
				ObjectOutputStream oos;
				try {
					
					fos = new FileOutputStream("C:\\workspace\\ProjectOfficeManagement.dat");
					oos = new ObjectOutputStream(fos);
					oos.writeObject(null);
					oos.close();
					fos.close();
						
				} catch (IOException e) {
				}
			}
			
		};
		
		tempDataManager.saveData();
		dataManager.readData();
		
		assertNotNull(dataManager);

	}
	
	@Test
	public void testReadNotEmptyData() {
		
		CostItem costItem = new CostItem();
		dataManager.saveObject(costItem, CLASS_NAME);
		dataManager.saveData();
		dataManager.readData();
		
		assertEquals(dataManager.getObjectList(CLASS_NAME).size(), 1);

	}
	
}
