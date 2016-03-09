package ua.nenya.alex.tests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertNotEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;



import ua.nenya.alex.main.Kickstarter;
import ua.nenya.alex.pages.AskingQuestionPage;
import ua.nenya.alex.pages.CreatingProjectPage;
import ua.nenya.alex.pages.EnteringPage;
import ua.nenya.alex.pages.InvestitionProjectPage;
import ua.nenya.alex.pages.ProjectPage;
import ua.nenya.alex.pages.RegistrationPage;
import ua.nenya.alex.project.Category;
import ua.nenya.alex.project.Categories;
import ua.nenya.alex.project.Project;
import ua.nenya.alex.project.Projects;
import ua.nenya.alex.users.User;
import ua.nenya.alex.users.Users;
import ua.nenya.alex.util.ConsoleIOImpl;
import ua.nenya.alex.util.IO;
import ua.nenya.alex.util.ListUtilits;

public class IntegratedTest {
	
	private IO mockIo;
	private Category musicCategory;
	private Projects projects;
	private Categories categoryInit;
	private Users users;
	private Project newSongProject;
	private List<Category> list = new ArrayList<>();
	private List<User> userList = new ArrayList<>();
	private RegistrationPage registrationPage = new RegistrationPage();
	
	@Before
	public void init() {
		mockIo = mock(IO.class);
		
		users = new Users();
		User userAlex = new User("alex", "111", "a@a.ua");
		users.getUsers().add(userAlex);
		userList = users.getUsers();

		projects = new Projects();
		newSongProject = new Project("New Song", "description of new song", 100, 10, 100);
		newSongProject.setHistory("hystory of new song");
		newSongProject.setVideo("video about new song");
		newSongProject.setQuestionAnswer("question about new song");
		Project oldSongProject = new Project("Old song", "description of old song", 1100, 110, 1100);
		Project filmProject = new Project("Film", "description of film", 200, 20, 200);
		
		categoryInit = new Categories();
		musicCategory = new Category("Music");
		Category filmsCategory = new Category("Films");
		Category createProjectCategory = new Category("Create a project");
		list.add(musicCategory);
		list.add(filmsCategory);
		
		newSongProject.setCategory(musicCategory);
		oldSongProject.setCategory(musicCategory);
		filmProject.setCategory(filmsCategory);
		
		projects.getProjects().add(newSongProject);
		projects.getProjects().add(oldSongProject);
		projects.getProjects().add(filmProject);
		
		categoryInit.getCategories().add(musicCategory);
		categoryInit.getCategories().add(filmsCategory);
		categoryInit.getCategories().add(createProjectCategory);
	}

