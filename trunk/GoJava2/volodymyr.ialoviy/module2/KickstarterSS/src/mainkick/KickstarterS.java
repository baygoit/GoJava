package mainkick;
import java.io.IOException;


public class KickstarterS {
	private static void toCategory() throws IOException{
		while (true){
			Category cat = new Category();
			Project project = new Project();
			Output out = new OutputConsole();
			Inputs choiceCN = new InputsConsole();
			int chosenCategory;
			int chosenProject;
			int choiceToProject;
			
			cat.showAllCatecories();
			out.print("Choice Category Number: ");
			chosenCategory = choiceCN.enter();
			
			while (true){
				cat.showAllProjectInCategory(chosenCategory);
				out.print("Choice Project Number or 0 for exit to Category: ");
				chosenProject = choiceCN.enter();
				if (chosenProject == 0){
					break;
				}
				project.showProject(chosenProject);
				out.print("Choice 0 for exit to Project: ");
				choiceToProject = choiceCN.enter();
				if (choiceToProject == 0){
					continue;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		Quotes quote = new Quotes();
		Output out = new OutputConsole();
		out.print(quote.getQuote());
		
		toCategory();
	}
	
}