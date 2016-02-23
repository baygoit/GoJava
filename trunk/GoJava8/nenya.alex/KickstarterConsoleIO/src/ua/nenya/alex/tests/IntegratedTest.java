package ua.nenya.alex.tests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;

import ua.nenya.alex.builders.UserBuilder;
import ua.nenya.alex.main.Kickstarter;
import ua.nenya.alex.pages.CreateProjectPage;
import ua.nenya.alex.pages.ProjectPage;
import ua.nenya.alex.pages.RegistrationPage;
import ua.nenya.alex.project.Category;
import ua.nenya.alex.project.Project;
import ua.nenya.alex.users.RegisteredUser;
import ua.nenya.alex.users.User;
import ua.nenya.alex.util.IO;
import ua.nenya.alex.util.ListUtilits;

public class IntegratedTest {
	
	private IO io;
	private User user;
	private Kickstarter kickstarter;
	private Category mockCategory;
	private Project mockProject;
	private Category category1;
	private Project project;
	private Category category;
	private List<Category> list = new ArrayList<>();
	
	@Before
	public void init() {
		io = mock(IO.class);
		user = mock(User.class);
		mockCategory = mock(Category.class);
		mockProject = mock(Project.class);
		kickstarter = new Kickstarter(mockCategory, mockProject, io, user);
		
		project = new Project();
		Project project1 = new Project("Name1", "description1", 100, 10, 100);
		project1.setHistory("some hystory");
		project1.setVideo("video");
		project1.setQuestionAnswer("question");
		Project project11 = new Project("Name11", "description11", 1100, 110, 1100);
		Project project2 = new Project("Name2", "description2", 200, 20, 200);
		
		category = new Category();
		category1 = new Category("category1");
		Category category2 = new Category("category2");
		list.add(category1);
		list.add(category2);
		
		project1.setCategory(category1);
		project11.setCategory(category1);
		project2.setCategory(category2);
		
		project.getProjectsList().add(project1);
		project.getProjectsList().add(project11);
		project.getProjectsList().add(project2);
		
		category.getCategoriesList().add(category1);
		category.getCategoriesList().add(category2);
	}

	@Test
	public void runTest0() {
		when(io.readConsole()).thenReturn("0");
		
		kickstarter.run();
		
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(io, times(6)).writeln(captor.capture());
        assertEquals(
                "[Healthy curiosity is a great key in innovation., "
                + "Choose one of the items bellow, "
                + "or 0 for coming back to previous menu, "
                + "1	-	Guest, "
                + "2	-	Registered user, "
                + "3	-	Registration]", captor.getAllValues().toString());
	}
	
	@Test
	public void runTest1() {
		when(io.readConsole()).thenReturn("1").thenReturn("0");
		
		kickstarter.run();
		
		InOrder order = inOrder(io, user);
      order.verify(io).writeln("Healthy curiosity is a great key in innovation.");
      order.verify(io).writeln("Choose one of the items bellow");
      order.verify(io).writeln("or 0 for coming back to previous menu");
      order.verify(io).writeln("1	-	Guest");
      order.verify(io).writeln("2	-	Registered user");
      order.verify(io).writeln("3	-	Registration");
	}
	
	@Test
	public void runTest2() {
		when(io.readConsole()).thenReturn("2").thenReturn("0");
		
		kickstarter.run();
		
		InOrder order = inOrder(io);
      order.verify(io).writeln("Healthy curiosity is a great key in innovation.");
      order.verify(io, times(2)).writeln("Choose one of the items bellow");
      order.verify(io).writeln("or 0 for coming back to previous menu");
      order.verify(io).writeln("1	-	Guest");
      order.verify(io).writeln("2	-	Registered user");
      order.verify(io).writeln("3	-	Registration");
	}
	
	@Test
	public void runTest3() {
		when(io.readConsole()).thenReturn("3").thenReturn("").thenReturn("0");
		
		kickstarter.run();
		
		InOrder order = inOrder(io);
      order.verify(io).writeln("Healthy curiosity is a great key in innovation.");
      order.verify(io, times(2)).writeln("Choose one of the items bellow");
      order.verify(io).writeln("or 0 for coming back to previous menu");
      order.verify(io).writeln("1	-	Guest");
      order.verify(io).writeln("2	-	Registered user");
      order.verify(io).writeln("3	-	Registration");
	}
	
