package myRealization;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProjectsTest {
	@Test
	public void shouldGetProjectByIndex(){
		//given
		Projects projects = new Projects();
		
		//when
		Category category1 = new Category("category1");
		Project project1 = new Project(category1);
		projects.addProject(project1);
		projects.chooseProjects(category1);
		
		//then
		assertSame(project1, projects.readObject(0));
	}

	@Test
	public void shouldGiveShortInfoOfProject(){
		//given
		Projects projects = new Projects();
		
		//when
		Category category1 = new Category("category1");
		Project project1 = new Project(category1);
		project1.setProject("project1", "Some dscr", 100, 31, 2, "some history", "video", "FAQ");
		
		//then
		assertEquals(" Name - project1, Description - Some dscr, Money we need - 100, Money we have - 31, Days left - 2",
				projects.writeProject(project1));
	}
	
	@Test
	public void shouldMakeArrayOfData_whenProjectInitialized(){
		//given
		Projects projects = new Projects();
		
		//when
		Category category1 = new Category("category1");
		Project project1 = new Project(category1);
		project1.setProject("project1", "Some dscr", 100, 31, 2, "some history", "video", "FAQ");
		projects.addProject(project1);
		projects.chooseProjects(category1);
		
		//then
		assertEquals(1, projects.writeProjects().size());
	}
	
	@Test
	public void shouldSelectOneProject_whenTwoProjectsWithDifferentCategoriesInitialized(){
		//given
		Projects projects = new Projects();
		
		//when
		Category category1 = new Category("category1");
		Category category2 = new Category("category2");
		Project project1 = new Project(category1);
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
		//given
		Projects projects = new Projects();
		
		//when
		Category category1 = new Category("category1");
		Category category2 = new Category("category2");
		Project project1 = new Project(category1);
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
		//given
		Projects projects = new Projects();
		
		//when
		Category category1 = new Category("category1");
		Category category2 = new Category("category2");
		Project project1 = new Project(category1);
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