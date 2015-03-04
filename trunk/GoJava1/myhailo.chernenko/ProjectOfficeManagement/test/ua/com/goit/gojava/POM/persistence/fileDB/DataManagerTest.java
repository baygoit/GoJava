package ua.com.goit.gojava.POM.persistence.fileDB;

import static org.junit.Assert.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.*;

import org.mockito.runners.MockitoJUnitRunner;

import ua.com.goit.gojava.POM.dataModel.profitcost.CostItem;
import ua.com.goit.gojava.POM.persistence.fileDB.DataManager;

@RunWith(MockitoJUnitRunner.class)
public class DataManagerTest {
	
	private static final String TEST_DATA_FILE = "C:\\workspace\\ProjectOfficeManagementTEST.dat";
	private static final String CLASS_NAME = "CostItem";
	private DataManager dataManager;
	
	@Before
	public void setUp() throws Exception {
		
		dataManager = spy(new DataManager() {
			
			@SuppressWarnings("unused")
			private String dataFile = "";
			public void initialize() {
				dataFile = TEST_DATA_FILE;
			}
			
		});
		dataManager.initialize();
		dataManager.readData();
		
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
		
		@SuppressWarnings("unchecked")
		List<Object> mockedList = mock(List.class);
		mockedList.add("once");
		mockedList.add("once");
		when(mockedList.size()).thenReturn(100);
		
		when(dataManager.getObjectList(CLASS_NAME)).thenReturn(mockedList);
		 
		verify(dataManager).getObjectList(CLASS_NAME);
		
		assertEquals(dataManager.getObjectList(CLASS_NAME).size(), 100);
		
		verify(mockedList, times(2)).add("once");
		
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
					
					fos = new FileOutputStream(TEST_DATA_FILE);
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
		
		// TODO need to check
		//assertEquals(dataManager.getObjectList(CLASS_NAME).size(), 1);

	}
	
}