	@Test
	public void runTest4() {
		when(io.readConsole()).thenReturn("as").thenReturn("0");
		
		kickstarter.run();
		
		InOrder order = inOrder(io);
      order.verify(io).writeln("Healthy curiosity is a great key in innovation.");
      order.verify(io).writeln("Choose one of the items bellow");
      order.verify(io).writeln("or 0 for coming back to previous menu");
      order.verify(io).writeln("1	-	Guest");
      order.verify(io).writeln("2	-	Registered user");
      order.verify(io).writeln("3	-	Registration");
	}
	
	@Test
	public void runTest5() {
		when(io.readConsole()).thenReturn("3").thenReturn("alex").thenReturn("1")
		.thenReturn("1").thenReturn("a@a.ua").thenReturn("0");
		
		kickstarter.run();
		
		
		InOrder order = inOrder(io);
	      order.verify(io).writeln("Healthy curiosity is a great key in innovation.");
	      order.verify(io, times(2)).writeln("Choose one of the items bellow");
	      order.verify(io).writeln("or 0 for coming back to previous menu");
	      order.verify(io).writeln("1	-	Guest");
	      order.verify(io).writeln("2	-	Registered user");
	      order.verify(io).writeln("3	-	Registration");
	}
	
	@Test
	public void runTest6() {
		when(io.readConsole()).thenReturn("-12").thenReturn("0");
		
		kickstarter.run();
		
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(io, times(6)).writeln(captor.capture());
        assertEquals(
                "[Healthy curiosity is a great key in innovation., "
                + "Choose one of the items bellow, "
                + "or 0 for coming back to previous menu, "
                + "1	-	Guest, "
                + "2	-	Registered user, "
                + "3	-	Registration]", captor.getAllValues().toString());
	}
	
	@Test
	public void registrationTest0() {
		when(io.readConsole()).thenReturn("alex").thenReturn("111").thenReturn("111").thenReturn("a@a.ua");
		UserBuilder userBuilder = new UserBuilder();
		userBuilder.createAll("Login_Password.txt");
		User newUser = userBuilder.getUser();
		
		new RegistrationPage().registration(newUser, io);
		
		InOrder order = inOrder(io);
	      order.verify(io).writeln("Registration");
	      order.verify(io).write("Enter login: ");
	      order.verify(io).write("Enter password: ");
	      order.verify(io).write("Confirm password: ");
	      order.verify(io).write("Enter email: ");
	      order.verify(io).writeln("You are registered");
	}
	
	@Test
	public void registrationTest1() {
		when(io.readConsole()).thenReturn("");
		
		new RegistrationPage().registration(user, io);
		
		InOrder order = inOrder(io);
	      order.verify(io).writeln("Registration");
	      order.verify(io).write("Enter login: ");
	}
	
	@Test
	public void registrationTest2() {
		when(io.readConsole()).thenReturn("alex").thenReturn("111").thenReturn("222");
		
		new RegistrationPage().registration(user, io);
		
		InOrder order = inOrder(io);
	      order.verify(io).writeln("Registration");
	      order.verify(io).write("Enter login: ");
	      order.verify(io).write("Enter password: ");
	      order.verify(io).write("Confirm password: ");
	}
	
	@Test
	public void registrationTest3() {
		when(io.readConsole()).thenReturn("alex").thenReturn("a").thenReturn("a").thenReturn("a@.ua");
		
		new RegistrationPage().registration(user, io);
		
		InOrder order = inOrder(io);
	      order.verify(io).writeln("Registration");
	      order.verify(io).write("Enter login: ");
	      order.verify(io).write("Enter password: ");
	      order.verify(io).write("Confirm password: ");
	      order.verify(io).write("Enter email: ");
	      order.verify(io).writeln("Email is invalid!");
	}
	
