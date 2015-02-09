package mainkick;
import java.io.IOException;
import java.util.ArrayList;

public class KickstarterS {
	public KickstarterS() throws IOException, InterruptedException{
		Quotes quote = new Quotes();
		printer(quote.getQuote());
		int chosenCategory;
		int chosenProject;
		int choiceToProject;
		int magic = 777;
		Check check = new Check(new InputsConsole(), new OutputConsole());
		Categories categories = new Categories();
		Category category = new Category();
		Project project = new Project();
		Projects projects = new Projects();
		projects.writeAllProjects();
		while (true){
			printer(categories.readAllCatecories());
			printer("Choice Category Number: ");
			chosenCategory = check.checkNumber(category.kickContainCategory(categories), true);
			if (chosenCategory == magic){
				Thread.sleep(10000);
				continue;
			}
			printer("Your chosen category: " + category.showCatecoryName(chosenCategory - 1, categories) + ", containing the following projects: ");
			
			while (true){
				printer(category.showAllProjectInCategory(chosenCategory - 1, project, projects, categories));
				printer("Choice Project Number or 0 for exit to Category: ");
				chosenProject = check.checkNumber(category.projectsContain(chosenCategory - 1, categories), false);
				if (chosenProject == 0){
					break;
				}
				printer(project.showProjectFull(chosenProject - 1, projects.getListProject()));
				printer("Have a question? If the info above doesn't help, you can ask the project creator directly - Choice 555");
				printer("Choice 0 for exit to Project list.\nChoice 888 to invest in the project.\nChoice 999 to ask a question: ");
				int[] zero = {0, 888, 999};
				choiceToProject = check.checkNumber(zero, false);
				if (choiceToProject == 0){
					continue;
				}
				if (choiceToProject == 888){
					printer("1 - 1$ = OUR UNDYING LOVE");
					printer("2 - 10$ = HEY… NICE SHIRT");
					printer("3 - 40$ = KICKSTARTER EXCLUSIVE");
					printer("Enter your name:");
					printer(check.checkName());
					printer("Enter your credit card number:");
					check.checkCard();
					printer("Enter the amount of donations:");
					int amount = check.checkAmount();
					project.setDonation(projects.getListProject(), amount, chosenProject - 1);
					printer(project.showProjectFull(chosenProject - 1, projects.getListProject()));
					continue;
				}
				if (choiceToProject == 999){
					printer("Choice 999");
					printer("Enter your question:");
					printer(Integer.toString(project.getFaq().size()));
					project.setFAQ();
					project.setFAQ();
					printFaq(project.getFaq());
					printer(Integer.toString(project.getFaq().size()));
					continue;
				}
			}
		}
	}
	
	private void printer(String string){
		Output out = new OutputConsole();
		out.print(string);
	}
	
	private void printFaq(ArrayList<String> faq) {
        for(int i = 0; i < faq.size(); i++){
        	printer(faq.get(i));
        }
	}
}