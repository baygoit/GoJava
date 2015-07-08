package belskii.artem.kickstarter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProjectsTest {
	
	private static Projects retriveProjectFromDatabase() {
		Projects projects = new Projects();
		projects.addProject("Art","Museum of Digital Art", "Opening its doors with your help, the Museum of Digital Art will be Europe's first physical & virtual museum \ndedicated to digital arts.");

		return projects;
	}
	
	@Test
	public void testProcessListRetrieving() {
		Projects projectModel = retriveProjectFromDatabase(); 
		ProjectsView projectsView = new ProjectsView();
		ProjectsController projectsController = new ProjectsController(projectModel, projectsView);
		String expectedValue = "[{Category=Art, Details=Opening its doors with your help, the Museum of Digital Art will be Europe's first physical & virtual museum \ndedicated to digital arts., Title=Museum of Digital Art}]";
		assertEquals(expectedValue, projectsController.getProjectList().toString());
	}
	


}
