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
import ua.nenya.pages.InvestitionProjectPage;
import ua.nenya.project.Project;
import ua.nenya.project.Reward;
import ua.nenya.util.IO;
import ua.nenya.util.ListUtilits;

public class InvestitionProjectPageTest {

	private IO mockIo;
	private Project newSongProject;
	private DaoInitilizer initilizer;
	private CategoryDao cDao;
	private List <Reward> rewards = new ArrayList<>();
	
	@Before
	public void init() {
		mockIo = mock(IO.class);
		initilizer = mock(DaoInitilizer.class);
		cDao = mock(CategoryDaoMemoryImpl.class);
		
		Reward rewardAnyAmount = new Reward();
		rewardAnyAmount.setName("Any amount");
		rewardAnyAmount.setDescription("");
		
		Reward reward1 = new Reward();
		reward1.setName("100$");
		reward1.setDescription("Invest one hundred dollars and get bottle of water!!!");
		reward1.setAmount(100);
		
		Reward reward2 = new Reward();
		reward2.setName("200$");
		reward2.setDescription("Invest two hundreds dollars and get two tickets to the movie!!!");
		reward2.setAmount(200);
		
		rewards.add(rewardAnyAmount);
		rewards.add(reward1);
		rewards.add(reward2);
		
		newSongProject = new Project();
		newSongProject.setName("New Song");
		newSongProject.setDescription("description of new song");
		newSongProject.setNeededAmount(100);
		newSongProject.setAvailableAmount(10);
		newSongProject.setDaysRemain(100);
		newSongProject.setHistory("hystory of new song");
		newSongProject.setVideo("video about new song");
	}
	
	
	@Test
	public void investProjectPageTestOneYes() {
		
		when(mockIo.readConsole()).thenReturn("alex").thenReturn("111 000")
		.thenReturn("2").thenReturn("y").thenReturn("0");
		when(initilizer.getCategoryDao()).thenReturn(cDao);
		when(cDao.initRewards(newSongProject)).thenReturn(rewards);
		
		new InvestitionProjectPage().investInProject(initilizer, newSongProject, mockIo, new ListUtilits());
	    
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockIo, times(13)).writeln(captor.capture());
        assertEquals(
                "[Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	Any amount , "
                + "2	-	100$ Invest one hundred dollars and get bottle of water!!!, "
                + "3	-	200$ Invest two hundreds dollars and get two tickets to the movie!!!, "
                + "Your investition has added!, , "
                + "Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	Any amount , "
                + "2	-	200$ Invest two hundreds dollars and get two tickets to the movie!!!]"
                , captor.getAllValues().toString());
	}
	
	
	@Test
	public void investProjectPageTestOneNo() {
		
		when(mockIo.readConsole()).thenReturn("alex").thenReturn("111 000")
		.thenReturn("2").thenReturn("n").thenReturn("0");
		when(initilizer.getCategoryDao()).thenReturn(cDao);
		when(cDao.initRewards(newSongProject)).thenReturn(rewards);
		
		new InvestitionProjectPage().investInProject(initilizer, newSongProject, mockIo, new ListUtilits());
	    
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockIo, times(12)).writeln(captor.capture());
        assertEquals(
                "[Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	Any amount , "
                + "2	-	100$ Invest one hundred dollars and get bottle of water!!!, "
                + "3	-	200$ Invest two hundreds dollars and get two tickets to the movie!!!, "
                + "Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	Any amount , "
                + "2	-	100$ Invest one hundred dollars and get bottle of water!!!, "
                + "3	-	200$ Invest two hundreds dollars and get two tickets to the movie!!!]"
                , captor.getAllValues().toString());
	}
	
	
	@Test
	public void investProjectPageTestAnyAmountWrongEntering() {
		
		when(mockIo.readConsole()).thenReturn("alex").thenReturn("111 000")
		.thenReturn("1").thenReturn("one").thenReturn("0");
		when(initilizer.getCategoryDao()).thenReturn(cDao);
		when(cDao.initRewards(newSongProject)).thenReturn(rewards);
		
		new InvestitionProjectPage().investInProject(initilizer, newSongProject, mockIo, new ListUtilits());
	    
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockIo, times(14)).writeln(captor.capture());
        assertEquals(
                "[Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	Any amount , "
                + "2	-	100$ Invest one hundred dollars and get bottle of water!!!, "
                + "3	-	200$ Invest two hundreds dollars and get two tickets to the movie!!!, "
                + "Wrong entering!, , "
                + "Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	Any amount , "
                + "2	-	100$ Invest one hundred dollars and get bottle of water!!!, "
                + "3	-	200$ Invest two hundreds dollars and get two tickets to the movie!!!]"
                , captor.getAllValues().toString());
	}
	
	
	@Test
	public void investProjectPageTestAnyAmountYes() {
		
		when(mockIo.readConsole()).thenReturn("alex").thenReturn("111 000")
		.thenReturn("1").thenReturn("123").thenReturn("y").thenReturn("0");
		when(initilizer.getCategoryDao()).thenReturn(cDao);
		when(cDao.initRewards(newSongProject)).thenReturn(rewards);
		
		new InvestitionProjectPage().investInProject(initilizer, newSongProject, mockIo, new ListUtilits());
	    
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockIo, times(14)).writeln(captor.capture());
        assertEquals(
                "[Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	Any amount , "
                + "2	-	100$ Invest one hundred dollars and get bottle of water!!!, "
                + "3	-	200$ Invest two hundreds dollars and get two tickets to the movie!!!, "
                + "Your investition has added!, , "
                + "Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	Any amount , "
                + "2	-	100$ Invest one hundred dollars and get bottle of water!!!, "
                + "3	-	200$ Invest two hundreds dollars and get two tickets to the movie!!!]"
                , captor.getAllValues().toString());
	}
	
	
	@Test
	public void investProjectPageTestAnyAmountNo() {
		
		when(mockIo.readConsole()).thenReturn("alex").thenReturn("111 000")
		.thenReturn("1").thenReturn("123").thenReturn("n").thenReturn("0");
		when(initilizer.getCategoryDao()).thenReturn(cDao);
		when(cDao.initRewards(newSongProject)).thenReturn(rewards);
		
		new InvestitionProjectPage().investInProject(initilizer, newSongProject, mockIo, new ListUtilits());
	    
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockIo, times(12)).writeln(captor.capture());
        assertEquals(
                "[Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	Any amount , "
                + "2	-	100$ Invest one hundred dollars and get bottle of water!!!, "
                + "3	-	200$ Invest two hundreds dollars and get two tickets to the movie!!!, "
                + "Choose one of the items bellow, , "
                + "0	-	Exit, "
                + "1	-	Any amount , "
                + "2	-	100$ Invest one hundred dollars and get bottle of water!!!, "
                + "3	-	200$ Invest two hundreds dollars and get two tickets to the movie!!!]"
                , captor.getAllValues().toString());
	}
}
