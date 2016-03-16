package ua.nenya.pages;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;



import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import ua.nenya.pages.InvestitionProjectPage;
import ua.nenya.project.Project;
import ua.nenya.util.IO;
import ua.nenya.util.ListUtilits;

public class InvestitionProjectPageTest {

	private IO mockIo;
	private Project newSongProject;
	
	
	@Before
	public void init() {
		mockIo = mock(IO.class);
		
		
		newSongProject = new Project("New Song", "description of new song", 100, 10, 100);
		newSongProject.setHistory("hystory of new song");
		newSongProject.setVideo("video about new song");
		newSongProject.setQuestionAnswer("question about new song");
		
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
}
