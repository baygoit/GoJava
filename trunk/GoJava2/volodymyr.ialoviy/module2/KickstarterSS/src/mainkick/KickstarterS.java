package mainkick;
import java.io.IOException;

public class KickstarterS {

	private static void toCategory() throws IOException, InterruptedException{
		Check check = new Check(new InputsConsole(), new OutputConsole());
		Categories categories = new Categories();
		Projects projects = new Projects();
		projects.writeAllCatecories();
		int chosenCategory;
		int chosenProject;
		int choiceToProject;
		while (true){
			printer(categories.showAllCatecories());
			printer("Choice Category Number: ");
			chosenCategory = check.checkNumber(categories.kickContainCategory(), true);
			if (chosenCategory == 777){
				Thread.sleep(10000);
				continue;
			}
			printer("Your chosen category: " + categories.showCatecoryName(chosenCategory - 1) + ", containing the following projects: ");
			
			while (true){
				printer(categories.showAllProjectInCategory(chosenCategory - 1));
				printer("Choice Project Number or 0 for exit to Category: ");
				chosenProject = check.checkNumber(categories.projectsContain(chosenCategory - 1), false);
				if (chosenProject == 0){
					break;
				}
				printer(projects.showProjectFull(chosenProject - 1));
				printer("Choice 0 for exit to Project: ");
				int[] zero = {0};
				choiceToProject = check.checkNumber(zero, false);
				if (choiceToProject == 0){
					continue;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException, InterruptedException{
		Quotes quote = new Quotes();
		
		printer(quote.getQuote());
		
		toCategory();
	}
	
	public static void printer(String string){
		Output out = new OutputConsole();
		out.print(string);
	}

}