	@Test
	public void kikstarterTestEnter0() {
		when(mockIo.readConsole()).thenReturn("0");
		
		new Kickstarter(userList, categoryInit.getCategories(), projects, mockIo).run();
		
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockIo, times(8)).writeln(captor.capture());
        assertEquals(
                "[Healthy curiosity is a great key in innovation., , "
                + "Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	Music, "
                + "2	-	Films, "
                + "3	-	Create a project]", captor.getAllValues().toString());
	}
	

	@Test
	public void kikstarterTestEnter10() {
		when(mockIo.readConsole()).thenReturn("1").thenReturn("0");
		
		new Kickstarter(userList, categoryInit.getCategories(), projects, mockIo).run();
		
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockIo, times(32)).writeln(captor.capture());
        assertEquals(
                "[Healthy curiosity is a great key in innovation., , "
                + "Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	Music, "
                + "2	-	Films, "
                + "3	-	Create a project, "
                + "You've chosen Music, "
                + "Progect name:		New Song, "
                + "Description:		description of new song, "
                + "Needed amount:		100, "
                + "Available amount:	10, "
                + "Remaining days:		100, "
                + "------------------------------------------, "
                + "Progect name:		Old song, "
                + "Description:		description of old song, "
                + "Needed amount:		1100, "
                + "Available amount:	110, "
                + "Remaining days:		1100, "
                + "------------------------------------------, "
                + "Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	New Song, "
                + "2	-	Old song, "
                + "Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	Music, "
                + "2	-	Films, "
                + "3	-	Create a project]", captor.getAllValues().toString());
		
	}
	
	@Test
	public void kikstarterTestEnter30() {
		when(mockIo.readConsole()).thenReturn("3").thenReturn("0");
		
		new Kickstarter(userList, categoryInit.getCategories(), projects, mockIo).run();
		
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockIo, times(20)).writeln(captor.capture());
        assertEquals(
                "[Healthy curiosity is a great key in innovation., , "
                + "Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	Music, "
                + "2	-	Films, "
                + "3	-	Create a project, "
                + "You've chosen Create a project, "
                + "Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	Enter, "
                + "2	-	Registration, "
                + "Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	Music, "
                + "2	-	Films, "
                + "3	-	Create a project]", captor.getAllValues().toString());
	}
	
	@Test
	public void listUtilitsTest0() {
		when(mockIo.readConsole()).thenReturn("-12").thenReturn("0");
		new ListUtilits().choseIndexFromList(list, mockIo);
		InOrder order = inOrder(mockIo);
		order.verify(mockIo).writeln("Number is out of range! Try again!");
	}

	@Test
	public void listUtilitsTest1() {
		when(mockIo.readConsole()).thenReturn("12").thenReturn("0");
		new ListUtilits().choseIndexFromList(list, mockIo);
		InOrder order = inOrder(mockIo);
		order.verify(mockIo).writeln("Number is out of range! Try again!");
	}

	@Test
	public void listUtilitsTest2() {
		when(mockIo.readConsole()).thenReturn("zxc").thenReturn("0");
		new ListUtilits().choseIndexFromList(list, mockIo);
		InOrder order = inOrder(mockIo);
		order.verify(mockIo).writeln("Wrong entering!!! Try again!");
	}
	
	@Test
	public void registrationPageTestUserExists() {
		
		when(mockIo.readConsole()).thenReturn("alex");
		
		registrationPage.registration(userList, mockIo);
		
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockIo, times(2)).writeln(captor.capture());
        assertEquals(
                "[User with login alex alredy exists!, ]"
               , captor.getAllValues().toString());
	}
	
	@Test
	public void registrationPageTestInvalidLogin() {
		when(mockIo.readConsole()).thenReturn("");
		
		registrationPage.registration(userList, mockIo);
		
		InOrder order = inOrder(mockIo);
	      order.verify(mockIo).writeln("Login is invalid!");
	}
	
	@Test
	public void registrationPageTestNotConfirmedPassword() {
		when(mockIo.readConsole()).thenReturn("a").thenReturn("111").thenReturn("222");
		
		registrationPage.registration(userList, mockIo);
		
		InOrder order = inOrder(mockIo);
	      order.verify(mockIo).writeln("Password is invalid!");
	}
	
	@Test
	public void registrationPageTestInvalidEmail() {
		when(mockIo.readConsole()).thenReturn("a").thenReturn("a").thenReturn("a").thenReturn("a@.ua");
		
		registrationPage.registration(userList, mockIo);
		
		InOrder order = inOrder(mockIo);
	      order.verify(mockIo).writeln("Email is invalid!");
	}
	
	@Test
	public void registrationPageTestRegistrationFine() {
		when(mockIo.readConsole()).thenReturn("a").thenReturn("a").thenReturn("a").thenReturn("a@a.ua");
		
		registrationPage.registration(userList, mockIo);
		
		InOrder order = inOrder(mockIo);
	      order.verify(mockIo).writeln("You are registered");
	      order.verify(mockIo).writeln("");
	}
	

	@Test
	public void projectPageTestShowMusic() {
		
		when(mockIo.readConsole()).thenReturn("1").thenReturn("0");
		
		new ProjectPage().showTotalProject(projects, mockIo, musicCategory, new ListUtilits());
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockIo, times(37)).writeln(captor.capture());
        assertEquals(
                "[Progect name:		New Song, "
                + "Description:		description of new song, "
                + "Needed amount:		100, "
                + "Available amount:	10, "
                + "Remaining days:		100, "
                + "------------------------------------------, "
                + "Progect name:		Old song, "
                + "Description:		description of old song, "
                + "Needed amount:		1100, "
                + "Available amount:	110, "
                + "Remaining days:		1100, "
                + "------------------------------------------, "
                + "Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	New Song, "
                + "2	-	Old song, "
                + "You've chosen New Song, "
                + "Progect name:		New Song, "
                + "Description:		description of new song, "
                + "Needed amount:		100, "
                + "Available amount:	10, "
                + "Remaining days:		100, "
                + "History:		hystory of new song, "
                + "Video:		video about new song, "
                + "Q&A:		question about new song, "
                + "------------------------------------------, "
                + "Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	Invest in project, "
                + "2	-	Ask a question, "
                + "Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	New Song, "
                + "2	-	Old song]"
                , captor.getAllValues().toString());
	}
	
	@Test
	public void projectPageTestInvest() {
		
		when(mockIo.readConsole()).thenReturn("1").thenReturn("1").thenReturn("0");
		
		new ProjectPage().showTotalProject(projects, mockIo, musicCategory, new ListUtilits());
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockIo, times(49)).writeln(captor.capture());
        assertEquals(
                "[Progect name:		New Song, "
                + "Description:		description of new song, "
                + "Needed amount:		100, "
                + "Available amount:	10, "
                + "Remaining days:		100, "
                + "------------------------------------------, "
                + "Progect name:		Old song, "
                + "Description:		description of old song, "
                + "Needed amount:		1100, "
                + "Available amount:	110, "
                + "Remaining days:		1100, "
                + "------------------------------------------, "
                + "Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	New Song, "
                + "2	-	Old song, "
                + "You've chosen New Song, "
                + "Progect name:		New Song, "
                + "Description:		description of new song, "
                + "Needed amount:		100, "
                + "Available amount:	10, "
                + "Remaining days:		100, "
                + "History:		hystory of new song, "
                + "Video:		video about new song, "
                + "Q&A:		question about new song, "
                + "------------------------------------------, "
                + "Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	Invest in project, "
                + "2	-	Ask a question, "
                + "Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	ONE, "
                + "2	-	TWO, "
                + "3	-	FIVE, "
                + "4	-	ANY_AMOUNT, "
                + "Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	Invest in project, "
                + "2	-	Ask a question, "
                + "Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	New Song, "
                + "2	-	Old song]"
                , captor.getAllValues().toString());
	}
	
	@Test
	public void projectPageTestAskQuestion() {
		
		when(mockIo.readConsole()).thenReturn("1").thenReturn("2").thenReturn("0");
		
		new ProjectPage().showTotalProject(projects, mockIo, musicCategory, new ListUtilits());
		
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockIo, times(43)).writeln(captor.capture());
        assertEquals(
                "[Progect name:		New Song, "
                + "Description:		description of new song, "
                + "Needed amount:		100, "
                + "Available amount:	10, "
                + "Remaining days:		100, "
                + "------------------------------------------, "
                + "Progect name:		Old song, "
                + "Description:		description of old song, "
                + "Needed amount:		1100, "
                + "Available amount:	110, "
                + "Remaining days:		1100, "
                + "------------------------------------------, "
                + "Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	New Song, "
                + "2	-	Old song, "
                + "You've chosen New Song, "
                + "Progect name:		New Song, "
                + "Description:		description of new song, "
                + "Needed amount:		100, "
                + "Available amount:	10, "
                + "Remaining days:		100, "
                + "History:		hystory of new song, "
                + "Video:		video about new song, "
                + "Q&A:		question about new song, "
                + "------------------------------------------, "
                + "Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	Invest in project, "
                + "2	-	Ask a question, , "
                + "Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	Invest in project, "
                + "2	-	Ask a question, "
                + "Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	New Song, "
                + "2	-	Old song]"
                , captor.getAllValues().toString());
	}
	
	@Test
	public void createProjectPageTestEquals() {
		
		Project projectOne = new Project("Name", "Description", 100, 0 , 25);
		projectOne.setCategory(categoryInit.getCategories().get(1));
		
		when(mockIo.readConsole()).thenReturn("1").thenReturn("Name")
		.thenReturn("2").thenReturn("Description")
		.thenReturn("3").thenReturn("100")
		.thenReturn("4").thenReturn("25")
		.thenReturn("5").thenReturn("2").thenReturn("0");
		
		Project projectTwo = new CreatingProjectPage()
		.createProject(mockIo, categoryInit.getCategories(), new ListUtilits());
		
		assertEquals(projectOne.getName(), projectTwo.getName());
		
		assertEquals(projectOne.getDescription(), projectTwo.getDescription());
		
		assertEquals(projectOne.getAllAmount(), projectTwo.getAllAmount());
		
		assertEquals(projectOne.getDaysRemain(), projectTwo.getDaysRemain());
		
		assertEquals(projectOne.getCategory(), projectTwo.getCategory());
		
		
	}
	
	@Test
	public void createProjectPageTestNotEquals() {
		
		Project projectNew = new Project("Name", "Description", 100, 0 , 25);
		projectNew.setCategory(categoryInit.getCategories().get(1));
		
		when(mockIo.readConsole()).thenReturn("1").thenReturn("Name")
		.thenReturn("2").thenReturn("Description")
		.thenReturn("3").thenReturn("100")
		.thenReturn("4").thenReturn("25")
		.thenReturn("5").thenReturn("").thenReturn("0");
		
		assertNotEquals(projectNew, new CreatingProjectPage()
		.createProject(mockIo, categoryInit.getCategories(), new ListUtilits()));
	}
	
	@Test
	public void createProjectPageTestWrongAmountMoney() {
		
		Project projectNew = new Project("Name", "Description", 100, 0 , 25);
		projectNew.setCategory(categoryInit.getCategories().get(1));
		
		when(mockIo.readConsole()).thenReturn("1").thenReturn("Name")
		.thenReturn("2").thenReturn("Description")
		.thenReturn("3").thenReturn("-1").thenReturn("0");
		
		new CreatingProjectPage().createProject(mockIo, categoryInit.getCategories(), new ListUtilits());
		
		InOrder order = inOrder(mockIo);
	    order.verify(mockIo).writeln("Wrong entering!");
	}
	
	@Test
	public void createProjectPageTestWrongAmountDays() {
		
		Project projectNew = new Project("Name", "Description", 100, 0 , 25);
		projectNew.setCategory(categoryInit.getCategories().get(1));
		
		when(mockIo.readConsole()).thenReturn("1").thenReturn("Name")
		.thenReturn("2").thenReturn("Description")
		.thenReturn("3").thenReturn("10")
		.thenReturn("4").thenReturn("-12").thenReturn("0");
		
		new CreatingProjectPage().createProject(mockIo, categoryInit.getCategories(), new ListUtilits());
		
		InOrder order = inOrder(mockIo);
	    order.verify(mockIo).writeln("Wrong entering!");
	}
	
	@Ignore
	@Test(expected = NumberFormatException.class)
	public void createProjectPageTestException() throws NumberFormatException{
		
		Project projectNew = new Project("Name", "Description", 100, 0 , 25);
		projectNew.setCategory(categoryInit.getCategories().get(1));
		
		when(mockIo.readConsole()).thenReturn("1").thenReturn("Name")
		.thenReturn("2").thenReturn("Description")
		.thenReturn("3").thenReturn("10")
		.thenReturn("4").thenReturn("non").thenReturn("0");
		
		new CreatingProjectPage().createProject(mockIo, categoryInit.getCategories(), new ListUtilits());
	}
	
	
	@Test
	public void askQuestionPageTestNo() {
		
		when(mockIo.readConsole()).thenReturn("n").thenReturn("0");
		
		new AskingQuestionPage().askQuestion(newSongProject, mockIo);
		
		InOrder order = inOrder(mockIo);
	    order.verify(mockIo).write("Do you want to ask a question? (y/n): ");
	    order.verify(mockIo).writeln("");
	}
	
	@Test
	public void askQuestionPageTestYes() {
		
		when(mockIo.readConsole()).thenReturn("y").thenReturn("Question???").thenReturn("0");
		
		new AskingQuestionPage().askQuestion(newSongProject, mockIo);
		
		InOrder order = inOrder(mockIo);
	    order.verify(mockIo).write("Do you want to ask a question? (y/n): ");
	    order.verify(mockIo).writeln("");
	    order.verify(mockIo).write("Enter your question: ");
	    
	}
	
	@Test
	public void enteringPageTestEnterRegistered() {
		
		when(mockIo.readConsole()).thenReturn("1").thenReturn("alex").thenReturn("111").thenReturn("0");
		new EnteringPage().enter(userList, categoryInit.getCategories(), projects, mockIo, new ListUtilits());
	    
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockIo, times(20)).writeln(captor.capture());
        assertEquals(
                "[Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	Enter, "
                + "2	-	Registration, "
                + "You've chosen Enter, , "
                + "Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	Enter name, "
                + "2	-	Enter description, "
                + "3	-	Enter amoun of money, "
                + "4	-	Enter amount of days, "
                + "5	-	Enter category, "
                + "Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	Enter, "
                + "2	-	Registration]"
                , captor.getAllValues().toString());
	}
	
	@Test
	public void enteringPageTestEnterNotRegistered1() {
		
		when(mockIo.readConsole()).thenReturn("1").thenReturn("").thenReturn("111").thenReturn("0");
		new EnteringPage().enter(userList, categoryInit.getCategories(), projects, mockIo, new ListUtilits());
	    
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockIo, times(14)).writeln(captor.capture());
        assertEquals(
                "[Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	Enter, "
                + "2	-	Registration, "
                + "You've chosen Enter, , "
                + "You are not registered!, , "
                + "Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	Enter, "
                + "2	-	Registration]"
                , captor.getAllValues().toString());
	}
	
	@Test
	public void enteringPageTestEnterNotRegistered2() {
		
		when(mockIo.readConsole()).thenReturn("1").thenReturn("alex").thenReturn("222").thenReturn("0");
		new EnteringPage().enter(userList, categoryInit.getCategories(), projects, mockIo, new ListUtilits());
	    
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockIo, times(14)).writeln(captor.capture());
        assertEquals(
                "[Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	Enter, "
                + "2	-	Registration, "
                + "You've chosen Enter, , "
                + "You are not registered!, , "
                + "Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	Enter, "
                + "2	-	Registration]"
                , captor.getAllValues().toString());
	}
	
	@Test
	public void enteringPageTestRegistretionNull() {
		
		when(mockIo.readConsole()).thenReturn("2").thenReturn("0");
		new EnteringPage().enter(userList, categoryInit.getCategories(), projects, mockIo, new ListUtilits());
	    
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockIo, times(8)).writeln(captor.capture());
        assertEquals(
                "[Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	Enter, "
                + "2	-	Registration, "
                + "You've chosen Registration, "
                + "Email is invalid!, ]"
                , captor.getAllValues().toString());
	}
	
	@Test
	public void enteringPageTestRegistretionNotNull() {
		
		when(mockIo.readConsole()).thenReturn("2").thenReturn("q").thenReturn("q").thenReturn("q").thenReturn("q@q.ua").thenReturn("0");
		new EnteringPage().enter(userList, categoryInit.getCategories(), projects, mockIo, new ListUtilits());
	    
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockIo, times(22)).writeln(captor.capture());
        assertEquals(
                "[Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	Enter, "
                + "2	-	Registration, "
                + "You've chosen Registration, "
                + "You are registered, , "
                + "Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	Enter name, "
                + "2	-	Enter description, "
                + "3	-	Enter amoun of money, "
                + "4	-	Enter amount of days, "
                + "5	-	Enter category, , "
                + "Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	Enter, "
                + "2	-	Registration]"
                , captor.getAllValues().toString());
	}
	
	@Test
	public void investProjectPageTestOneYes() {
		
		when(mockIo.readConsole()).thenReturn("alex").thenReturn("111 000")
		.thenReturn("1").thenReturn("y").thenReturn("0");
		new InvestitionProjectPage().investInProject(newSongProject, mockIo, new ListUtilits());
	    
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockIo, times(17)).writeln(captor.capture());
        assertEquals(
                "[Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	ONE, "
                + "2	-	TWO, "
                + "3	-	FIVE, "
                + "4	-	ANY_AMOUNT, "
                + "One hundreds of dollars, "
                + "Your investition has added!, , "
                + "Choose one of the items bellow, , "
                + "0	-	Exit, 1	-	ONE, 2	-	TWO, 3	-	FIVE, 4	-	ANY_AMOUNT]"
                , captor.getAllValues().toString());
	}
	
	@Test
	public void investProjectPageTestTwoYes() {
		
		when(mockIo.readConsole()).thenReturn("alex").thenReturn("111 000")
		.thenReturn("2").thenReturn("y").thenReturn("0");
		new InvestitionProjectPage().investInProject(newSongProject, mockIo, new ListUtilits());
	    
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockIo, times(16)).writeln(captor.capture());
        assertEquals(
                "[Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	ONE, "
                + "2	-	TWO, "
                + "3	-	FIVE, "
                + "4	-	ANY_AMOUNT, "
                + "Your investition has added!, , "
                + "Choose one of the items bellow, , "
                + "0	-	Exit, 1	-	ONE, 2	-	TWO, 3	-	FIVE, 4	-	ANY_AMOUNT]"
                , captor.getAllValues().toString());
	}
	
	@Test
	public void investProjectPageTestFiveYes() {
		
		when(mockIo.readConsole()).thenReturn("alex").thenReturn("111 000")
		.thenReturn("3").thenReturn("y").thenReturn("0");
		new InvestitionProjectPage().investInProject(newSongProject, mockIo, new ListUtilits());
	    
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockIo, times(16)).writeln(captor.capture());
        assertEquals(
                "[Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	ONE, "
                + "2	-	TWO, "
                + "3	-	FIVE, "
                + "4	-	ANY_AMOUNT, "
                + "Your investition has added!, , "
                + "Choose one of the items bellow, , "
                + "0	-	Exit, 1	-	ONE, 2	-	TWO, 3	-	FIVE, 4	-	ANY_AMOUNT]"
                , captor.getAllValues().toString());
	}
	
	@Test
	public void investProjectPageTestAnyAmountWrongEntering() {
		
		when(mockIo.readConsole()).thenReturn("alex").thenReturn("111 000")
		.thenReturn("4").thenReturn("one").thenReturn("0");
		new InvestitionProjectPage().investInProject(newSongProject, mockIo, new ListUtilits());
	    
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockIo, times(16)).writeln(captor.capture());
        assertEquals(
                "[Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	ONE, "
                + "2	-	TWO, "
                + "3	-	FIVE, "
                + "4	-	ANY_AMOUNT, "
                + "Wrong entering!, , "
                + "Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	ONE, 2	-	TWO, 3	-	FIVE, 4	-	ANY_AMOUNT]"
                , captor.getAllValues().toString());
	}
	
	@Test
	public void investProjectPageTestAnyAmountYes() {
		
		when(mockIo.readConsole()).thenReturn("alex").thenReturn("111 000")
		.thenReturn("4").thenReturn("123").thenReturn("y").thenReturn("0");
		new InvestitionProjectPage().investInProject(newSongProject, mockIo, new ListUtilits());
	    
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockIo, times(16)).writeln(captor.capture());
        assertEquals(
                "[Choose one of the items bellow, , "
                + "0	-	Exit, 1	-	ONE, 2	-	TWO, 3	-	FIVE, "
                + "4	-	ANY_AMOUNT, Your investition has added!, , "
                + "Choose one of the items bellow, , "
                + "0	-	Exit, 1	-	ONE, 2	-	TWO, 3	-	FIVE, 4	-	ANY_AMOUNT]"
                , captor.getAllValues().toString());
	}
	
	@Test
	public void consoleIOImplTest() {
		InputStream in = new ByteArrayInputStream("testString".getBytes());
		System.setIn(in);

		assertEquals("testString", new ConsoleIOImpl().readConsole());
		
	}
	
}
