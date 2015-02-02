package test;

import static org.junit.Assert.*;

import org.junit.*;

import gojava.*;

public class UnitTestKickstarter {
	Output output = new Output();
	Categories categories = new Categories();
	Description descr = new Description();
	
	@Test
	public void shouldPrintHello_whenStarts() {
		assertEquals("Welcome to the place where "
				+ "your dreams become real possibilities! ;)\n",
				output.hello());
	}
	
	@Test
	public void shouldShowProjects_whenCategoryIsChosen() {
		int i = 0;
		assertEquals("You have chosen Category Sports\n"+
					"Choose a project:\n"+
						"1 - Football\n"+
						"this is a short description\n"+
						"Money needed: 10000; Money collected: 9999\n"+
						"Days left: 7\n"+
						"2 - Basketball\n"+
						"this is a short description\n"+
						"Money needed: 10000; Money collected: 9999\n"+
						"Days left: 7\n"+
						"0 - Go back\n", 
						output.projectsMenu(categories.getCategory(i)));
	}
	
	@Test
	public void shouldShowProject_whenProjectIsChosen(){
		int i = 0;
		assertEquals("Football\n"+
				"this is a short description\n"+
				"Money needed: 10000; Money collected: 9999\n"+
				"Days left: 7\n"+
				"this is a very interesting project story\n"+
				"www.link.com\n"+
				"--------------------------\n"+
				"Q: this is a question\n"+
				"A: this is an answer\n"+
				"Q: this is a question\n"+
				"A: this is an answer\n"+
				"Q: this is a question\n"+
				"A: this is an answer\n"+
				"0 - Go back\n", 
				output.showProject(categories.getCategory(i).getProject(i)));
	}

	@Test
	public void shouldShowCategories_whenFilled(){
		assertEquals("1 - Sports\n2 - Music\n3 - Games\n0 - Go back\n", 
				categories.showList());
	}
	
	@Test
	public void shouldInit_whenInitCalled() {
		descr.initTitle("aaa");
		assertEquals("aaa", descr.getTitle());
	}
}
