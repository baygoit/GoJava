package ua.nenya.main;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import ua.nenya.dao.memory.CategoryDaoMemoryImpl;
import ua.nenya.dao.memory.UserDaoMemoryImpl;
import ua.nenya.main.Kickstarter;
import ua.nenya.project.Category;
import ua.nenya.project.Project;
import ua.nenya.project.User;
import ua.nenya.util.IO;

public class KickstarterTest {

	private IO mockIo;
	private Category musicCategory;
	private CategoryDaoMemoryImpl categoryInit;
	private UserDaoMemoryImpl users;
	private Project newSongProject;
	private List<Category> list = new ArrayList<>();
	private List<User> userList = new ArrayList<>();
	@Before
	public void init() {
		mockIo = mock(IO.class);
		
		users = new UserDaoMemoryImpl();
		User userAlex = new User("alex", "111", "a@a.ua");
		users.getUsers().add(userAlex);
		userList = users.getUsers();

		
		newSongProject = new Project("New Song", "description of new song", 100, 10, 100);
		newSongProject.setHistory("hystory of new song");
		newSongProject.setVideo("video about new song");
		newSongProject.setQuestionAnswer("question about new song");
		Project oldSongProject = new Project("Old song", "description of old song", 1100, 110, 1100);
		Project filmProject = new Project("Film", "description of film", 200, 20, 200);
		
		categoryInit = new CategoryDaoMemoryImpl();
		musicCategory = new Category("Music");
		musicCategory.getProjects().add(newSongProject);
		musicCategory.getProjects().add(oldSongProject);
		
		Category filmsCategory = new Category("Films");
		filmsCategory.getProjects().add(filmProject);
		
		list.add(musicCategory);
		list.add(filmsCategory);
		
		
		
		categoryInit.getCategories().add(musicCategory);
		categoryInit.getCategories().add(filmsCategory);
	}

	@Test
	public void kikstarterTestEnter0() {
		when(mockIo.readConsole()).thenReturn("0");
		
		new Kickstarter(userList, categoryInit.getCategories(), mockIo).run();
		
		InOrder order = inOrder(mockIo);
	      order.verify(mockIo).writeln("Choose one of the items bellow");
	      order.verify(mockIo).writeln("1	-	Go to categories");
	      order.verify(mockIo).writeln("2	-	Create new project");

	}
	

	@Test
	public void kikstarterTestEnter10() {
		when(mockIo.readConsole()).thenReturn("1").thenReturn("0");
		
		new Kickstarter(userList, categoryInit.getCategories(), mockIo).run();
		
		InOrder order = inOrder(mockIo);
	      order.verify(mockIo).writeln("Choose one of the items bellow");
	      order.verify(mockIo).writeln("1	-	Go to categories");
	      order.verify(mockIo).writeln("2	-	Create new project");
	      order.verify(mockIo).writeln("You've chosen Go to categories");
	      order.verify(mockIo).writeln("Choose one of the items bellow");
	      order.verify(mockIo).writeln("0	-	Exit");
	      order.verify(mockIo).writeln("1	-	Music");
	      order.verify(mockIo).writeln("2	-	Films");
		
	}
	
	@Test
	public void kikstarterTestEnter20() {
		when(mockIo.readConsole()).thenReturn("2").thenReturn("0");
		
		new Kickstarter(userList, categoryInit.getCategories(), mockIo).run();
		InOrder order = inOrder(mockIo);
	      order.verify(mockIo).writeln("Choose one of the items bellow");
	      order.verify(mockIo).writeln("1	-	Go to categories");
	      order.verify(mockIo).writeln("2	-	Create new project");
	      order.verify(mockIo).writeln("You've chosen Create new project");
	      order.verify(mockIo).writeln("Choose one of the items bellow");
	      order.verify(mockIo).writeln("0	-	Exit");
	      order.verify(mockIo).writeln("1	-	Enter");
	      order.verify(mockIo).writeln("2	-	Registration");

	}
		
}
