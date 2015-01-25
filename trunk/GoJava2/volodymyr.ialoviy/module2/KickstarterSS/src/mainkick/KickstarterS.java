package mainkick;
import java.io.IOException;


public class KickstarterS {
	static Category cat = new Category();
	static Output choicePN = new OutputConsole();
	static Enter choiceCN = new EnterConsole();
	static Project project = new Project();
	static int choiceCat;
	static int choiceProj;
	static int choiceToProj;
	
	private static void toCategory() throws IOException{
		cat.showAllCatecories();
		choicePN.print("Choice Category Number: ");
		choiceCat = choiceCN.enter();
		cat.showAllProjectInCategory(choiceCat);
		toProject();
	}
	
	private static void toProject() throws IOException{
		choicePN.print("Choice Project Number or 0 for exit to Category: ");
		choiceProj = choiceCN.enter();
		if (choiceProj == 0){
			toCategory();
		}
		project.showProject(choiceProj);
		choicePN.print("Choice 0 for exit to Project: ");
		choiceToProj = choiceCN.enter();
		if (choiceToProj == 0){
			cat.showAllProjectInCategory(choiceCat);
			toProject();
		}
	}
	
	public static void main(String[] args) throws IOException{
		
		Quotes quote = new Quotes();
		System.out.println(quote.getQuote());
		
		toCategory();
	}
	
}