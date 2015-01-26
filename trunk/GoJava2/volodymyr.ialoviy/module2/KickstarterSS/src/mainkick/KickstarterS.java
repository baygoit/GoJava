package mainkick;
import java.io.IOException;


public class KickstarterS {
	private static void toCategory() throws IOException{
		while (true){
			Category cat = new Category();
			Project project = new Project();
			Output out = new OutputConsole();
			Inputs choiceCN = new InputsConsole();
			int choiceCat;
			int choiceProj;
			int choiceToProj;
			
			cat.showAllCatecories();
			out.print("Choice Category Number: ");
			choiceCat = choiceCN.enter();
			
			while (true){
				cat.showAllProjectInCategory(choiceCat);
				out.print("Choice Project Number or 0 for exit to Category: ");
				choiceProj = choiceCN.enter();
				if (choiceProj == 0){
					break;
				}
				project.showProject(choiceProj);
				out.print("Choice 0 for exit to Project: ");
				choiceToProj = choiceCN.enter();
				if (choiceToProj == 0){
					continue;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		Quotes quote = new Quotes();
		System.out.println(quote.getQuote());
		
		toCategory();
	}
	
}