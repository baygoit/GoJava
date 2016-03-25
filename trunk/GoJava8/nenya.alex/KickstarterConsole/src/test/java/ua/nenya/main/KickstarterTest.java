package ua.nenya.main;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import ua.nenya.dao.CategoryDao;
import ua.nenya.dao.memory.CategoryDaoMemoryImpl;
import ua.nenya.main.Kickstarter;
import ua.nenya.project.Category;
import ua.nenya.project.Project;
import ua.nenya.util.IO;

public class KickstarterTest {

	private IO mockIo;
	private DaoInitilizer initilizer = new DaoInitilizer();
	
	@Before
	public void init() {
		mockIo = mock(IO.class);
		Project newSongProject = new Project();
		newSongProject.setName("New Song");
		newSongProject.setDescription("description of new song");
		newSongProject.setNeededAmount(100);
		newSongProject.setAvailableAmount(10);
		newSongProject.setDaysRemain(100);
		newSongProject.setHistory("hystory of new song");
		newSongProject.setVideo("video about new song");
		Project oldSongProject = new Project();
		oldSongProject.setName("Old song");
		oldSongProject.setDescription("description of old song");
		oldSongProject.setNeededAmount(1100);
		oldSongProject.setAvailableAmount(110);
		oldSongProject.setDaysRemain(1100);
		Project filmProject = new Project();
		filmProject.setName("Film");
		filmProject.setDescription("description of film");
		filmProject.setNeededAmount(200);
		filmProject.setAvailableAmount(20);
		filmProject.setDaysRemain(200);
		
		
		Category musicCategory = new Category();
		musicCategory.setName("Music");
		musicCategory.getProjects().add(newSongProject);
		musicCategory.getProjects().add(oldSongProject);
		
		Category filmsCategory = new Category();
		filmsCategory.setName("Films");
		filmsCategory.getProjects().add(filmProject);
		
		CategoryDao cDao = new CategoryDaoMemoryImpl();
		initilizer.setCategoryDao(cDao);
		((CategoryDaoMemoryImpl) initilizer.getCategoryDao()).getCategories().add(musicCategory);
		((CategoryDaoMemoryImpl) initilizer.getCategoryDao()).getCategories().add(filmsCategory);
	}

	@Test
	public void kikstarterTestEnter0() {
		when(mockIo.readConsole()).thenReturn("0");
		initilizer.initDao("memory");
		new Kickstarter(initilizer, mockIo).run();
		
		InOrder order = inOrder(mockIo);
	      order.verify(mockIo).writeln("Choose one of the items bellow");
	      order.verify(mockIo).writeln("0	-	Exit");
	      order.verify(mockIo).writeln("1	-	Music");
	      order.verify(mockIo).writeln("2	-	Films");

	}
	

	@Test
	public void kikstarterTestEnter10() {
		when(mockIo.readConsole()).thenReturn("1").thenReturn("0");
		initilizer.initDao("file");
		initilizer.getCategoryDao().initCategories();
		new Kickstarter(initilizer, mockIo).run();
		
		InOrder order = inOrder(mockIo);
	      order.verify(mockIo).writeln("Choose one of the items bellow");
	      order.verify(mockIo).writeln("0	-	Exit");
	      order.verify(mockIo).writeln("1	-	Music");
	      order.verify(mockIo).writeln("2	-	Films");
	      order.verify(mockIo).writeln("You've chosen Music");
	      order.verify(mockIo).writeln("Choose one of the items bellow");
		
	}
}
