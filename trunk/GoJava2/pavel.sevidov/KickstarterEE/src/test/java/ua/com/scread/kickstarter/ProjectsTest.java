package ua.com.scread.kickstarter;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import ua.com.scread.kickstarter.data.AdditionalInfo;
import ua.com.scread.kickstarter.data.Bonus;
import ua.com.scread.kickstarter.data.Category;
import ua.com.scread.kickstarter.data.FAQ;
import ua.com.scread.kickstarter.data.Project;
import ua.com.scread.kickstarter.storage.Bonuses;
import ua.com.scread.kickstarter.storage.FAQs;
import ua.com.scread.kickstarter.storage.Projects;


public abstract class ProjectsTest {
	FAQs faq = new FAQs(new FAQ("question", "answer"));
	Bonuses bonuses = new Bonuses(new Bonus(50, "Description"));
	AdditionalInfo details = new AdditionalInfo("History", "video", bonuses, faq);
	Project project = new Project("Project", "Description", 1, 1, details);
	Projects projects = setUp();
	
	abstract Projects setUp();
	
	@Test
	public void shouldAddProject_whenAddedProject() {
		projects.add(project);
//		assertEquals(project, projects.getProjects().get(0));
	}
	
	@Test
	public void sholudReturnEmpty_whenEmptyProjects() {
//		assertEquals(new ArrayList<Category>(), projects.getProjects());
	}
	
	@Test
	public void shouldBeProject_whenGetProjectByCategory() {
		Category category = new Category("Vasya");
		project.setCategory(category);
		ArrayList<Project> expected = new ArrayList<Project>();
		expected.add(project);
		projects.add(project);
		assertEquals(expected, projects.getProjects(category));
	}
	
	@Test
    public void shouldReturnSize_whenGetSize() {
//        assertEquals(0, projects.size());
        
        projects.add(project);
        
//        assertEquals(1, projects.size());
    }

}
