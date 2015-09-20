 package gojava;

import static org.junit.Assert.*;
import gojava.InMemory.InMemoryCategories;
import gojava.InMemory.InMemoryProject;

import org.junit.*;

public class UnitTestKickstarter {
	ConsoleIO io = new ConsoleIO();
	InMemoryCategories inMemoryCategories = new InMemoryCategories();
	
	@Test
	public void shouldShowCategories_whenFilled(){
		inMemoryCategories.fillCategories();		
		assertEquals("1 - Games\n2 - Music\n3 - Sports\n0 - Go back\n", 
				inMemoryCategories.showCategories());
	}
	
	@Test
	public void shouldShowProjects_whenCategoryIsChosen() {
		inMemoryCategories.fillCategories();		
		assertEquals("You have chosen Category Sports\n"+
					"Choose a project:\n"+
						"1 - Basketball\n"+
						"this is a short description\n"+
						"Money needed: 10000; Money collected: 0\n"+
						"Days left: 7\n"+
						"--------------------------\n"+
						"2 - Football\n"+
						"this is a short description\n"+
						"Money needed: 10000; Money collected: 0\n"+
						"Days left: 7\n"+
						"--------------------------\n"+
						"0 - Go back\n", 
						inMemoryCategories.getCategory(2).showProjects());
	}
	
	@Test
	public void shouldShowProject_whenProjectIsChosen(){
		inMemoryCategories.fillCategories();		
		InMemoryProject project=(InMemoryProject) inMemoryCategories.getCategory(2).getProject(1);
		assertEquals("Football\n"+
				"this is a short description\n"+
				"Money needed: 10000; Money collected: 0\n"+
				"Days left: 7\n"+
				"this is a very interesting project story\n"+
				"www.link.com\n"+
				"Q: this is a question\n"+
				"A: this is an answer\n"+
				"Q: this is a question\n"+
				"A: this is an answer\n"+
				"Q: this is a question\n"+
				"A: this is an answer\n"+
				"--------------------------\n"+
				"1 - Ask question\n2 - Invest\n0 - Go back\n", 
				project.showProject());
	}	
	
	
}