	@Test
	public void registrationTest4() {
		when(io.readConsole()).thenReturn("a");
		UserBuilder userBuilder = new UserBuilder();
		userBuilder.createAll("Login_Password.txt");
		User newUser = userBuilder.getUser();
		
		new RegistrationPage().registration(newUser, io);
		
		InOrder order = inOrder(io);
	      order.verify(io).writeln("Registration");
	      order.verify(io).write("Enter login: ");
	      order.verify(io).writeln("User with login a alredy exists!");
	      order.verify(io).writeEmpty();
	}
	
	
	@Test
	public void projectPageTest0() {
		when(io.readConsole()).thenReturn("1").thenReturn("0");

		
		
		new ProjectPage().showTotalProject(project, io, category1, new ListUtilits());
		
		InOrder order = inOrder(io);
		order.verify(io).writeln("Choose one of the items bellow");
	    order.verify(io).writeln("or 0 for coming back to previous menu");
	    order.verify(io).writeln("Progect's name:		"+"Name1");
	    order.verify(io).writeln("Description:		" + "description1");
	    order.verify(io).writeln("Needed amount:		" + 100);
	    order.verify(io).writeln("Available amount:	" + 10);
	    order.verify(io).writeln("Remaining days:		" + 100);
	    order.verify(io).writeln("History		" + "some hystory");
	    order.verify(io).writeln("Video		" + "video");
	    order.verify(io).writeln("Question:		" + "question");
	    order.verify(io).writeln("------------------------------------------");
	}
	
	@Test
	public void projectPageTest1() {
		when(io.readConsole()).thenReturn("1").thenReturn("2").thenReturn("y").thenReturn("Ask smth").thenReturn("0");

		
		
		new ProjectPage().showTotalProject(project, io, category1, new ListUtilits());
		
		InOrder order = inOrder(io);
		order.verify(io).writeln("Choose one of the items bellow");
	    order.verify(io).writeln("or 0 for coming back to previous menu");
	    order.verify(io).writeln("Progect's name:		"+"Name1");
	    order.verify(io).writeln("Description:		" + "description1");
	    order.verify(io).writeln("Needed amount:		" + 100);
	    order.verify(io).writeln("Available amount:	" + 10);
	    order.verify(io).writeln("Remaining days:		" + 100);
	    order.verify(io).writeln("History		" + "some hystory");
	    order.verify(io).writeln("Video		" + "video");
	    order.verify(io).writeln("Question:		" + "question");
	    order.verify(io).writeln("------------------------------------------");
	    order.verify(io).write("Do you want to ask a question? (y/n): ");
	    order.verify(io).write("Enter your question: ");
	    
	}
	
	@Test
	public void projectPageTest2() {
		when(io.readConsole()).thenReturn("1").thenReturn("2").thenReturn("n").thenReturn("0");

		
		
		new ProjectPage().showTotalProject(project, io, category1, new ListUtilits());
		
		InOrder order = inOrder(io);
		order.verify(io).writeln("Choose one of the items bellow");
	    order.verify(io).writeln("or 0 for coming back to previous menu");
	    order.verify(io).writeln("Progect's name:		"+"Name1");
	    order.verify(io).writeln("Description:		" + "description1");
	    order.verify(io).writeln("Needed amount:		" + 100);
	    order.verify(io).writeln("Available amount:	" + 10);
	    order.verify(io).writeln("Remaining days:		" + 100);
	    order.verify(io).writeln("History		" + "some hystory");
	    order.verify(io).writeln("Video		" + "video");
	    order.verify(io).writeln("Question:		" + "question");
	    order.verify(io).writeln("------------------------------------------");
	    order.verify(io).write("Do you want to ask a question? (y/n): ");
	    
	}
	
	@Test
	public void projectPageTest3() {
		when(io.readConsole()).thenReturn("1").thenReturn("1").thenReturn("name").thenReturn("card")
		.thenReturn("1").thenReturn("y").thenReturn("0");
		
		new ProjectPage().showTotalProject(project, io, category1, new ListUtilits());
		
		InOrder order = inOrder(io);
		order.verify(io).writeln("Choose one of the items bellow");
	    order.verify(io).writeln("or 0 for coming back to previous menu");
	    order.verify(io).writeln("Progect's name:		"+"Name1");
	    order.verify(io).writeln("Description:		" + "description1");
	    order.verify(io).writeln("Needed amount:		" + 100);
	    order.verify(io).writeln("Available amount:	" + 10);
	    order.verify(io).writeln("Remaining days:		" + 100);
	    order.verify(io).writeln("History		" + "some hystory");
	    order.verify(io).writeln("Video		" + "video");
	    order.verify(io).writeln("Question:		" + "question");
	    order.verify(io).writeln("------------------------------------------");
	    order.verify(io).write("Enter your name: ");
	    order.verify(io).write("Enter a number of card: ");
	    order.verify(io).write("Are you sure? (y/n): ");
	    order.verify(io).writeln("Your investition has added!");
	}
	
