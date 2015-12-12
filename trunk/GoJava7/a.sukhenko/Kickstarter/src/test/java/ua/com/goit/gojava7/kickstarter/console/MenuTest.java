package ua.com.goit.gojava7.kickstarter.console;

import static org.junit.Assert.*;

import java.io.PrintStream;

import org.junit.Before;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ua.com.goit.gojava7.kickstarter.config.DataSource;
import ua.com.goit.gojava7.kickstarter.dao.DaoFactory;
import ua.com.goit.gojava7.kickstarter.dao.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.dao.storage.ProjectStorage;
import ua.com.goit.gojava7.kickstarter.domain.User;
@RunWith(MockitoJUnitRunner.class)
public class MenuTest {
	
	@Mock
	private PrintStream printSteam;
	User u = new User();
	ProjectStorage projectManager;
	DaoFactory daoFactory = new DaoFactory(DataSource.MEMORY);
	CategoryStorage categoryStorage;
	Menu menu = new Menu(u, projectManager, categoryStorage);
	
	@Before
	public void setUp(){
		projectManager = daoFactory.getProjectStorage();
		categoryStorage = daoFactory.getCategoryStorage();
	}
	@Test
	public void testMenu() {
		assertNotNull(menu);
	}

	@Test
	public void testGetCategoryStorage() {
		assertThat(menu.getCategoryStorage(),is(categoryStorage));
	}

	@Test
	public void testGetUser() {
		assertThat(menu.getUser(),is(u));
	}

	@Test
	public void testSetUser() {
		User user2 = new User();
		menu.setUser(user2);
		assertThat(menu.getUser(),is(user2));
	}
	
	
	@Test
	public void testShowMenu() {
		menu.showMenu();
	}

	@Test
	public void testGetQuestion() {
		fail("Not yet implemented");
	}

	@Test
	public void testAskQuestion() {
		fail("Not yet implemented");
	}

	@Test
	public void testEnterAmount() {
		fail("Not yet implemented");
	}

	@Test
	public void testDonateMoney() {
		fail("Not yet implemented");
	}

	@Test
	public void testDonateToProject() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsPaymentOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testShowFullProjectInfo() {
		fail("Not yet implemented");
	}

	@Test
	public void testShowDonateInfo() {
		fail("Not yet implemented");
	}

	@Test
	public void testChooseCategory() {
		fail("Not yet implemented");
	}

	@Test
	public void testChooseProject() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetProjectManager() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetProjectManager() {
		fail("Not yet implemented");
	}

}
