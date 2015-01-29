package ua.com.goit.gojava.POM.persistence;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava.POM.dataModel.CostItem;

@SuppressWarnings("unused")
public class GenericDAOOldTest <T extends GenericDAO<?> > {

	private String className = "";
	private Class<T> classT;
	
	private DataManager dataManager;
	private T genericDAO; 
	
	public GenericDAOOldTest(Class<T> classT) {
		
		this.classT = classT;
		className = classT.getName().replace("DAO", "");
				
	}
	
	public T getNewT() {
		
		try {
			return classT.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return genericDAO;
	} 
	
	@Before
	public void setUp() throws Exception {
		
		dataManager = new DataManager();
		for (int i = dataManager.getObjectList(className).size() - 1; i >= 0 ;i--) {
			DataObject obj = dataManager.getObjectList(className).get(i);
			dataManager.deleteObject(obj, className);
		}

		genericDAO = getNewT();
		
	}
	

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreate() {

		//CostItem costItem = genericDAO.create();
		//assertTrue(dataManager.getObjectList(className).contains(costItem));
		
	}

	@Test
	public void testGetByName() {
		//fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		
		/*CostItem costItem = genericDAO.create();
		costItem.setName("name");
		genericDAO.update(costItem);
		
		assertEquals(dataManager.getObjectList(className).size(),1);
		
		assertEquals(genericDAO.getList().get(0).getName(),costItem.getName());
		*/
	}

	@Test
	public void testDeleteObj() {

		/*CostItem costItem = genericDAO.create();
		genericDAO.update(costItem);
		CostItem costItem2 = genericDAO.create();
		genericDAO.update(costItem2);
		
		List<DataObject> objectList = dataManager.getObjectList(className);
		
		assertEquals(objectList.size(),2);
		assertTrue(objectList.contains(costItem));
		assertTrue(objectList.contains(costItem2));
		
		genericDAO.delete(costItem2);
		
		assertFalse(objectList.contains(costItem2));
		*/
	}

	@Test
	public void testGetList() {

		/*CostItem costItem = genericDAO.create();
		costItem.setName("name");
		genericDAO.update(costItem);
		
		assertEquals(genericDAO.getList().size(),1);
		
		assertEquals(genericDAO.getList().get(0).getName(),costItem.getName());
		*/
	}

}
