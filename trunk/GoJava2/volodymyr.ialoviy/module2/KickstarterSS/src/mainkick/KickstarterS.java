package mainkick;
import java.io.IOException;


public class KickstarterS {
	private static void toCategory() throws IOException, InterruptedException{
		while (true){
			Category cat = new Category();
			Project project = new Project();
			Output out = new OutputConsole();
			Check check = new Check();
			int chosenCategory;
			int chosenProject;
			int choiceToProject;
			
			cat.showAllCatecories();
			out.print("Choice Category Number: ");
			chosenCategory = check.checkNumber();
			if (chosenCategory == 777){
				Thread.sleep(10000);
				continue;
			}
			out.print("Your chosen category: " + cat.showCategoryName(chosenCategory) + ", containing the following projects: ");
			
			while (true){
				cat.showAllProjectInCategory(chosenCategory);
				out.print("Choice Project Number or 0 for exit to Category: ");
				chosenProject = check.checkNumber();
				if (chosenProject == 0){
					break;
				}
				project.showProject(chosenProject);
				out.print("Choice 0 for exit to Project: ");
				choiceToProject = check.checkNumber();
				if (choiceToProject == 0){
					continue;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException, InterruptedException{
		BD bd = new BD();
		Quotes quote = new Quotes();
		Output out = new OutputConsole();
		
		out.print(quote.getQuote());
		
		toCategory();
	}
	
}