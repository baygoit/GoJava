package launcher;

import java.util.Scanner;

import entities.*;
import storages.*;


public class RunKickstarter {
	
	public static void main(String[] args) {
		
		Quotes quotes = new Quotes();
		Category categories = new Category();
		Category projects = new Category();
		ProjectsStorage project = new ProjectsStorage();
		
		quotes.showQuoteMenu();
		categories.showCategoryMenu();
		
		project.create();
		project.showProject();

		
	}
}