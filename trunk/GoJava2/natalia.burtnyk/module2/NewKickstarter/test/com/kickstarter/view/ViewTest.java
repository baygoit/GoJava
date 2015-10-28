package com.kickstarter.view;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.mockito.Mockito;
import org.junit.Before;
import org.junit.Test;

import com.kickstarter.model.Project;
import com.kickstarter.model.Сategory;

public class ViewTest {
	
	private Out out;
	private View view;
	
	@Before
	public void setup() {
	//given
	 out = Mockito.mock(Out.class);
	 view = new View(out);
	}
	
	@Test
	public void test1() {
		//when
		view.displayProject(new Project("Project1", "des", "coming soon", "http:", 1000, 400, 20));
		//then
		Mockito.verify(out).outPut("\nProject1\n" +
									"Description:        des\n" +
									"Required Amount:    1000$\n" +
									"Total:              400$\n" +
									"Days:               20\n" +
									"History:            coming soon\n" +
									"URL:                http:\n" +
									"--------------------------------\n");
	}
	
	@Test
	public void test2() {
		//when
		List<Project>projects = new ArrayList<Project>();
		Project project1 = new Project("Green Pea Cookie.", "We want to produce green cookies.",
									"Coming soon... ","http:gps.rom.new", 8000, 3654, 17);
		projects.add(project1);
    	view.displayProjects(projects);
    	//then
    	Mockito.verify(out).outPut("1. Green Pea Cookie.\n"+
    							"Description:        We want to produce green cookies.\n" +
    							"Required Amount:    8000$\n" +
    							"Total:              3654$\n" +
    							"Days:               17\n" +
    							"----------------------------------\n");
	}
	
	@Test
	public void test3() {
		//when
		view.displayWelcome();
		//then
		Mockito.verify(out).outPut(" Welcome to Kickstarter\n" +
									"  *** *** *** *** *** \n");
	}

	@Test
	public void test4() {
		//when
		List<Сategory> categories = new LinkedList<Сategory>();
		Сategory food = new Сategory("FOOD"); 
    	categories.add(food); 
    	view.displayListCategories(categories);
    	//then
    	Mockito.verify(out).outPut("1. FOOD\n");
	
	}
	
}