package ua.com.goit.gojava7.kickstarter.view;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Quote;
import ua.com.goit.gojava7.kickstarter.util.Utils;

public class MainPageTest {

	ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	ConsolePrinter page = new ConsolePrinter(new PrintStream(outContent));

	@Test
	public void showQuote() {
		Quote quote = new Quote("testAuthor", "testText");
		page.showQuote(quote);

		String content = outContent.toString();
		assertThat(content.indexOf(quote.getAuthor()), not(-1));
		assertThat(content.indexOf(quote.getText()), not(-1));
	}

	@Test
	public void showProjectDetails() {
		Project project = getMockProject();
		page.showProjectDetails(project);
		
		String content = outContent.toString();
		assertThat(content.indexOf(project.getName()), not(-1));
		assertThat(content.indexOf(project.getDescription()), not(-1));
	}

	private Project getMockProject() {
		Project project = new Project("Xpand Lacing System", "Charles Harris", 1);
		project.setDescription("Get your shoes on in 3 seconds flat! No more bows, no more knots, no more tying!");
		project.setStartDate(Utils.dateFromString("dd.MM.yyyy", "25.10.2015"));
		project.setEndDate(Utils.dateFromString("dd.MM.yyyy", "25.11.2015"));
		project.setVideoUrl("https://www.youtube.com/watch?v=PaEnaoydUUo");
		return project;
	}

	@Test
	public void showMessage() {
		String message = "testmessage";
		page.showMessage(message);
		
		String content = outContent.toString();
		assertThat(content.indexOf(message), not(-1));
	}
	
	@Test
	public void showPaymentRequest() {
		page.showPaymentRequest();
		
		String content = outContent.toString();
		assertThat(content.isEmpty(), is(false));
	}
	
	@Test
	public void showProjects() {

		Collection<Project> projects = new ArrayList<>();
		projects.add(new Project("pr1", null, 1));
		
		projects.add(new Project("pr2", null, 2));

		page.showProjects(projects);
		
		String content = outContent.toString();
		
		projects.forEach(project -> assertThat(content.indexOf(project.getName()), not(-1)));
	}
}
