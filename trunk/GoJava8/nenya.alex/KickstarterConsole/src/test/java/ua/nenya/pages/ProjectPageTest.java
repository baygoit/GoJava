package ua.nenya.pages;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import ua.nenya.dao.memory.CategoryDaoMemoryImpl;
import ua.nenya.pages.ProjectPage;
import ua.nenya.project.Category;
import ua.nenya.project.Project;
import ua.nenya.util.IO;
import ua.nenya.util.ListUtilits;

public class ProjectPageTest {
	private IO mockIo;
	private Category musicCategory;
	private CategoryDaoMemoryImpl categoryInit;
	private Project newSongProject;
	
	@Before
	public void init() {
		mockIo = mock(IO.class);
		newSongProject = new Project("New Song", "description of new song", 100, 10, 100);
		newSongProject.setHistory("hystory of new song");
		newSongProject.setVideo("video about new song");
		newSongProject.setQuestionAnswer("question about new song");
		Project oldSongProject = new Project("Old song", "description of old song", 1100, 110, 1100);
		
		
		categoryInit = new CategoryDaoMemoryImpl();
		musicCategory = new Category("Music");
		musicCategory.getProjects().add(newSongProject);
		musicCategory.getProjects().add(oldSongProject);
		
		categoryInit.getCategories().add(musicCategory);
		
	}
	@Test
	public void projectPageTestShowMusic() {
		when(mockIo.readConsole()).thenReturn("1").thenReturn("0");
		
		new ProjectPage().showTotalProject(mockIo, musicCategory, new ListUtilits());
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
		
		new ProjectPage().showTotalProject(mockIo, musicCategory, new ListUtilits());
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
		
		new ProjectPage().showTotalProject(mockIo, musicCategory, new ListUtilits());
		
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

}
