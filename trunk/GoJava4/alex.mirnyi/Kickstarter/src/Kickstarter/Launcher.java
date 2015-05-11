package Kickstarter;

import java.io.IOException;

import Data.Quote;
import Data.Category;
import Data.Project;
import DataContainers.CategoriesContainer;
import DataContainers.ProjectsContainer;
import DataContainers.QuotesContainer;
import InputOutput.printers.ConsolePrinter;
import InputOutput.printers.Printer;
import InputOutput.readers.ConsoleReader;
import InputOutput.readers.Reader;

public class Launcher {
	public static void main(String[] args) throws IOException {	
		QuotesContainer quotes = new QuotesContainer();
		quotes.add(new Quote("Impossible is nothing"));
		quotes.add(new Quote("Smile makes you better"));
		quotes.add(new Quote("Impossible is nothing"));
		
		Category medicine = new Category("Medicine");
		Category music = new Category("Music");
		CategoriesContainer categories = new CategoriesContainer();
		categories.add(medicine);
		categories.add(music);
		
		Project alcoTester = new Project(medicine, "Alco Tester", 
				                         "Phenomenal alco test just by scanning your eyes",
    		                             50000, 23000, 15);
		alcoTester.setHistory("Far-far away...");
		alcoTester.setVideoLink("verbohlest.narod.ru");
		alcoTester.setQuestions("what?");
		Project eyes = new Project(medicine, "Eyes training device", "Get 100% sight",
    		      							 100000, 15000, 24);
		Project melody = new Project(music, "Sing Melody", 
				                     "Sing melody and hear how it sounds in "
				                     + "different musical instruments",
				                     15000, 22000, 110);
		ProjectsContainer projects = new ProjectsContainer();
		projects.add(alcoTester);
		projects.add(eyes);
		projects.add(melody);
						
		Kickstarter kickstarter = new Kickstarter(new ConsolePrinter(), new ConsoleReader(), quotes, 
				                                  categories, projects);
		kickstarter.run();
	}

}
