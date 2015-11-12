package com.kickstarter.view;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.junit.Test;

import com.kickstarter.beans.Project;
import com.kickstarter.beans.Quote;
import com.kickstarter.beans.User;
import com.kickstarter.util.Utils;

public class MainPageTest {

	ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	MainPage page = new MainPage(new PrintStream(outContent));

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
		Project project = Project.newBuilder().setName("Xpand Lacing System")
				.setDescription("Get your shoes on in 3 seconds flat! No more bows, no more knots, no more tying!")
				.setStartDate(Utils.dateFromString("dd.MM.yyyy", "25.10.2015"))
				.setEndDate(Utils.dateFromString("dd.MM.yyyy", "25.11.2015"))
				.setAuthor(new User("Charles Harris", ""))
				.setVideoURL("https://www.youtube.com/watch?v=PaEnaoydUUo").build();
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
		Project project = getMockProject();
		page.showPaymentRequest(project);
		
		String content = outContent.toString();
		assertThat(content.isEmpty(), is(false));
	}
	
	@Test
	public void showProjects() {
		Collection<Project> projects = new ArrayList<>();
		projects.add(Project.newBuilder().setName("test1")
				.setDescription("Description1")
				.setStartDate(new Date())
				.setEndDate(new Date())
				.build());
		
		projects.add(Project.newBuilder().setName("test2")
				.setDescription("Description2")
				.setStartDate(new Date())
				.setEndDate(new Date())
				.build());

		page.showProjects(projects);
		
		String content = outContent.toString();
		
		projects.forEach(project -> assertThat(content.indexOf(project.getName()), not(-1)));
	}
}
