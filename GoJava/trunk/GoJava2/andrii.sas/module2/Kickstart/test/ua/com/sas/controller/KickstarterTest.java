package ua.com.sas.controller;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import ua.com.sas.model.*;
import ua.com.sas.view.*;
import static org.mockito.Mockito.*;

public class KickstarterTest {
	
	private Output out;
	private Input in;
	private Categories categories;
	private Projects projects;
	private Quote quote;
	private Kickstart kickstart;
	private View view;
	

	@Before
	public void setup(){
		ConnectionDAO connectionDAO = new ConnectionDAO("kickstarter_db_test", "postgres", "gfhfien17");
		out = mock(Output.class);
		in = mock(Input.class);
		categories = new CategoriesDAO(connectionDAO);
		projects = new ProjectsDAO(connectionDAO);
		view = new View(out);
		quote = mock(Quote.class);
		kickstart = new Kickstart(view, in, categories, projects, quote);
	}
	
	@Test
	public void shouldExitFromProgramm(){
		//when
		when(in.readChoice()).thenReturn("0");
		kickstart.buildMenu();
	}
	
	@Test
	public void sholdPrintChosenCategory(){
		//given
		Category category1 = new Category("category1");
		Category category2 = new Category("category2");
		categories.add(category1);
		categories.add(category2);
			
		//when
		when(quote.generateQuote()).thenReturn("quote");
		when(in.readChoice()).thenReturn("1", "0", "0");
		kickstart.buildMenu();
		List<String> values = assertOut(out, 6);
			
		//then
		assertEquals("[quote" +
		              ", 1 - category1, 2 - category2\n" +
		              "What are you interested in? Pleace, make your choice:" +
		              ", You chose - category1" +
		              ", If you want to return press \"0\"" +
		              ", 1 - category1, 2 - category2\n" +
		              "What are you interested in? Pleace, make your choice:" +
		              ", Thanks for using our program, Goodbye!" +
		              "]", values.toString());
	}
	

	@Test
	public void shouldDisplayError_whenNotExistingItemIsSelected(){
		//given
		Category category1 = new Category("category1");
		Category category2 = new Category("category2");
		categories.add(category1);
		categories.add(category2);
		Project project1 = new Project(category1);
		project1.setProject("name1", "description1", 1000, 200, 10, "history1", "videoLink1", "questions");
		projects.add(project1);
		
		//when
		when(in.readChoice()).thenReturn("1", "1", "4", "0", "3", "0", "3", "0");
		when(quote.generateQuote()).thenReturn("quote");
		kickstart.buildMenu();
		List<String> values = assertOut(out, 19);
		//then
		assertEquals("[quote" +
					", 1 - category1, 2 - category2\n" +
					"What are you interested in? Pleace, make your choice:" +
					", You chose - category1" +
					", 1) Name - name1, Description - description1, Money we need - 1000, Money we have - 200, Days left - 10" +
					", If you want to return press \"0\"" +
					", --------------------------------------------------" +
					", You chose: Name - name1, Description - description1, Money we need - 1000, Money we have - 200, Days left - 10" +
					", history1" +
					", videoLink1" +
					", questions" +
					", --------------------------------------------------" +
					", 1 - invest to project, 2 - ask question (Return - 0)" +
					", Error!! There are no such menu item, try again:" +
					", 1) Name - name1, Description - description1, Money we need - 1000, Money we have - 200, Days left - 10" +
					", If you want to return press \"0\"" +
					", Error!! There are no such project - Try again:" +
					", 1 - category1, 2 - category2\n" +
					"What are you interested in? Pleace, make your choice:" +
					", Error!! There are no such category - Try again:" +
					", Thanks for using our program, Goodbye!" +
					"]", values.toString());
	}
	

