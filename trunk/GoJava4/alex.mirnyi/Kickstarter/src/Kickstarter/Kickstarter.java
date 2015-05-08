package Kickstarter;

import java.io.*;
import java.util.*;

public class Kickstarter {
	private CategoriesContainer categories;
	private ProjectsContainer projects;
	
	public Kickstarter() {
		categories = new CategoriesContainer();
		projects = new ProjectsContainer();
	}
	
	public static void main(String[] args) {
		Kickstarter kickstarter = new Kickstarter();
		
		Category medicine = new Category("Medicine");
		Category music = new Category("Music");

		kickstarter.getCategories().add(medicine);
		kickstarter.getCategories().add(music);
		
		Project alcoTester = new Project(medicine, "Alco Tester", 
				                         "Phenomenal alco test just by scanning your eyes",
    		                             50000, 23000, 15, "my history1", "www.verbohlest.narod.ru", "my question1");
		kickstarter.getProjects().add(alcoTester);
		
		Project eyes = new Project(medicine, "Eyes training device", "Get 100% sight",
    		      							 100000, 15000, 24);
		kickstarter.getProjects().add(eyes);
		
		Project melody = new Project(music, "Sing Melody", 
				                     "Sing melody and hear how it sounds in "
				                     + "different musical instruments",
				                     15000, 22000, 110);
		kickstarter.getProjects().add(melody);
						
		Console console = new Console(kickstarter, new ConsolePrinter());
		
		console.showCategories();
	}

	public CategoriesContainer getCategories() {
		return categories;
	}

	public void setCategories(CategoriesContainer categories) {
		this.categories = categories;
	}

	public ProjectsContainer getProjects() {
		return projects;
	}

	public void setProjects(ProjectsContainer projects) {
		this.projects = projects;
	}
}
