//OLEG default package is not OK. Please use some
// OLEG unused import
import java.util.ArrayList;
import java.util.List;

public class Kickstarter {

	private static QuoteStorage quoteStorage = new QuoteStorage();
	private static CategoryStorage categoryStorage = new CategoryStorage();
	private static Integer categoryNumber = null;
	private static Integer projectNumber = null;

	public static void main(String[] args) {
		// OLEG The static method getRandomQuote() from the type QuoteStorage should be accessed in a static way
		// OLEG If you create new storage - make all methods non static. Or call methods in static wat
		System.out.println(quoteStorage.getRandomQuote() + "\n");				
		categoryNumber = chooseCategory();		
		projectNumber = chooseProject(categoryNumber);
		viewProject(projectNumber);				
	}
	
	private static Integer chooseCategory() {
		CategoryStorage.printForChoice();
		System.out.println("\nChoose a category by number: ");		
		categoryNumber = ConsoleInspector.getInt();
		if(categoryNumber == 0) {
			ConsoleInspector.close();		
			System.out.println("See you soon!");
			// OLEG avoid System.exit()
			System.exit(0);
			// OLEG something wrong with formatting
			}
		System.out.println("Current category: " + categoryStorage.getCategory(categoryNumber - 1));		
		return categoryNumber;			
	}
	
	private static Integer chooseProject(Integer categoryNumber) {
		ProjectStorage.setProjectStorage(categoryNumber - 1);
		ProjectStorage.printAllShort();			
		System.out.println("\nChoose a project by number: ");
		projectNumber = ConsoleInspector.getInt();
		if(projectNumber == 0) {
			chooseProject(chooseCategory());
			};
		System.out.println("Current project: " + ProjectStorage.getProject(projectNumber).getName());
		return projectNumber;
	}
	
	private static void viewProject(Integer projectNumber){		
		Project project = new Project();
		project =  ProjectStorage.getProject(projectNumber);
		project.printFull();				
		while(true) {
			if (ConsoleInspector.getInt() == 0 ) {			
				viewProject(chooseProject(categoryNumber));												
			} 
			System.out.println("Type 0 to choose another project");
		}
	}
}
