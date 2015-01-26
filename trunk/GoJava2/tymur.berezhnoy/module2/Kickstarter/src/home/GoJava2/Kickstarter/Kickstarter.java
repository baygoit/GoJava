package home.GoJava2.Kickstarter;

import java.util.ArrayList;
import java.util.List;

import home.GoJava2.Content.Category;
import home.GoJava2.Content.Project;
import home.GoJava2.Content.Quote;
import home.GoJava2.DataBase.CategoryStorage;
import home.GoJava2.DataBase.ProjectStorage;
import home.GoJava2.DataBase.QuoteStorage;
import home.GoJava2.Engine.ContentManager;

public class Kickstarter {
	
	private final String title = "**** Super duper Kickstarter ****";
	private ContentManager contentManager;
	private Category category;
	
	public void printCategorys() {
		int i = 1;
		List<Category> categories = contentManager.getCategorys();
		System.out.println("\n<- Categorys ->\n" + "№ Name");
		for(Category c: categories) {
			System.out.println(i +  " " + c.getNameCategory());
			i++;
		}
	}
	
	public void choiseCategory(int i) {
		category = contentManager.getCategory(i - 1);
	}
	
	public void showProjects() {
		List<Project> project = contentManager.getProjects(category);
		for(Project p: project) {
			System.out.println(p.getName());
		}
	}
	
	public void startApp() {
		contentManager = new ContentManager(new QuoteStorage(new ArrayList<Quote>()), 
											new CategoryStorage(new ArrayList<Category>()), 
											new ProjectStorage(new ArrayList<Project>()));
		// Head of app
		System.out.println("\t" + title);
		System.out.println("\n" + contentManager.getQuote().getContent());
		
		printCategorys();
		System.out.print("> Enter your category: ");
		choiseCategory(new InPut().getChoise());
		System.out.println("- You've chose: " + category.getNameCategory());
		showProjects();
	}
	
	public static void main(String[] args) {
		Kickstarter kickstarter = new Kickstarter();
		kickstarter.startApp();
	}
}