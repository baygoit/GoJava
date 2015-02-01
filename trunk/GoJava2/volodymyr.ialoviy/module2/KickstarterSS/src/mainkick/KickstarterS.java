package mainkick;
import java.io.IOException;

public class KickstarterS {
	private static void toCategory() throws IOException, InterruptedException{
		Output out = new OutputConsole();
		Check check = new Check();
		Categories categories = new Categories();
		Category category = new Category();
		Project project = new Project();
		Projects projects = new Projects();
		projects.writeAllCatecories();
		int chosenCategory;
		int chosenProject;
		int choiceToProject;
		while (true){
			out.print(categories.showAllCatecories());
			out.print("Choice Category Number: ");
			chosenCategory = check.checkNumber(categories.kickContainCategory(), true);
			if (chosenCategory == 777){
				Thread.sleep(10000);
				continue;
			}
			out.print("Your chosen category: " + Categories.listCatecories.get(chosenCategory - 1).getCategoryName() + ", containing the following projects: ");
			
			while (true){
				out.print(category.showAllProjectInCategory(chosenCategory - 1));
				out.print("Choice Project Number or 0 for exit to Category: ");
				chosenProject = check.checkNumber(Categories.listCatecories.get(chosenCategory - 1).projectsThatContain, false);
				if (chosenProject == 0){
					break;
				}
				out.print(project.showProjectFull(chosenProject - 1));
				out.print("Choice 0 for exit to Project: ");
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
		Output out = new OutputConsole();
		
		out.print(quote.getQuote());
		
		toCategory();
	}

}