	@Test
	public void projectPageTest4() {
		when(io.readConsole()).thenReturn("1").thenReturn("1").thenReturn("name").thenReturn("card")
		.thenReturn("1").thenReturn("n").thenReturn("0");
		
		new ProjectPage().showTotalProject(project, io, category1, new ListUtilits());
		
		InOrder order = inOrder(io);
		order.verify(io).writeln("Choose one of the items bellow");
	    order.verify(io).writeln("or 0 for coming back to previous menu");
	    order.verify(io).writeln("Progect's name:		"+"Name1");
	    order.verify(io).writeln("Description:		" + "description1");
	    order.verify(io).writeln("Needed amount:		" + 100);
	    order.verify(io).writeln("Available amount:	" + 10);
	    order.verify(io).writeln("Remaining days:		" + 100);
	    order.verify(io).writeln("History		" + "some hystory");
	    order.verify(io).writeln("Video		" + "video");
	    order.verify(io).writeln("Question:		" + "question");
	    order.verify(io).writeln("------------------------------------------");
	    order.verify(io).write("Enter your name: ");
	    order.verify(io).write("Enter a number of card: ");
	    order.verify(io).write("Are you sure? (y/n): ");
	}
	
	@Test
	public void projectPageTest5() {
		when(io.readConsole()).thenReturn("1").thenReturn("1").thenReturn("name").thenReturn("card")
		.thenReturn("2").thenReturn("y").thenReturn("0");
		
		new ProjectPage().showTotalProject(project, io, category1, new ListUtilits());
		
		InOrder order = inOrder(io);
		order.verify(io).writeln("Choose one of the items bellow");
	    order.verify(io).writeln("or 0 for coming back to previous menu");
	    order.verify(io).writeln("Progect's name:		"+"Name1");
	    order.verify(io).writeln("Description:		" + "description1");
	    order.verify(io).writeln("Needed amount:		" + 100);
	    order.verify(io).writeln("Available amount:	" + 10);
	    order.verify(io).writeln("Remaining days:		" + 100);
	    order.verify(io).writeln("History		" + "some hystory");
	    order.verify(io).writeln("Video		" + "video");
	    order.verify(io).writeln("Question:		" + "question");
	    order.verify(io).writeln("------------------------------------------");
	    order.verify(io).write("Enter your name: ");
	    order.verify(io).write("Enter a number of card: ");
	    order.verify(io).write("Are you sure? (y/n): ");
	    order.verify(io).writeln("Your investition has added!");
	}
	
	@Test
	public void projectPageTest6() {
		when(io.readConsole()).thenReturn("1").thenReturn("1").thenReturn("name").thenReturn("card")
		.thenReturn("2").thenReturn("n").thenReturn("0");
		
		new ProjectPage().showTotalProject(project, io, category1, new ListUtilits());
		
		InOrder order = inOrder(io);
		order.verify(io).writeln("Choose one of the items bellow");
	    order.verify(io).writeln("or 0 for coming back to previous menu");
	    order.verify(io).writeln("Progect's name:		"+"Name1");
	    order.verify(io).writeln("Description:		" + "description1");
	    order.verify(io).writeln("Needed amount:		" + 100);
	    order.verify(io).writeln("Available amount:	" + 10);
	    order.verify(io).writeln("Remaining days:		" + 100);
	    order.verify(io).writeln("History		" + "some hystory");
	    order.verify(io).writeln("Video		" + "video");
	    order.verify(io).writeln("Question:		" + "question");
	    order.verify(io).writeln("------------------------------------------");
	    order.verify(io).write("Enter your name: ");
	    order.verify(io).write("Enter a number of card: ");
	    order.verify(io).write("Are you sure? (y/n): ");
	}
	
