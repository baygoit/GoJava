package ua.com.goit.gojava.POM.persistence.abstraction;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava.POM.persistence.DataManager;
import ua.com.goit.gojava.POM.persistence.abstraction.DataObject;
import ua.com.goit.gojava.POM.persistence.abstraction.GenericDAO;


public abstract class GenericDAOTest<T> {

	private DataManager dataManager;
	private GenericDAO<T> genericDAO;
	private Class<T> classT;
	
	public GenericDAOTest(Class<T> classT) {
		
		this.classT = classT;
				
	}
	
	@Before
	public void setUp() throws Exception {
		
		dataManager = new DataManager();
		for (int i = dataManager.getObjectList(classT.getName()).size() - 1; i >= 0 ;i--) {
			Object obj = dataManager.getObjectList(classT.getName()).get(i);
			dataManager.deleteObject(obj, classT.getName());
		}

		genericDAO = new GenericDAO<T>(classT, dataManager);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreate() {

		T genericObj = genericDAO.create();
		assertTrue(dataManager.getObjectList(classT.getName()).contains(genericObj));
		
	}

	@Test
	public void testGetByName() {

		// TODO override
		/*
		 T genericObj = genericDAO.getByName("name");
		 
		
		assertEquals(null,genericObj);
		
		genericObj = genericDAO.create();
		
		if (genericObj instanceof DataObject) {
		
			DataObject datacObj = (DataObject) genericObj;
			datacObj.setName("name");
			
			genericDAO.update(genericObj);
			T genericObj2 = genericDAO.getByName("name");
					
			assertEquals(genericObj,genericObj2);
			
			genericObj = genericDAO.getByName("name2");
			
			assertEquals(null,genericObj);
		}
		*/
	}

	@Test
	public void testUpdate() {

		T genericObj = genericDAO.create();
		genericDAO.update(genericObj);
		
		assertEquals(dataManager.getObjectList(classT.getName()).size(),1);
		
		assertEquals(genericDAO.getList().get(0),genericObj);
	}

	@Test
	public void testDelete() {

		T genericObj = genericDAO.create();
		genericDAO.update(genericObj);
		T genericObj2 = genericDAO.create();
		genericDAO.update(genericObj2);
		
		List<Object> objectList = dataManager.getObjectList(classT.getName());
		
		assertEquals(objectList.size(),2);
		assertTrue(objectList.contains(genericObj));
		assertTrue(objectList.contains(genericObj2));
		
		genericDAO.delete(genericObj2);
		
		assertFalse(objectList.contains(genericObj2));
		
	}

	@Test
	public void testGetList() {

		T genericObj = genericDAO.create();
		genericDAO.update(genericObj);
		
		assertEquals(genericDAO.getList().size(),1);
		
		assertEquals(genericDAO.getList().get(0),genericObj);
		
	}

}
