package ua.com.goit.gojava.POM.persistence;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava.POM.dataModel.Project;

public class ProjectDAOTest {

	private static final String CLASS_NAME = "Project";
	private DataManager dataManager;
	private ProjectDAO projectDAO; 
	
	@Before
	public void setUp() throws Exception {
		
		dataManager = new DataManager();
		for (int i = dataManager.getObjectList(CLASS_NAME).size() - 1; i >= 0 ;i--) {
			DataObject obj = dataManager.getObjectList(CLASS_NAME).get(i);
			dataManager.deleteObject(obj, CLASS_NAME);
		}

		projectDAO = new ProjectDAO(dataManager);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreate() {

		Project project = projectDAO.create();
		assertTrue(dataManager.getObjectList(CLASS_NAME).contains(project));
		
	}

	@Test
	public void testGetByName() {

		Project project = projectDAO.create();
		project.setName("name");
		projectDAO.update(project);
		Project project2 = projectDAO.getByName("name");
				
		assertEquals(project,project2);
	}

	@Test
	public void testUpdate() {

		Project project = projectDAO.create();
		project.setName("name");
		projectDAO.update(project);
		
		assertEquals(dataManager.getObjectList(CLASS_NAME).size(),1);
		
		assertEquals(projectDAO.getList().get(0).getName(),project.getName());
		
	}

	@Test
	public void testDelete() {

		Project project = projectDAO.create();
		projectDAO.update(project);
		Project project2 = projectDAO.create();
		projectDAO.update(project2);
		
		List<DataObject> objectList = dataManager.getObjectList(CLASS_NAME);
		
		assertEquals(objectList.size(),2);
		assertTrue(objectList.contains(project));
		assertTrue(objectList.contains(project2));
		
		projectDAO.delete(project2);
		
		assertFalse(objectList.contains(project2));
	}

	@Test
	public void testGetList() {

		Project project = projectDAO.create();
		project.setName("name");
		projectDAO.update(project);
		
		assertEquals(projectDAO.getList().size(),1);
		
		assertEquals(projectDAO.getList().get(0).getName(),project.getName());
		
	}

}
