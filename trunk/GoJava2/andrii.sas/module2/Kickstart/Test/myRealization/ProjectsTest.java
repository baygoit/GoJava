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
}