	@Test
	public void projectPageTest7() {
		when(io.readConsole()).thenReturn("1").thenReturn("1").thenReturn("name").thenReturn("card")
		.thenReturn("3").thenReturn("y").thenReturn("0");
		
		new ProjectPage().showTotalProject(project, io, category1, new ListUtilits());
		
		InOrder order = inOrder(io);
		order.verify(io).writeln("Choose one of the items bellow");
	    order.verify(io).writeln("or 0 for coming back to previous menu");
	    order.verify(io).writeln("Progect's name:		"+"Name1");
	    order.verify(io).writeln("Description:		" + "description1");
	    order.verify(io).writeln("Needed amount:		" + 100);
	    order.verify(io).writeln("Available amount:	" + 10);
	    order.verify(io).writeln("Remaining days:		" + 100);
	    order.verify(io).writeln("History		" + "some hystory");
	    order.verify(io).writeln("Video		" + "video");
	    order.verify(io).writeln("Question:		" + "question");
	    order.verify(io).writeln("------------------------------------------");
	    order.verify(io).write("Enter your name: ");
	    order.verify(io).write("Enter a number of card: ");
	    order.verify(io).write("Are you sure? (y/n): ");
	    order.verify(io).writeln("Your investition has added!");
	}
	
	@Test
	public void projectPageTest8() {
		when(io.readConsole()).thenReturn("1").thenReturn("1").thenReturn("name").thenReturn("card")
		.thenReturn("3").thenReturn("n").thenReturn("0");
		
		new ProjectPage().showTotalProject(project, io, category1, new ListUtilits());
		
		InOrder order = inOrder(io);
		order.verify(io).writeln("Choose one of the items bellow");
	    order.verify(io).writeln("or 0 for coming back to previous menu");
	    order.verify(io).writeln("Progect's name:		"+"Name1");
	    order.verify(io).writeln("Description:		" + "description1");
	    order.verify(io).writeln("Needed amount:		" + 100);
	    order.verify(io).writeln("Available amount:	" + 10);
	    order.verify(io).writeln("Remaining days:		" + 100);
	    order.verify(io).writeln("History		" + "some hystory");
	    order.verify(io).writeln("Video		" + "video");
	    order.verify(io).writeln("Question:		" + "question");
	    order.verify(io).writeln("------------------------------------------");
	    order.verify(io).write("Enter your name: ");
	    order.verify(io).write("Enter a number of card: ");
	    order.verify(io).write("Are you sure? (y/n): ");
	}@Test
	public void projectPageTest9() {
		when(io.readConsole()).thenReturn("1").thenReturn("1").thenReturn("name").thenReturn("card")
		.thenReturn("4").thenReturn("y").thenReturn("0");
		
		new ProjectPage().showTotalProject(project, io, category1, new ListUtilits());
		
		InOrder order = inOrder(io);
		order.verify(io).writeln("Choose one of the items bellow");
	    order.verify(io).writeln("or 0 for coming back to previous menu");
	    order.verify(io).writeln("Progect's name:		"+"Name1");
	    order.verify(io).writeln("Description:		" + "description1");
	    order.verify(io).writeln("Needed amount:		" + 100);
	    order.verify(io).writeln("Available amount:	" + 10);
	    order.verify(io).writeln("Remaining days:		" + 100);
	    order.verify(io).writeln("History		" + "some hystory");
	    order.verify(io).writeln("Video		" + "video");
	    order.verify(io).writeln("Question:		" + "question");
	    order.verify(io).writeln("------------------------------------------");
	    order.verify(io).write("Enter your name: ");
	    order.verify(io).write("Enter a number of card: ");
	    order.verify(io).write("Are you sure? (y/n): ");
	    order.verify(io).writeln("Your investition has added!");
	}
	
