package mainkick;
import java.io.IOException;
import java.util.Arrays;


public class KickstarterS {
	private static void toCategory() throws IOException, InterruptedException{
		while (true){
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
			
			categories.showAllCatecories();
			out.print("Choice Category Number: ");
			chosenCategory = check.checkNumber();
			if (chosenCategory == 777){
				Thread.sleep(10000);
				continue;
			}
			out.print("Your chosen category: " + Categories.listCatecories.get(chosenCategory - 1).getCategoryName() + ", containing the following projects: ");
			
			while (true){
				category.showAllProjectInCategory(chosenCategory - 1);
				out.print("Choice Project Number or 0 for exit to Category: ");
				chosenProject = check.checkNumber();
				if (chosenProject == 0){
					break;
				}
				project.showProjectFull(chosenProject - 1);
				out.print("Choice 0 for exit to Project: ");
				choiceToProject = check.checkNumber();
				if (choiceToProject == 0){
					continue;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException, InterruptedException{
		Quotes quote = new Quotes();
		Output out = new OutputConsole();
		
		out.print(Arrays.toString(quote.getQuote()));
		
		toCategory();
	}

}