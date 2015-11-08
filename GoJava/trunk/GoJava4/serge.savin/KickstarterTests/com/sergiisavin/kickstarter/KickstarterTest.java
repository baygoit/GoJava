package com.sergiisavin.kickstarter;

import static org.junit.Assert.*;

import javax.naming.OperationNotSupportedException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.sergiisavin.kickstarter.category.container.Categories;
import com.sergiisavin.kickstarter.category.container.memory.CategoriesContainer;
import com.sergiisavin.kickstarter.project.Project;
import com.sergiisavin.kickstarter.project.container.Projects;
import com.sergiisavin.kickstarter.project.container.memory.ProjectsContainer;
import com.sergiisavin.kickstarter.quote.container.Quotes;
import com.sergiisavin.kickstarter.quote.container.memory.QuotesContainer;

public class KickstarterTest {

	private Kickstarter kickstarter;
	
	@Before
	public void setup(){
		kickstarter = new Kickstarter();
		injectQuotes();
		injectCategories();
		injectProjects();
	}
	
	private void injectProjects() {
		Projects projects = new ProjectsContainer();
		Project project = new Project("Jumping Frog Toy", "01.05.2015", "01.11.2015", 20000.0, 0.0, "Toys",
				"DESCRIPTION", "PROJECT HISTORY", "VIDEO URL", "QUESTIONS AND ANSWERS");
		try {
			projects.add(project);
		} catch (OperationNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		project = new Project("Boomba", "01.05.2015", "01.11.2015", 20000.0, 0.0, "Toys",
					"DESCRIPTION", "PROJECT HISTORY", "VIDEO URL", "QUESTIONS AND ANSWERS");
		try {
			projects.add(project);
		} catch (OperationNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		kickstarter.injectProjects(projects);
	}

	@Test
	public void testCreateKickstarter() {
		Kickstarter kickstarter = new Kickstarter();
		assertNotNull(kickstarter);
	}
	
	@Test
	public void testInjectQuotes(){
		injectQuotes();
		
	}

	private void injectQuotes() {
		Quotes quotes = new QuotesContainer("Easy come - easy go", "An apple a day keeps doctors away", "A good speach"
				+ " must be as girls skirt: short enaugh to be interesting and long enaugh to cover the subject");
		kickstarter.setQuotes(quotes);
	}

	@Test
	public void testInjectCategories(){
		injectCategories();
	}

	private void injectCategories() {
		Categories categories = new CategoriesContainer("Toys", "Software", "Gadgets");
		kickstarter.setCategories(categories);
	}
	
	@Test
	public void testGetRandomQuote(){
		String quote = kickstarter.getRandomQuote();
		assertNotNull(quote);
		System.out.println(quote);
	}
	
	@Test
	public void getProjectsByCategory(){
		String[] projectsByCategory = kickstarter.getProjectsByCategory("Toys");
		for(String project : projectsByCategory){
			System.out.println(project);
		}
	}
	
	@Test
	public void getCategories(){
		String[] categories = kickstarter.getCategories();
		String result = "";
		for(int i = 0 ; i < categories.length; i ++){
			result += categories[i] + " ";
		}
		assertEquals("Toys Software Gadgets ", result);
	}
}
