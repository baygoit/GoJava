package ua.dborisenko.kickstarter;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProjectTest {
	
    @Test
    public void setGetIdTest() {
       Project project = new Project();
       project.setId(-1);
       assertTrue(-1 == project.getId());
    }
	
	@Test
	public void setGetNameTest() {
	  	Project project = new Project();
	  	project.setName("testname");
	   	assertTrue("testname" == project.getName());
	}
	
	@Test
	public void setGetCategoryTest() {
	  	Project project = new Project();
	  	ProjectCategory category = new ProjectCategory();
	  	project.setCategory(category);
	   	assertFalse(null == project.getCategory());
	}
	
	@Test
	public void setGetDescriptionTest() {
	  	Project project = new Project();
	  	project.setDescription("testdescription");
	   	assertTrue("testdescription" == project.getDescription());
	}
	
	@Test
	public void setGetHistoryTest() {
	  	Project project = new Project();
	  	project.setHistory("testhistory");
	   	assertTrue("testhistory" == project.getHistory());
	}
	
	@Test
	public void setGetRequiredSumTest() {
	  	Project project = new Project();
	  	project.setRequiredSum(10);
	   	assertTrue(10 == project.getRequiredSum());
	}
	
	@Test
	public void setGetCollectedSumTest() {
	  	Project project = new Project();
	  	project.setCollectedSum(100);
	   	assertTrue(100 == project.getCollectedSum());
	}
	
	@Test
	public void setGetDaysLeftTest() {
	  	Project project = new Project();
	  	project.setDaysLeft(200);
	   	assertTrue(200 == project.getDaysLeft());
	}
	
	@Test
	public void setGetVideoUrlTest() {
	  	Project project = new Project();
	  	project.setVideoUrl("qqq");
	   	assertEquals("qqq", project.getVideoUrl());
	}
	
	@Test
	public void setGetDiscussionUrlTest() {
	  	Project project = new Project();
	  	project.setDiscussionUrl("qqqwww");
	   	assertEquals("qqqwww", project.getDiscussionUrl());
	}
	
	@Test
    public void getCategoryIdTest() {
        ProjectCategory category = new ProjectCategory();
        category.setId(1);
	    Project project = new Project();
	    project.setCategory(category);
        assertTrue(1 == project.getCategoryId());
    }
	
	@Test
    public void getCategoryNameTest() {
        ProjectCategory category = new ProjectCategory();
        category.setName("testname");
        Project project = new Project();
        project.setCategory(category);
        assertEquals("testname", project.getCategoryName());
    }
	
	/*
	@Test
	public void testProjectAdd() {
	  	Project project = new Project();
	  	project.setId(9292);
	  	project.add();
	  	boolean flag = false;
	  	for (Project currentProject: DataSource.allProjects) {
	  		if (9292 == currentProject.getId()) {
	  			flag = true;
	  		}
	  	}
	   	assertTrue(flag);
	   	}
	
	@Test
	public void testProjectUpdate() {
	  	Project project = new Project();
	  	project.setId(9293);
	  	project.add();
	  	project.setName("test111");
	  	project.update();
	  	boolean flag = false;
	  	for (Project currentProject: DataSource.allProjects) {
	  		if ("test111" == currentProject.getName()) {
	  			flag = true;
	  		}
	  	}
	   	assertTrue(flag);
	}
	
	@Test
	public void testProjectDelete() {
		DataSource.allProjects.clear();
		Project project = new Project();
	  	project.setId(9293);
	  	project.add();
	  	project.delete();
	  	assertTrue(DataSource.allProjects.size() == 0);
	}
	
	@Test
	public void testProjectgetProjectsByCategoryId() {
		DataSource.allProjects.clear();
		ProjectCategory category = new ProjectCategory();
		category.setId(999);
		category.add();
		Project project = new Project();
		project.setCategory(category);
		project.add();
		List<Project> resultProjects = Project.getProjectsByCategoryId(999);
		assertTrue(resultProjects.size() > 0);
		}
	
	@Test
	public void testProjectgetCategoryName() {
		DataSource.allProjects.clear();
		ProjectCategory category = new ProjectCategory();
		category.setId(999);
		category.setName("ashgd");
		Project project = new Project();
		project.setCategory(category);
		assertTrue("ashgd" == project.getCategoryName());
		}
	*/
}
