import java.io.IOException;


public class KickstarterS {
	public static void main(String[] args) throws IOException{
			
			Quotes quote = new Quotes();
			System.out.println(quote.getQuote());
			
			Category cat = new Category();
			cat.showAllCatecories();
			
			Output choicePN = new Output();
			choicePN.print("Choice Category Number: ");
			
			Enter choiceCN = new Enter();
			int choice = choiceCN.enter();

			cat.showAllProjectInCategory(choice);
			
			choicePN.print("Choice Project Number or 0 for exit: ");
			choice = choiceCN.enter();
			
			if (choice == 0){
				
			}
			Project project = new Project();
			project.showProject(choice);


			
	}
}