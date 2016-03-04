package ua.dborisenko.kickstarter;

import org.junit.Test;

import static org.junit.Assert.*;


public class ProjectCategoryTest {
	
	@Test
	public void setGetIdTest() {
	  	ProjectCategory category = new ProjectCategory();
	   	category.setId(-1);
	   	assertTrue(-1 == category.getId());
	}
	
	@Test
	public void setGetNameTest() {
	  	ProjectCategory category = new ProjectCategory();
	  	category.setName("testname");
	   	assertTrue("testname" == category.getName());
	}
	/*
	@Test
	public void testProjectCategoryAdd() {
	  	ProjectCategory category = new ProjectCategory();
	  	category.setId(-2);
	  	category.add();
	  	boolean flag = false;
	  	for (ProjectCategory currentCategory: DataSource.allProjectCategories) {
	  		if (-2 == currentCategory.getId()) {
	  			flag = true;
	  		}
	  	}
	   	assertTrue(flag);
	}
	
	@Test
	public void testProjectCategoryUpdate() {
		ProjectCategory category = new ProjectCategory();
	  	category.setId(-3);
	  	category.add();
	  	category.setName("test1");
	  	category.update();
	  	boolean flag = false;
	  	for (ProjectCategory currentCategory: DataSource.allProjectCategories) {
	  		if ("test1" == currentCategory.getName()) {
	  			flag = true;
	  		}
	  	}
	   	assertTrue(flag);
	}
	
	@Test
	public void testProjectCategoryDelete() {
		DataSource.allProjectCategories.clear();
		ProjectCategory category = new ProjectCategory();
	  	category.setId(-4);
	  	category.add();
	  	category.delete();
	   	assertTrue(DataSource.allProjectCategories.size() == 0);
		}
	
	@Test
	public void testProjectCategoryGetById() {
		ProjectCategory category = new ProjectCategory();
	  	category.setId(-5);
	  	category.add();
	  	ProjectCategory resultCategory = new ProjectCategory();
	  	resultCategory = ProjectCategory.getById(-5);
	   	assertTrue(-5 == resultCategory.getId());
	}
	
	@Test
	public void testProjectCategoryGetByAbsentId() {
		ProjectCategory category = new ProjectCategory();
	  	category.setId(-5);
	  	category.add();
	  	ProjectCategory resultCategory = new ProjectCategory();
	  	resultCategory = ProjectCategory.getById(-500);
	   	assertTrue(0 == resultCategory.getId());
	}
	
	@Test
	public void testProjectCategoryGetByName() {
		ProjectCategory category = new ProjectCategory();
	  	category.setName("testProjectCategoryGetByName");
	  	category.add();
	  	ProjectCategory resultCategory = new ProjectCategory();
	  	resultCategory = ProjectCategory.getByName("testProjectCategoryGetByName");
	   	assertTrue("testProjectCategoryGetByName" == resultCategory.getName());
	}
	
	@Test
	public void testProjectCategoryGetByAbsentName() {
		ProjectCategory category = new ProjectCategory();
	  	category.setName("testProjectCategoryGetByAbsentName");
	  	category.add();
	  	ProjectCategory resultCategory = new ProjectCategory();
	  	resultCategory = ProjectCategory.getByName("skdjfgsdgflkgLKDFHGJLSF");
	   	assertTrue("" == resultCategory.getName());
	}
	*/
}
