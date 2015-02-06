package mainkick;
import java.io.IOException;

public class KickstarterS {

	private static void toCategory() throws IOException, InterruptedException{
		int chosenCategory;
		int chosenProject;
		int choiceToProject;
		int magic = 777;
		Check check = new Check(new InputsConsole(), new OutputConsole());
		Categories categories = new Categories();
		Category category = new Category();
		Project project = new Project();
		Projects projects = new Projects();
		projects.writeAllCatecories();
		while (true){
			printer(categories.readAllCatecories());
			printer("Choice Category Number: ");
			chosenCategory = check.checkNumber(category.kickContainCategory(), true);
			if (chosenCategory == magic){
				Thread.sleep(10000);
				continue;
			}
			printer("Your chosen category: " + category.showCatecoryName(chosenCategory - 1) + ", containing the following projects: ");
			
			while (true){
				printer(category.showAllProjectInCategory(chosenCategory - 1, project));
				printer("Choice Project Number or 0 for exit to Category: ");
				chosenProject = check.checkNumber(category.projectsContain(chosenCategory - 1), false);
				if (chosenProject == 0){
					break;
				}
				printer(project.showProjectFull(chosenProject - 1));
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