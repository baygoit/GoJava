package kickstarter.interfaces.display;

import static org.junit.Assert.*;
import kickstarter.engine.Category;
import kickstarter.engine.Project;

import org.junit.Test;

public class ProjectDisplayTest {

	@Test
	public void shouldMainProjectFields_whenGetDescription() {
		Category sport = new Category("Sport");
		Project project = new Project("velo parking", "velo parking in Kiev", sport, 10000, 100);
		Display<Project> display = new ProjectDisplay();
		
		String result = display.getDescription(project);

		StringBuilder expectedResult = new StringBuilder();
		expectedResult.append(project.getId());
		expectedResult.append(" - velo parking");
		expectedResult.append(", description=velo parking in Kiev");
		expectedResult.append(", totalAmount=10000");
		expectedResult.append(", collectAmount=0");
		expectedResult.append(", daysLeft=100");
		
		assertEquals(expectedResult.toString(), result); 
	}

	@Test
	public void shouldAllProjectFields_whenGetDetailedDescription() {
		Project project = new Project("velo parking", "velo parking in Kiev", new Category("Sport"), 10000, 100);
		project.donate(2000);
		project.donate(5000);
		project.setHistory("History");
		project.setLink("www.project1.com");
		project.setQuestionsAndAnswers("why/because");
		
		Display<Project> display = new ProjectDisplay();
		
		String result = display.getDetailedDescription(project);

		StringBuilder expectedResult = new StringBuilder();
		expectedResult.append("name=velo parking");
		expectedResult.append("\r\n description=velo parking in Kiev");
		expectedResult.append("\r\n totalAmount=10000");
		expectedResult.append("\r\n collectAmount=7000");
		expectedResult.append("\r\n daysLeft=100");
		expectedResult.append("\r\n history=History");
		expectedResult.append("\r\n link=www.project1.com");
		expectedResult.append("\r\n questionsAndAnswers=why/because");
		
		assertEquals(expectedResult.toString(), result); 
	}

}