	@Test
	public void projectPageTest10() {
		when(io.readConsole()).thenReturn("1").thenReturn("1").thenReturn("name").thenReturn("card")
		.thenReturn("4").thenReturn("n").thenReturn("0");
		
		new ProjectPage().showTotalProject(project, io, category1, new ListUtilits());
		
		InOrder order = inOrder(io);
		order.verify(io).writeln("Choose one of the items bellow");
	    order.verify(io).writeln("or 0 for coming back to previous menu");
	    order.verify(io).writeln("Progect's name:		"+"Name1");
	    order.verify(io).writeln("Description:		" + "description1");
	    order.verify(io).writeln("Needed amount:		" + 100);
	    order.verify(io).writeln("Available amount:	" + 10);
	    order.verify(io).writeln("Remaining days:		" + 100);
	    order.verify(io).writeln("History		" + "some hystory");
	    order.verify(io).writeln("Video		" + "video");
	    order.verify(io).writeln("Question:		" + "question");
	    order.verify(io).writeln("------------------------------------------");
	    order.verify(io).write("Enter your name: ");
	    order.verify(io).write("Enter a number of card: ");
	    order.verify(io).write("Are you sure? (y/n): ");
	}
	
	@Test
	public void projectPageTest11() {
		when(io.readConsole()).thenReturn("1").thenReturn("1").thenReturn("name").thenReturn("card")
		.thenReturn("5").thenReturn("100").thenReturn("y").thenReturn("0");
		
		new ProjectPage().showTotalProject(project, io, category1, new ListUtilits());
		
		InOrder order = inOrder(io);
		order.verify(io).writeln("Choose one of the items bellow");
	    order.verify(io).writeln("or 0 for coming back to previous menu");
	    order.verify(io).writeln("Progect's name:		"+"Name1");
	    order.verify(io).writeln("Description:		" + "description1");
	    order.verify(io).writeln("Needed amount:		" + 100);
	    order.verify(io).writeln("Available amount:	" + 10);
	    order.verify(io).writeln("Remaining days:		" + 100);
	    order.verify(io).writeln("History		" + "some hystory");
	    order.verify(io).writeln("Video		" + "video");
	    order.verify(io).writeln("Question:		" + "question");
	    order.verify(io).writeln("------------------------------------------");
	    order.verify(io).write("Enter your name: ");
	    order.verify(io).write("Enter a number of card: ");
	    order.verify(io).write("Enter the amount of investition: ");
	    order.verify(io).write("Are you sure? (y/n): ");
	    order.verify(io).writeln("Your investition has added!");
	}
	
	@Test
	public void projectPageTest110() {
		when(io.readConsole()).thenReturn("1").thenReturn("1").thenReturn("name").thenReturn("card")
		.thenReturn("5").thenReturn("vhygy").thenReturn("y").thenReturn("0");
		
		new ProjectPage().showTotalProject(project, io, category1, new ListUtilits());
		
		InOrder order = inOrder(io);
		order.verify(io).writeln("Choose one of the items bellow");
	    order.verify(io).writeln("or 0 for coming back to previous menu");
	    order.verify(io).writeln("Progect's name:		"+"Name1");
	    order.verify(io).writeln("Description:		" + "description1");
	    order.verify(io).writeln("Needed amount:		" + 100);
	    order.verify(io).writeln("Available amount:	" + 10);
	    order.verify(io).writeln("Remaining days:		" + 100);
	    order.verify(io).writeln("History		" + "some hystory");
	    order.verify(io).writeln("Video		" + "video");
	    order.verify(io).writeln("Question:		" + "question");
	    order.verify(io).writeln("------------------------------------------");
	    order.verify(io).write("Enter your name: ");
	    order.verify(io).write("Enter a number of card: ");
	    order.verify(io).write("Enter the amount of investition: ");
	    order.verify(io).writeln("Wrong entering!");
	}
	
	@Test
	public void projectPageTest12() {
		when(io.readConsole()).thenReturn("1").thenReturn("1").thenReturn("name").thenReturn("card")
		.thenReturn("5").thenReturn("100").thenReturn("n").thenReturn("0");
		
		new ProjectPage().showTotalProject(project, io, category1, new ListUtilits());
		
		InOrder order = inOrder(io);
		order.verify(io).writeln("Choose one of the items bellow");
	    order.verify(io).writeln("or 0 for coming back to previous menu");
	    order.verify(io).writeln("Progect's name:		"+"Name1");
	    order.verify(io).writeln("Description:		" + "description1");
	    order.verify(io).writeln("Needed amount:		" + 100);
	    order.verify(io).writeln("Available amount:	" + 10);
	    order.verify(io).writeln("Remaining days:		" + 100);
	    order.verify(io).writeln("History		" + "some hystory");
	    order.verify(io).writeln("Video		" + "video");
	    order.verify(io).writeln("Question:		" + "question");
	    order.verify(io).writeln("------------------------------------------");
	    order.verify(io).write("Enter your name: ");
	    order.verify(io).write("Enter a number of card: ");
	    order.verify(io).write("Enter the amount of investition: ");
	    order.verify(io).write("Are you sure? (y/n): ");
	}
	
