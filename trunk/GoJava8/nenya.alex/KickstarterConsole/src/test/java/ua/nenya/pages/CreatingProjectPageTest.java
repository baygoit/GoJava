package ua.nenya.pages;

import static org.junit.Assert.*;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;

import ua.nenya.dao.memory.CategoryDaoMemoryImpl;
import ua.nenya.pages.CreatingProjectPage;
import ua.nenya.project.Category;
import ua.nenya.project.Project;
import ua.nenya.util.IO;
import ua.nenya.util.ListUtilits;

public class CreatingProjectPageTest {

	private IO mockIo;
	private Category musicCategory;
	private CategoryDaoMemoryImpl categoryInit;
	
	@Before
	public void init() {
		mockIo = mock(IO.class);
		categoryInit = new CategoryDaoMemoryImpl();
		musicCategory = new Category("Music");
		Category filmsCategory = new Category("Films");
		categoryInit.getCategories().add(musicCategory);
		categoryInit.getCategories().add(filmsCategory);
	}
	
	@Test
	public void creatingProjectPageTestEquals() {
		
		Project projectOne = new Project("Name", "Description", 100, 0 , 25);
		
		when(mockIo.readConsole()).thenReturn("1").thenReturn("1").thenReturn("Name")
		.thenReturn("2").thenReturn("Description")
		.thenReturn("3").thenReturn("100")
		.thenReturn("4").thenReturn("25").thenReturn("0");
		
		new CreatingProjectPage().createProject(mockIo, categoryInit.getCategories(), new ListUtilits());
		
		assertEquals(projectOne.getName(), categoryInit.getCategories().get(0).getProjects().get(0).getName());
		
		assertEquals(projectOne.getDescription(), categoryInit.getCategories().get(0).getProjects().get(0).getDescription());
		
		assertEquals(projectOne.getAllAmount(), categoryInit.getCategories().get(0).getProjects().get(0).getAllAmount());
		
		assertEquals(projectOne.getDaysRemain(), categoryInit.getCategories().get(0).getProjects().get(0).getDaysRemain());
		
		
	}
	
	@Test
	public void creatingProjectPageTestNullCategory() {
		
		when(mockIo.readConsole()).thenReturn("0");
		
		new CreatingProjectPage().createProject(mockIo, categoryInit.getCategories(), new ListUtilits());
		
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockIo, times(6)).writeln(captor.capture());
        assertEquals(
                "[Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	Music, "
                + "2	-	Films, "
                + "You've not chosen category!]"
               , captor.getAllValues().toString());
	}
	
	@Test
	public void creatingProjectPageTestWrongAmountMoney() {
		
		when(mockIo.readConsole()).thenReturn("1").thenReturn("1").thenReturn("Name")
		.thenReturn("2").thenReturn("Description")
		.thenReturn("3").thenReturn("-1").thenReturn("0");
		
		new CreatingProjectPage().createProject(mockIo, categoryInit.getCategories(), new ListUtilits());
		
		InOrder order = inOrder(mockIo);
	    order.verify(mockIo).writeln("Wrong entering!");
	}
	
	@Test
	public void creatingProjectPageTestWrongAmountDays() {
		
		when(mockIo.readConsole()).thenReturn("1").thenReturn("1").thenReturn("Name")
		.thenReturn("2").thenReturn("Description")
		.thenReturn("3").thenReturn("10")
		.thenReturn("4").thenReturn("-12").thenReturn("0");
		
		new CreatingProjectPage().createProject(mockIo, categoryInit.getCategories(), new ListUtilits());
		
		InOrder order = inOrder(mockIo);
	    order.verify(mockIo).writeln("Wrong entering!");
	}

}
