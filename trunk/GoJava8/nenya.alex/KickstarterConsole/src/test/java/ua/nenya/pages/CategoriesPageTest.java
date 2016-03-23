package ua.nenya.pages;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import ua.nenya.dao.CategoryDao;
import ua.nenya.dao.memory.CategoryDaoMemoryImpl;
import ua.nenya.main.KickstarterInitilizer;
import ua.nenya.pages.CategoriesPage;
import ua.nenya.project.Category;
import ua.nenya.project.Project;
import ua.nenya.util.IO;
import ua.nenya.util.ListUtilits;

public class CategoriesPageTest {

	private IO mockIo;
	private Category musicCategory;
	private Project newSongProject;
	private KickstarterInitilizer initilizer = new KickstarterInitilizer();
	
	@Before
	public void init() {
		mockIo = mock(IO.class);
		newSongProject = new Project("New Song", "description of new song", 100, 10, 100);
		newSongProject.setHistory("hystory of new song");
		newSongProject.setVideo("video about new song");
		newSongProject.setQuestionAnswer("question about new song");
		Project oldSongProject = new Project("Old song", "description of old song", 1100, 110, 1100);
		
		
		musicCategory = new Category("Music");
		musicCategory.getProjects().add(newSongProject);
		musicCategory.getProjects().add(oldSongProject);
		
		CategoryDao cDao = new CategoryDaoMemoryImpl();
		initilizer.setCategoryDao(cDao);
		initilizer.getCategoryDao().getCategories().add(musicCategory);
	}

	@Test
	public void categoriesPageTest() {
		when(mockIo.readConsole()).thenReturn("1").thenReturn("0");
		
		new CategoriesPage().showAllCategories(initilizer, mockIo, new ListUtilits());
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockIo, times(26)).writeln(captor.capture());
        assertEquals(
                "[Choose one of the items bellow, , 0	-	Exit, 1	-	Music, You've chosen Music, "
                + "Progect name:		New Song, Description:		description of new song, "
                + "Needed amount:		100, Available amount:	10, Remaining days:		100, "
                + "------------------------------------------, Progect name:		Old song, "
                + "Description:		description of old song, Needed amount:		1100, "
                + "Available amount:	110, Remaining days:		1100, "
                + "------------------------------------------, "
                + "Choose one of the items bellow, , 0	-	Exit, 1	-	New Song, 2	-	Old song, "
                + "Choose one of the items bellow, , 0	-	Exit, 1	-	Music]"
                , captor.getAllValues().toString());
	}
}
