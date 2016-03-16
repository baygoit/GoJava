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

import ua.nenya.dao.memory.CategoryDaoMemoryImpl;
import ua.nenya.dao.memory.UserDaoMemoryImpl;
import ua.nenya.pages.EnteringPage;
import ua.nenya.project.Category;
import ua.nenya.project.Project;
import ua.nenya.project.User;
import ua.nenya.util.IO;
import ua.nenya.util.ListUtilits;

public class EnteringPageTest {
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
		musicCategory.getProjects().add(oldSongProject);
		
		Category filmsCategory = new Category("Films");
		filmsCategory.getProjects().add(filmProject);
		list.add(musicCategory);
		list.add(filmsCategory);
		
		categoryInit.getCategories().add(musicCategory);
		categoryInit.getCategories().add(filmsCategory);
	}
	
	@Test
	public void enteringPageTestEnterRegistered() {
		
		when(mockIo.readConsole()).thenReturn("1").thenReturn("alex").thenReturn("111").thenReturn("0");
		new EnteringPage().enter(userList, categoryInit.getCategories(), mockIo, new ListUtilits());
	    
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockIo, times(18)).writeln(captor.capture());
        assertEquals(
                "[Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	Enter, "
                + "2	-	Registration, "
                + "You've chosen Enter, , "
                + "Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	Music, "
                + "2	-	Films, "
                + "You've not chosen category!, "
                + "Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	Enter, "
                + "2	-	Registration]"
                , captor.getAllValues().toString());
	}
	
	@Test
	public void enteringPageTestEnterNotRegistered1() {
		
		when(mockIo.readConsole()).thenReturn("1").thenReturn("").thenReturn("111").thenReturn("0");
		new EnteringPage().enter(userList, categoryInit.getCategories(), mockIo, new ListUtilits());
	    
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
		new EnteringPage().enter(userList, categoryInit.getCategories(), mockIo, new ListUtilits());
	    
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
		new EnteringPage().enter(userList, categoryInit.getCategories(), mockIo, new ListUtilits());
	    
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
		new EnteringPage().enter(userList, categoryInit.getCategories(), mockIo, new ListUtilits());
	    
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockIo, times(20)).writeln(captor.capture());
        assertEquals(
                "[Choose one of the items bellow, , "
                + "0	-	Exit, 1	-	Enter, 2	-	Registration, "
                + "You've chosen Registration, You are registered, , "
                + "Choose one of the items bellow, , 0	-	Exit, 1	-	Music, 2	-	Films, "
                + "You've not chosen category!, , Choose one of the items bellow, , "
                + "0	-	Exit, 1	-	Enter, 2	-	Registration]"
                , captor.getAllValues().toString());
	}
}
