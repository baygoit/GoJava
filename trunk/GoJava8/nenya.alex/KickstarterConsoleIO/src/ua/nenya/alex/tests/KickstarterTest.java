package ua.nenya.alex.tests;


import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ua.nenya.alex.builders.CategoryBuilder;
import ua.nenya.alex.builders.ProjectBuilder;
import ua.nenya.alex.builders.UserBuilder;
import ua.nenya.alex.main.Kickstarter;
import ua.nenya.alex.pages.CreateProjectPage;
import ua.nenya.alex.pages.InvestProjectPage;
import ua.nenya.alex.pages.ProjectPage;
import ua.nenya.alex.pages.RegistrationPage;
import ua.nenya.alex.project.Category;
import ua.nenya.alex.project.Project;
import ua.nenya.alex.project.Quote;
import ua.nenya.alex.users.User;
import ua.nenya.alex.util.ConsoleIOImpl;
import ua.nenya.alex.util.IO;
import ua.nenya.alex.util.ListUtilits;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

public class KickstarterTest {
	private IO io;
	private Category category;
	private Project project;
	private User user;
	private User user1;
	
//	@Before
//	public void init() {
//		io = mock(IO.class);
//		user1 = mock(User.class);
//		
//		
//		UserBuilder userBuilder = new UserBuilder();
//		userBuilder.createAll("Login_Password.txt");
//		user = userBuilder.getUser();
//		
//		CategoryBuilder categoryBuilder = new CategoryBuilder();
//		List<String> list = new ConsoleIOImpl().read("categories.txt");
//		categoryBuilder.createAll(list);
//		category = categoryBuilder.getCategory();
//		
//		ProjectBuilder builder = new ProjectBuilder();
//		builder.add("", "", 0, 0, 0, category.getCategoriesList().get(0));
//		builder.add("A new song", "We want to write a new funny song!",
//				3000, 1000, 7, category.getCategoriesList().get(1));
//		builder.add("A song", "We want to write a new sad song!", 400,
//				10, 7, category.getCategoriesList().get(1));
//		builder.add("Terminator 55",
//				"new blockbuster!", 200000, 1000,
//				365, category.getCategoriesList().get(2));
//		builder.add("Wild west", "It'll be a western!",
//				10000, 3000, 150, category.getCategoriesList().get(2));
//		
//		project = builder.getProject();
//	}
//
//	@Test
//	public void quoteTest() {
//		assertEquals("Healthy curiosity is a great key in innovation.", new Quote().showQuote());
//	}
//
//	@Test
//	public void registrationTest1() {
//		when(io.readConsole()).thenReturn("alex").thenReturn("111").thenReturn("111").thenReturn("alex@a.ua");
//		assertEquals(new User("alex","111","alex@a.ua"), new RegistrationPage().registration(user1, io));
//	}
//	
//	@Test
//	public void registrationTest2() {
//		when(io.readConsole()).thenReturn("");
//		assertNull( new RegistrationPage().registration(user, io));
//	}
//	
//	@Test
//	public void registrationTest3() {
//		when(io.readConsole()).thenReturn("alex").thenReturn("222").thenReturn("111");
//		assertNull( new RegistrationPage().registration(user, io));
//	}
//	
//	@Test
//	public void registrationTest4() {
//		when(io.readConsole()).thenReturn("alex").thenReturn("111").thenReturn("111").thenReturn("alex@a");
//		assertNull( new RegistrationPage().registration(user, io));
//	}
//	
//	@Test
//	public void registrationTest5() {
//		when(io.readConsole()).thenReturn("a");
//		assertNull( new RegistrationPage().registration(user, io));
//	}
//	
//	@Test
//	public void registeredUserTest0() {
//		when(io.readConsole()).thenReturn("").thenReturn("111").thenReturn("0");
//		assertFalse(new RegisteredUser().enter(io, user, category, project,
//				new ListUtilits()));
//	}
//	
//	@Test
//	public void registeredUserTest1() {
//		when(io.readConsole()).thenReturn("bob").thenReturn("bob").thenReturn("0");
//		assertFalse( new RegisteredUser().enter(io, user, category, project,
//				new ListUtilits()));
//	}
//	
//	@Test
//	public void registeredUserTest2() {
//		when(io.readConsole()).thenReturn("admin").thenReturn("admin").thenReturn("0");
//		assertTrue( new RegisteredUser().enter(io, user, category, project,
//				new ListUtilits()));
//	}
//	
//	@Test
//	public void registeredUserTest3() {
//		when(io.readConsole()).thenReturn("a").thenReturn("a").thenReturn("0");
//		assertTrue(new RegisteredUser().enter(io, user, category, project,
//				new ListUtilits()));
//	}
//	
//	@Test
//	public void enterLikeAdminTest0() {
//		when(io.read("adminFunctions.txt")).thenReturn(Arrays.asList("add category",
//				"show all categories", "show users"));
//		
//		when(io.readConsole()).thenReturn("1").thenReturn("New Art").thenReturn("0");
//		
//		assertTrue( new Admin().enterLikeAdmin(category, io, user,
//				new ListUtilits()));
//	}
//	
//	@Test
//	public void enterLikeAdminTest1() {
//		when(io.read("adminFunctions.txt")).thenReturn(Arrays.asList("add category",
//				"show all categories", "show users"));
//		
//		when(io.readConsole()).thenReturn("1").thenReturn("Art").thenReturn("0");
//		
//		assertTrue( new Admin().enterLikeAdmin(category, io, user,
//				new ListUtilits()));
//	}
//	
//	@Test
//	public void enterLikeAdminTest2() {
//		when(io.read("adminFunctions.txt")).thenReturn(Arrays.asList("add category",
//				"show all categories", "show users"));
//		
//		when(io.readConsole()).thenReturn("2").thenReturn("0");
//		
//		assertTrue( new Admin().enterLikeAdmin(category, io, user,
//				new ListUtilits()));
//	}
//	
//	@Test
//	public void enterLikeAdminTest3() {
//		when(io.read("adminFunctions.txt")).thenReturn(Arrays.asList("add category",
//				"show all categories", "show users"));
//		when(io.readConsole()).thenReturn("3").thenReturn("0");
//		
//		assertTrue( new Admin().enterLikeAdmin(category, io, user,
//				new ListUtilits()));
//	}
//	
//	@Test
//	public void runTest00() {
//		when(io.readConsole()).thenReturn("0");
//		assertFalse( new Kickstarter(category, project, io, user).run());
//	}
//	
//	@Test
//	public void runTest0() {
//		when(io.readConsole()).thenReturn("-1").thenReturn("0");
//		assertFalse( new Kickstarter(category, project, io, user).run());
//	}
//	
//	@Test
//	public void runTest1() {
//		when(io.readConsole()).thenReturn("1").thenReturn("0");
//		assertTrue( new Kickstarter(category, project, io, user).run());
//	}
//	
//	@Test
//	public void runTest2() {
//		when(io.readConsole()).thenReturn("2").thenReturn("0");
//		assertTrue( new Kickstarter(category, project, io, user).run());
//	}
//	
//	@Test
//	public void runTest3() {
//		when(io.readConsole()).thenReturn("3").thenReturn("0");
//		assertTrue( new Kickstarter(category, project, io, user).run());
//	}
//	
//	@Test
//	public void runTest4() {
//		when(io.readConsole()).thenReturn("3").thenReturn("alex")
//		.thenReturn("111").thenReturn("111").thenReturn("alex@a.ua")
//		.thenReturn("0");
//		assertTrue( new Kickstarter(category, project, io, user).run());
//	}
//	
//	@Test
//	public void userEnterTest1() {
//		when(io.readConsole()).thenReturn("2").thenReturn("0").thenReturn("0");
//		assertTrue( new User().enter(user, category, project, io, "a", "a",
//				new ListUtilits()));
//	}
//
//	@Test
//	public void userEnterTest2() {
//		when(io.readConsole()).thenReturn("1").thenReturn("n").thenReturn("0");
//		assertTrue( new User().enter(user, category, project, io, "a", "a",
//				new ListUtilits()));
//	}
//	
//	@Test
//	public void userEnterTest3() {
//		when(io.readConsole()).thenReturn("1").thenReturn("y").thenReturn("0");
//		assertTrue( new User().enter(user, category, project, io, "a", "a",
//				new ListUtilits()));
//	}
//	
//	@Test
//	public void userEnterTest4() {
//		when(io.readConsole()).thenReturn("1").thenReturn("y").thenReturn("0");
//		assertTrue( new User().enter(user, category, project, io, "aa", "22",
//				new ListUtilits()));
//	}
//	
//	@Test
//	public void userEnterTest5() {
//		when(io.readConsole()).thenReturn("1").thenReturn("n").thenReturn("0");
//		assertTrue( new User().enter(user, category, project, io, "aa", "22",
//				new ListUtilits()));
//	}
//	
//	@Test
//	public void userEnterTest6() {
//		when(io.readConsole()).thenReturn("1").thenReturn("y")
//		.thenReturn("bb").thenReturn("bb").thenReturn("bb").thenReturn("bb@b.ua")
//		.thenReturn("0").thenReturn("0");
//		assertTrue( new User().enter(user, category, project, io, "aa", "22",
//				new ListUtilits()));
//	}
//	
//	@Test
//	public void projectPageTest1() {
//		when(io.readConsole()).thenReturn("0");
//		assertFalse(new ProjectPage().showTotalProject(project, io, category, new ListUtilits()));
//	}
//	
//	@Test
//	public void projectPageTest2() {
//		when(io.readConsole()).thenReturn("2").thenReturn("0");
//		assertTrue( new ProjectPage().showTotalProject(project, io,
//				category.getCategoriesList().get(2), new ListUtilits()));
//	}
//	
//	@Test
//	public void projectPageTest3() {
//		when(io.readConsole()).thenReturn("2").thenReturn("2").thenReturn("0");
//		assertTrue( new ProjectPage().showTotalProject(project, io,
//				category.getCategoriesList().get(2), new ListUtilits()));
//	}
//	
//	@Test
//	public void projectPageTest4() {
//		when(io.readConsole()).thenReturn("2").thenReturn("1").thenReturn("0");
//		assertTrue( new ProjectPage().showTotalProject(project, io,
//				category.getCategoriesList().get(2), new ListUtilits()));
//	}
//	
//	@Test
//	public void projectPageTest5() {
//		when(io.readConsole()).thenReturn("2").thenReturn("2").thenReturn("y").thenReturn("question").thenReturn("0");
//		assertTrue( new ProjectPage().showTotalProject(project, io,
//				category.getCategoriesList().get(2), new ListUtilits()));
//	}
//	
//	@Test
//	public void investProjectPageTest1() {
//		when(io.readConsole()).thenReturn("A").thenReturn("A").thenReturn("1").thenReturn("y").thenReturn("0");
//		assertTrue( new InvestProjectPage().investInProject(project.getProjects(category.getCategoriesList().get(2)).get(1),
//				io, new ListUtilits()));
//	}
//	
//	@Test
//	public void investProjectPageTest2() {
//		when(io.readConsole()).thenReturn("A").thenReturn("A").thenReturn("1").thenReturn("n").thenReturn("0");
//		assertTrue( new InvestProjectPage().investInProject(project.getProjects(category.getCategoriesList().get(2)).get(1),
//				io, new ListUtilits()));
//	}
//	
//
//	@Test
//	public void investProjectPageTest3() {
//		when(io.readConsole()).thenReturn("A").thenReturn("A").thenReturn("2").thenReturn("y").thenReturn("0");
//		assertTrue( new InvestProjectPage().investInProject(project.getProjects(category.getCategoriesList().get(2)).get(1),
//				io, new ListUtilits()));
//	}
//	
//	@Test
//	public void investProjectPageTest4() {
//		when(io.readConsole()).thenReturn("A").thenReturn("A").thenReturn("2").thenReturn("n").thenReturn("0");
//		assertTrue( new InvestProjectPage().investInProject(project.getProjects(category.getCategoriesList().get(2)).get(1),
//				io, new ListUtilits()));
//	}
//	@Test
//	public void investProjectPageTest5() {
//		when(io.readConsole()).thenReturn("A").thenReturn("A").thenReturn("3").thenReturn("y").thenReturn("0");
//		assertTrue( new InvestProjectPage().investInProject(project.getProjects(category.getCategoriesList().get(2)).get(1),
//				io, new ListUtilits()));
//	}
//	
//	@Test
//	public void investProjectPageTest6() {
//		when(io.readConsole()).thenReturn("A").thenReturn("A").thenReturn("3").thenReturn("n").thenReturn("0");
//		assertTrue( new InvestProjectPage().investInProject(project.getProjects(category.getCategoriesList().get(2)).get(1),
//				io, new ListUtilits()));
//	}
//	
//	@Test
//	public void investProjectPageTest7() {
//		when(io.readConsole()).thenReturn("A").thenReturn("A").thenReturn("4").thenReturn("y").thenReturn("0");
//		assertTrue( new InvestProjectPage().investInProject(project.getProjects(category.getCategoriesList().get(2)).get(1),
//				io, new ListUtilits()));
//	}
//	
//	@Test
//	public void investProjectPageTest8() {
//		when(io.readConsole()).thenReturn("A").thenReturn("A").thenReturn("4").thenReturn("n").thenReturn("0");
//		assertTrue( new InvestProjectPage().investInProject(project.getProjects(category.getCategoriesList().get(2)).get(1),
//				io, new ListUtilits()));
//	}
//	
//	@Test
//	public void investProjectPageTest9() {
//		when(io.readConsole()).thenReturn("A").thenReturn("A").thenReturn("5").thenReturn("100").thenReturn("y").thenReturn("0");
//		assertTrue( new InvestProjectPage().investInProject(project.getProjects(category.getCategoriesList().get(2)).get(1),
//				io, new ListUtilits()));
//	}
//	
//	@Test
//	public void investProjectPageTest10() {
//		when(io.readConsole()).thenReturn("A").thenReturn("A").thenReturn("5").thenReturn("100").thenReturn("n").thenReturn("0");
//		assertTrue( new InvestProjectPage().investInProject(project.getProjects(category.getCategoriesList().get(2)).get(1),
//				io, new ListUtilits()));
//	}
//	
//	@Test
//	public void investProjectPageTest11() {
//		when(io.readConsole()).thenReturn("A").thenReturn("A").thenReturn("5").thenReturn("-100").thenReturn("n").thenReturn("0");
//		assertTrue( new InvestProjectPage().investInProject(project.getProjects(category.getCategoriesList().get(2)).get(1),
//				io, new ListUtilits()));
//	}
//	@Test
//	public void investProjectPageTest12() {
//		when(io.readConsole()).thenReturn("A").thenReturn("A").thenReturn("5").thenReturn("ert").thenReturn("n").thenReturn("0");
//		assertTrue( new InvestProjectPage().investInProject(project.getProjects(category.getCategoriesList().get(2)).get(1),
//				io, new ListUtilits()));
//	}
//	@Test
//	public void createProjectPageTest1() {
//		Project projectNew = new Project("Name", "Description", 100, 0 , 25);
//		projectNew.setCategory(category.getCategoriesList().get(1));
//		when(io.readConsole()).thenReturn("1").thenReturn("Name")
//		.thenReturn("2").thenReturn("Description")
//		.thenReturn("3").thenReturn("100")
//		.thenReturn("4").thenReturn("25")
//		.thenReturn("5").thenReturn("1").thenReturn("0");
//		assertEquals(projectNew, new CreateProjectPage().createProject(io, category.getCategoriesList(), new ListUtilits()));
//	}
//	@Test
//	public void getLoginTest() {
//		
//		assertEquals("admin", new Admin().getLogin());
//	}
//	@Test
//	public void getPasswordTest() {
//		
//		assertEquals("admin", new Admin().getPassword());
//	}
}
