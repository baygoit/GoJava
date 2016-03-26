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
import ua.nenya.pages.ProjectPage;
import ua.nenya.project.Category;
import ua.nenya.project.Project;
import ua.nenya.project.Question;
import ua.nenya.util.IO;
import ua.nenya.util.ListUtilits;

public class ProjectPageTest {
	private IO mockIo;
	private Category musicCategory;
	private DaoInitilizer initilizer;
	private CategoryDao cDao;
	private Project newSongProject;
	private List <Project> projects = new ArrayList<>();
	private List<Question> questions = new ArrayList<>();
	
	@Before
	public void init() {
		mockIo = mock(IO.class);
		initilizer = mock(DaoInitilizer.class);
		cDao = mock(CategoryDaoMemoryImpl.class);
		
		newSongProject = new Project();
		newSongProject.setName("New Song");
		newSongProject.setDescription("description of new song");
		newSongProject.setNeededAmount(100);
		newSongProject.setAvailableAmount(10);
		newSongProject.setDaysRemain(100);
		newSongProject.setHistory("hystory of new song");
		newSongProject.setVideo("video about new song");
		
		Question question = new Question();
		question.setName("Who?");
		questions.add(question);
		
		newSongProject.setQuestions(questions);
		
		Project oldSongProject = new Project();
		oldSongProject.setName("Old song");
		oldSongProject.setDescription("description of old song");
		oldSongProject.setNeededAmount(1100);
		oldSongProject.setAvailableAmount(110);
		oldSongProject.setDaysRemain(1100);
		
		projects.add(newSongProject);
		projects.add(oldSongProject);
		
		musicCategory = new Category();
		musicCategory.setName("Music");
		musicCategory.getProjects().add(newSongProject);
		musicCategory.getProjects().add(oldSongProject);
	
	}
	
	@Test
	public void projectPageTestChoseExit() {
		when(mockIo.readConsole()).thenReturn("0");
		when(initilizer.getCategoryDao()).thenReturn(cDao);
		when(cDao.initProjects(musicCategory)).thenReturn(projects);
		
		
		new ProjectPage().showAllProjectsOfCategory(initilizer, mockIo, musicCategory, new ListUtilits());
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockIo, times(17)).writeln(captor.capture());
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
                + "2	-	Old song]"
                , captor.getAllValues().toString());
	}
	
	@Test
	public void projectPageTestShowMusic() {
		when(mockIo.readConsole()).thenReturn("1").thenReturn("0");
		when(initilizer.getCategoryDao()).thenReturn(cDao);
		when(cDao.initProjects(musicCategory)).thenReturn(projects);
		when(cDao.initQuestions(newSongProject)).thenReturn(questions);
		
		new ProjectPage().showAllProjectsOfCategory(initilizer, mockIo, musicCategory, new ListUtilits());
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockIo, times(38)).writeln(captor.capture());
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
                + "Q&A:		, 1.	Who?, "
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
		when(initilizer.getCategoryDao()).thenReturn(cDao);
		when(cDao.initProjects(musicCategory)).thenReturn(projects);
		
		new ProjectPage().showAllProjectsOfCategory(initilizer, mockIo, musicCategory, new ListUtilits());
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockIo, times(46)).writeln(captor.capture());
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
                + "Q&A:		, No questions!, "
                + "------------------------------------------, "
                + "Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	Invest in project, "
                + "2	-	Ask a question, "
                + "Choose one of the items bellow, , "
                + "0	-	Exit, "
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
	public void projectPageTestAskQuestionNo() {
		
		when(mockIo.readConsole()).thenReturn("1").thenReturn("2").thenReturn("n").thenReturn("0");
		when(initilizer.getCategoryDao()).thenReturn(cDao);
		when(cDao.initProjects(musicCategory)).thenReturn(projects);
		
		new ProjectPage().showAllProjectsOfCategory(initilizer, mockIo, musicCategory, new ListUtilits());
		
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockIo, times(44)).writeln(captor.capture());
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
                + "Q&A:		, No questions!, "
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
	@Test
	public void projectPageTestAskQuestionYes() {
		
		when(mockIo.readConsole()).thenReturn("1").thenReturn("2").thenReturn("y").thenReturn("0");
		when(initilizer.getCategoryDao()).thenReturn(cDao);
		when(cDao.initProjects(musicCategory)).thenReturn(projects);
		
		new ProjectPage().showAllProjectsOfCategory(initilizer, mockIo, musicCategory, new ListUtilits());
		
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockIo, times(44)).writeln(captor.capture());
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
                + "Q&A:		, No questions!, "
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
