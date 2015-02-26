package ua.com.sas.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

public abstract class ProjectsTest {
	
	private Projects projects;
	private Category category1;
	private Project project1;
	private Category category2;

	@Before
	public void start(){
		projects = getProjects();
		category1 = new Category("category1");
		category2 = new Category("category2");
		project1 = new Project(category1);
	}
	
	abstract Projects getProjects();
	
	@Test
	public void shouldGetProjectByIndex(){
		//when
		projects.addProject(project1);
		projects.chooseProjects(category1);
		
		//then
		assertSame(project1, projects.readObject(0));
	}

	@Test
	public void shouldGiveShortInfoOfProject(){
		//when
		project1.setProject("project1", "Some dscr", 100, 31, 2, "some history", "video", "FAQ");
		
		//then
		assertEquals(" Name - project1, Description - Some dscr, Money we need - 100, Money we have - 31, Days left - 2",
				projects.writeProject(project1));
	}
	
	@Test
	public void shouldMakeArrayOfData_whenProjectInitialized(){
		//when
		project1.setProject("project1", "Some dscr", 100, 31, 2, "some history", "video", "FAQ");
		projects.addProject(project1);
		projects.chooseProjects(category1);
		
		//then
		assertEquals(1, projects.writeProjects().size());
	}
	
	@Test
	public void shouldSelectOneProject_whenTwoProjectsWithDifferentCategoriesInitialized(){
		//when
		Project project2 = new Project(category2);
		project1.setProject("project1", "Some dscr", 100, 31, 2, "some history", "video", "FAQ");
		project2.setProject("project2", "Some dscr2", 100, 31, 2, "some history2", "video2", "FAQ2");
		projects.addProject(project1);
		projects.addProject(project2);
		projects.chooseProjects(category2);
		String testedProject = projects.writeProject(project2);
		
		//then
		assertEquals(1, projects.writeProjects().size());
		assertEquals(testedProject, projects.readProject(0));
	}
	
	@Test
	public void shouldReturnEmptyList_whenSelectedCategoryWithNoProjectsInIt(){
		//when
		Project project2 = new Project(category1);
		project1.setProject("project1", "Some dscr", 100, 31, 2, "some history", "video", "FAQ");
		project2.setProject("project2", "Some dscr2", 100, 31, 2, "some history2", "video2", "FAQ2");
		projects.addProject(project1);
		projects.addProject(project2);
		projects.chooseProjects(category2);
		
		//then
		assertEquals(0, projects.writeProjects().size());
	}
	
	@Test
	public void shouldBeArrayWithThreeElements(){
		//when
		Project project2 = new Project(category2);
		project1.setProject("project1", "Some dscr", 100, 31, 2, "some history", "video", "FAQ");
		project2.setProject("project2", "Some dscr2", 100, 31, 2, "some history2", "video2", "FAQ2");
		projects.addProject(project1);
		projects.addProject(project2);
		
		//then
		assertEquals(3, projects.giveAllInfo(project1).size());
		assertEquals(3, projects.giveAllInfo(project2).size());
		assertEquals("[some history, video, FAQ]", projects.giveAllInfo(project1).toString());
		assertEquals("[some history2, video2, FAQ2]", projects.giveAllInfo(project2).toString());
	}
	
	
}