	@Test
	public void createProjectPageTest0() {
		when(io.readConsole()).thenReturn("0");
		
		new CreateProjectPage().createProject(io, list, new ListUtilits());
		
		InOrder order = inOrder(io);
		order.verify(io).writeln("Choose one of the items bellow");
	    order.verify(io).writeln("or 0 for coming back to previous menu");
	    order.verify(io).writeln("1	-	Enter name");
	    order.verify(io).writeln("2	-	Enter description");
	    order.verify(io).writeln("3	-	Enter amoun of money");
	    order.verify(io).writeln("4	-	Enter amount of days");
	    order.verify(io).writeln("5	-	Enter category");
	}
	
	@Test
	public void createProjectPageTest2() {
		when(io.readConsole()).thenReturn("1").thenReturn("NewName").thenReturn("2")
		.thenReturn("newDescription").thenReturn("3").thenReturn("100")
		.thenReturn("4").thenReturn("10").thenReturn("5").thenReturn("1").thenReturn("0");
		
		new CreateProjectPage().createProject(io, list, new ListUtilits());
		
		InOrder order = inOrder(io);
		order.verify(io).writeln("Choose one of the items bellow");
	    order.verify(io).writeln("or 0 for coming back to previous menu");
	    order.verify(io).writeln("1	-	Enter name");
	    order.verify(io).writeln("2	-	Enter description");
	    order.verify(io).writeln("3	-	Enter amoun of money");
	    order.verify(io).writeln("4	-	Enter amount of days");
	    order.verify(io).writeln("5	-	Enter category");
	    order.verify(io).write("Enter project's name: ");
	    order.verify(io).write("Enter project's description: ");
	    order.verify(io).writeEmpty();
	    order.verify(io).write("Enter amount of monye needed: ");
	    order.verify(io).write("Enter amount of days needed: ");
	    order.verify(io).write("Choose one of categories: ");
	}
	@Test
	public void createProjectPageTest3() {
		when(io.readConsole()).thenReturn("3").thenReturn("-100").thenReturn("3")
		.thenReturn("asd").thenReturn("4").thenReturn("-100")
		.thenReturn("4").thenReturn("asd").thenReturn("4").thenReturn("10").thenReturn("0");
		
		new CreateProjectPage().createProject(io, list, new ListUtilits());
		
		InOrder order = inOrder(io);
		order.verify(io).writeln("Choose one of the items bellow");
	    order.verify(io).writeln("or 0 for coming back to previous menu");
	    order.verify(io).writeln("1	-	Enter name");
	    order.verify(io).writeln("2	-	Enter description");
	    order.verify(io).writeln("3	-	Enter amoun of money");
	    order.verify(io).writeln("4	-	Enter amount of days");
	    order.verify(io).writeln("5	-	Enter category");
	    order.verify(io).write("Enter amount of monye needed: ");
	    order.verify(io).write("Enter amount of days needed: ");
	}
	
	@Test
	public void createProjectPageTest4() {
		Project projectNew = new Project("Name", "Description", 100, 0 , 25);
		projectNew.setCategory(category.getCategoriesList().get(1));
		when(io.readConsole()).thenReturn("1").thenReturn("Name")
		.thenReturn("2").thenReturn("Description")
		.thenReturn("3").thenReturn("100")
		.thenReturn("4").thenReturn("25")
		.thenReturn("5").thenReturn("1").thenReturn("0");
		assertEquals(projectNew, new CreateProjectPage().createProject(io, category.getCategoriesList(), new ListUtilits()));
	}
	
	@Test
	public void registeredUserTest0() {
		
		when(io.readConsole()).thenReturn("admin").thenReturn("admin").thenReturn("0");
		
		new RegisteredUser().enter(io, user, category, mockProject, new ListUtilits());
		
		InOrder order = inOrder(io);
		order.verify(io).write("Enter login: ");
	    order.verify(io).write("Enter password: ");
	}
	