	@Test
	public void shouldCheckMenuOfSelectedProject_whenIncorrectItemChosen(){
		//given
		Category category1 = new Category("category1");
		Category category2 = new Category("category2");
		categories.add(category1);
		categories.add(category2);
		Project project1 = new Project(category1);
		project1.setProject("name1", "description1", 1000, 200, 10, "history1", "videoLink1", "questions");
		projects.add(project1);
		
		//when
		when(quote.generateQuote()).thenReturn("quote");
		when(in.readChoice()).thenReturn("1", "1", "4", "0", "3", "0", "3", "0");
		kickstart.buildMenu();
		List<String> values = assertOut(out, 19);
		//then
		assertOut(values, "quote");
		assertOut(values, "1 - category1, 2 - category2\nWhat are you interested in? Pleace, make your choice:");
		assertOut(values, "1) Name - name1, Description - description1, Money we need - 1000, Money we have - 200, Days left - 10");
		assertOut(values, "Thanks for using our program, Goodbye!");
		assertOut(values, "--------------------------------------------------");
		assertOut(values, "You chose: Name - name1, Description - description1, Money we need - 1000, Money we have - 200, Days left - 10");
		assertOut(values, "If you want to return press \"0\"");
		assertOut(values, "You chose - category1");
		assertOut(values, "history1");
		assertOut(values, "videoLink1");
		assertOut(values, "questions");
		assertOut(values, "Error!! There are no such project - Try again:");
		assertOut(values, "Error!! There are no such category - Try again:");
		
	}
	@Test
	public void shouldDisplayProjectInvestmentFields_whenSelectedInvestToProject(){
		//given
		Category category1 = new Category("category1");
		categories.add(category1);
		Project project1 = new Project(category1);
		project1.setProject("name1", "description1", 1000, 200, 10, "history1", "videoLink1", "questions");
		projects.add(project1);
		
		//when
		when(quote.generateQuote()).thenReturn("quote");
		when(in.readChoice()).thenReturn("1", "1", "1", "4", "Gais", "123445", "100", "0", "0", "0");
		kickstart.buildMenu();
		
		//then
		List<String> values = assertOut(out, 32);
		assertOut(values, "1 - invest to project, 2 - ask question (Return - 0)");
		assertOut(values, "Please enter your name:");
		assertOut(values, "Please enter number of your credit card:");
		assertOut(values, "Please enter the sum, which you want to invest:");
		assertOut(values, "Thank you Gais for investing 100$ in our project!");
	}
    
	@Test
	public void shouldAddInvestedMoney(){
		//given
		Category category1 = new Category("category1");
		categories.add(category1);
		Project project1 = new Project(category1);
		project1.setProject("name1", "description1", 1000, 200, 10, "history1", "videoLink1", "questions");
		projects.add(project1);
		
		//when
		when(quote.generateQuote()).thenReturn("quote");
		when(in.readChoice()).thenReturn("1", "1", "1", "4", "Gais", "123445", "100", "0", "0", "0");
		kickstart.buildMenu();
		
		//then
		assertEquals(300, project1.getMoneyHas());
	}
	
	@Test
	public void shouldDisplayQuestionField_whenSelectedInvestAskQuestion(){
		//given
		Category category1 = new Category("category1");
		categories.add(category1);
		Project project1 = new Project(category1);
		project1.setProject("name1", "description1", 1000, 200, 10, "history1", "videoLink1", "questions");
		projects.add(project1);
		
		//when
		when(quote.generateQuote()).thenReturn("quote");
		when(in.readChoice()).thenReturn("1", "1", "2", "How are you?", "0", "0", "0");
		kickstart.buildMenu();
		
		//then
		List<String> values = assertOut(out, 25);
		assertOut(values, "1 - invest to project, 2 - ask question (Return - 0)");
		assertOut(values, "Ask your question, please:");
		assertOut(values, "Your question is: How are you?");
	}
	
	@Test
	public void shouldAddNewQuestionFromUser(){
		//given
		Category category1 = new Category("category1");
		categories.add(category1);
		Project project1 = new Project(category1);
		project1.setProject("name1", "description1", 1000, 200, 10, "history1", "videoLink1", "questions");
		projects.add(project1);
		
		//when
		when(quote.generateQuote()).thenReturn("quote");
		when(in.readChoice()).thenReturn("1", "1", "2", "How are you?", "0", "0", "0");
		kickstart.buildMenu();
		
		//then
		assertEquals("questions\nQ: How are you?", project1.getQuestion());
	}

	public void assertOut(List<String> values, String message) {
		assertTrue(values.contains(message));
	}
	
	public List<String> assertOut(Output out, int times) {
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(out, times(times)).println(captor.capture());
		List<String> values = captor.getAllValues();
		return values;
	}
	
}


