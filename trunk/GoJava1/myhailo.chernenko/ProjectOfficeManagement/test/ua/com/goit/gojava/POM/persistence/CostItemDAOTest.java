package ua.com.goit.gojava.POM.persistence;

/*import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;*/

import ua.com.goit.gojava.POM.dataModel.CostItem;

public class CostItemDAOTest extends GenericDAOTest<CostItem> {

	public CostItemDAOTest() {
		super(CostItem.class);
	}

	/*private static final String CLASS_NAME = "CostItem";
	private DataManager dataManager;
	private CostItemDAO costItemDAO; 
	
	@Before
	public void setUp() throws Exception {
		
		dataManager = new DataManager();
		for (int i = dataManager.getObjectList(CLASS_NAME).size() - 1; i >= 0 ;i--) {
			DataObject obj = dataManager.getObjectList(CLASS_NAME).get(i);
			dataManager.deleteObject(obj, CLASS_NAME);
		}

		costItemDAO = new CostItemDAO(dataManager);
		
	}
	

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreate() {

		CostItem costItem = costItemDAO.create();
		assertTrue(dataManager.getObjectList(CLASS_NAME).contains(costItem));
		
	}

	@Test
	public void testGetByName() {

		CostItem costItem = costItemDAO.getByName("name");
		
		assertEquals(null,costItem);
		
		costItem = costItemDAO.create();
		costItem.setName("name");
		costItemDAO.update(costItem);
		CostItem costItem2 = costItemDAO.getByName("name");
				
		assertEquals(costItem,costItem2);
		
		costItem = costItemDAO.getByName("name2");
		
		assertEquals(null,costItem);
		
	}

	@Test
	public void testUpdate() {
		
		CostItem costItem = costItemDAO.create();
		costItem.setName("name");
		costItemDAO.update(costItem);
		
		assertEquals(dataManager.getObjectList(CLASS_NAME).size(),1);
		
		assertEquals(costItemDAO.getList().get(0).getName(),costItem.getName());
		
	}

	@Test
	public void testDeleteObj() {

		CostItem costItem = costItemDAO.create();
		costItemDAO.update(costItem);
		CostItem costItem2 = costItemDAO.create();
		costItemDAO.update(costItem2);
		
		List<DataObject> objectList = dataManager.getObjectList(CLASS_NAME);
		
		assertEquals(objectList.size(),2);
		assertTrue(objectList.contains(costItem));
		assertTrue(objectList.contains(costItem2));
		
		costItemDAO.delete(costItem2);
		
		assertFalse(objectList.contains(costItem2));
		
	}

	@Test
	public void testGetList() {

		CostItem costItem = costItemDAO.create();
		costItem.setName("name");
		costItemDAO.update(costItem);
		
		assertEquals(costItemDAO.getList().size(),1);
		
		assertEquals(costItemDAO.getList().get(0).getName(),costItem.getName());
		
	} */

}