	@Test
	public void registeredUserTest1() {
		
		when(io.readConsole()).thenReturn("b").thenReturn("b").thenReturn("0");
		User someUser = new User("b", "b", "b@b.ua");
		someUser.getUsersList().add(someUser);
		
		new RegisteredUser().enter(io, someUser, category, mockProject, new ListUtilits());
		
		InOrder order = inOrder(io);
		order.verify(io).write("Enter login: ");
	    order.verify(io).write("Enter password: ");
	}
	
	@Test
	public void registeredUserTest2() {
		
		when(io.readConsole()).thenReturn("").thenReturn("b").thenReturn("0");
		User someUser = new User("b", "b", "b@b.ua");
		someUser.getUsersList().add(someUser);
		
		new RegisteredUser().enter(io, someUser, category, mockProject, new ListUtilits());
		
		InOrder order = inOrder(io);
		order.verify(io).write("Enter login: ");
	    order.verify(io).write("Enter password: ");
	}

	@Test
	public void userTest0() {
		
		when(io.readConsole()).thenReturn("1").thenReturn("0");
		User someUser = new User("b", "b", "b@b.ua");
		someUser.getUsersList().add(someUser);
		
		new User().enter(someUser, category, mockProject, io, "b", "b", new ListUtilits());
		
		InOrder order = inOrder(io);
		order.verify(io).writeln("1	-	category1");
	    order.verify(io).writeln("2	-	category2");
	}
	
	@Test
	public void userTest1() {
		
		when(io.readConsole()).thenReturn("1").thenReturn("y")
		.thenReturn("q").thenReturn("q").thenReturn("q").thenReturn("q@q.ua")
		.thenReturn("0");
		User someUser = new User("b", "b", "b@b.ua");
		someUser.getUsersList().add(someUser);
		
		new User().enter(someUser, category, mockProject, io, "b", "b", new ListUtilits());
		
		InOrder order = inOrder(io);
		order.verify(io).writeln("1	-	category1");
	    order.verify(io).writeln("2	-	category2");
	    order.verify(io).write("Are you ready to register? (y/n): ");
	}
	
	@Test
	public void userTest2() {
		
		when(io.readConsole()).thenReturn("2").thenReturn("0");
		
		new User().enter(user, category, mockProject, io, "b", "b", new ListUtilits());
		
		InOrder order = inOrder(io);
		order.verify(io).writeln("1	-	category1");
	    order.verify(io).writeln("2	-	category2");
	    
	}
	
	@Test
	public void userTest3() {
		
		when(io.readConsole()).thenReturn("1").thenReturn("y").thenReturn("0");
		User someUser = new User("b", "b", "b@b.ua");
		User someUser2 = new User();
		someUser2.getUsersList().add(someUser);
		
		someUser2.enter(someUser, category, project, io, "b", "b", new ListUtilits());
		
		InOrder order = inOrder(io);
		order.verify(io).writeln("1	-	category1");
	    order.verify(io).writeln("2	-	category2");
	    order.verify(io).write("Do you want to create a project? (y/n): ");
	}
	
	@Test
	public void userTest4() {
		
		when(io.readConsole()).thenReturn("1").thenReturn("y")
		.thenReturn("").thenReturn("0");
		User someUser = new User("b", "b", "b@b.ua");
		someUser.getUsersList().add(someUser);
		
		new User().enter(someUser, category, mockProject, io, "b", "b", new ListUtilits());
		
		InOrder order = inOrder(io);
		order.verify(io).writeln("1	-	category1");
	    order.verify(io).writeln("2	-	category2");
	    order.verify(io).write("Are you ready to register? (y/n): ");
	}
	
	@Test
	public void userTest5() {
		
		when(io.readConsole()).thenReturn("1").thenReturn("n").thenReturn("0");
		User someUser = new User("b", "b", "b@b.ua");
		User someUser2 = new User();
		someUser2.getUsersList().add(someUser);
		
		someUser2.enter(someUser, category, project, io, "b", "b", new ListUtilits());
		
		InOrder order = inOrder(io);
		order.verify(io).writeln("1	-	category1");
	    order.verify(io).writeln("2	-	category2");
	    order.verify(io).write("Do you want to create a project? (y/n): ");
	}
}
