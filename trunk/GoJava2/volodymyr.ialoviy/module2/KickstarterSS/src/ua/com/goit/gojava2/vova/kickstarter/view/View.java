package ua.com.goit.gojava2.vova.kickstarter.view;

import java.util.List;

import ua.com.goit.gojava2.vova.kickstarter.model.Category;


public class View {
	private Output out;
	
	public View(Output out){
		this.out = out;
	}

	public Output getOut() {
		return out;
	}

	public void printer(String string) {
		out.print(string);
	}
	
	public void printQuote(String quote) {
		printer(quote);		
	}
	
	public void showAllCategories(List<Category> list) {
		for (Category category : list){
			printer(Integer.toOctalString(category.getCategoryID()) + " " + category.getCategoryName());
		}
		printer("Choice Category Number: ");
	}
	
	public void printProjectsInCategory(String categories, String projects, int menuCategories) {
		printer("Your chosen category: "
				+ categories
				+ ", containing the following projects: ");
		printer(projects);
		printer("Choice Project Number or " + menuCategories
				+ " for exit to Category: ");
	}
	
	public void printProject(String project, int menuProjects, int menuPayment, int menuQuestion) {
		printer(project);
		printer("Choice "
				+ menuProjects
				+ " for exit to Project list.\nChoice "
				+ menuPayment
				+ " to invest in the project:"
				+ "Have a question? If the info above doesn't help, you can ask the project creator directly - Choice "
				+ menuQuestion + ":");
	}

	public void printChoicePayment() {
		printer("\"0\" - No thanks, I just want to help the project."
				+ " \"1\" - 1$ = OUR UNDYING LOVE"
				+ " \"2\" - 10$ = HEY… NICE SHIRT"
				+ " \"3\" - 40$ = KICKSTARTER EXCLUSIVE");
	}
	
	public void printAskAmount() {
		printer("Enter the amount of donations:");
	}

	public void printAskCard() {
		printer("Enter your credit card number:");
	}

	public void printAskName() {
		printer("Enter your name:");
	}

	public void printAskQuestion() {
		printer("Enter your question:");
	}
	
	public void printThank(String name, int chosenPay) {
		printer("Thank you " + name + " for your generous (" + chosenPay + ") contribution.");
	}

	public void printBug() {
		printer("You have entered an incorrect value or a null value, check the value you entered and try again");		
	}

	public void printClose() {
		printer("Thank you for your choice our Kickstarter. One minute, i will close so soon");
	}
}
