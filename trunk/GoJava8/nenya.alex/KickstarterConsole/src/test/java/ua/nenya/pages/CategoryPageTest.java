package ua.nenya.pages;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import ua.nenya.dao.CategoryDao;
import ua.nenya.dao.memory.CategoryDaoMemoryImpl;
import ua.nenya.main.DaoInitilizer;
import ua.nenya.project.Category;
import ua.nenya.util.IO;
import ua.nenya.util.ListUtilits;

public class CategoryPageTest {
	private IO mockIo;
	private DaoInitilizer initilizer;
	private CategoryDao cDao;
	private List <Category> categories = new ArrayList<>(); 
	
	@Before
	public void init() {
		mockIo = mock(IO.class);
		initilizer = mock(DaoInitilizer.class);
		cDao = mock(CategoryDaoMemoryImpl.class);
		Category musicCategory = new Category();
		musicCategory.setName("Music");
		categories.add(musicCategory);
	}

	
	@Test
	public void categoriesPageTestChooseMusic() {
		when(mockIo.readConsole()).thenReturn("1").thenReturn("0");
		when(initilizer.getCategoryDao()).thenReturn(cDao);
		when(cDao.initCategories()).thenReturn(categories);
		
		new CategoryPage().showAllCategories(initilizer, mockIo, new ListUtilits());
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockIo, times(12)).writeln(captor.capture());
        assertEquals(
                "[Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	Music, "
                + "You've chosen Music, "
                + "Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	Music]"
                , captor.getAllValues().toString());
	}

	@Test
	public void categoriesPageTestChooseExit() {
		when(mockIo.readConsole()).thenReturn("0");
		when(initilizer.getCategoryDao()).thenReturn(cDao);
		when(cDao.initCategories()).thenReturn(categories);
		
		new CategoryPage().showAllCategories(initilizer, mockIo, new ListUtilits());
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockIo, times(4)).writeln(captor.capture());
        assertEquals(
                "[Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	Music]"
                , captor.getAllValues().toString());
	}
}
