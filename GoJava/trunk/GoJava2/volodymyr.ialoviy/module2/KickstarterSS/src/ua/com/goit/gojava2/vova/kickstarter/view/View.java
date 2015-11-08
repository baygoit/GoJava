package ua.com.goit.gojava2.vova.kickstarter.view;

import java.util.List;

import ua.com.goit.gojava2.vova.kickstarter.model.Category;
import ua.com.goit.gojava2.vova.kickstarter.model.Project;

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
	
	public void showAllCategories(List<Category> Category) {
		for (Category category : Category){
			printer(Integer.toOctalString(category.getCategoryID()) + " " + category.getCategoryName());
		}
		printer("Choice Category Number: ");
	}
	
	public void printYourChosenCategory(String categories) {
		printer("Your chosen category: "
				+ categories
				+ ", containing the following projects: ");
	}
	
	public void printShortProgect(List<Project> projects){
		for (Project project : projects){
			printer(project.getProjectID() + " " +  project.getProjectName() + " " + project.getShortDescription() + " " + 
						project.getHowMuchNeeded() + " " + project.getHowMuchCollected());
		}
	}
	
	public void printChoiceProjectNumber(int menuCategories){
		printer("Choice Project Number or " + menuCategories
				+ " for exit to Category: ");
	}
	
	public void printProject(Project project) {
		printer("project ID = " + project.getProjectID() + "\n"
					+ "project name: " + project.getProjectName() + "\n"
					+ "short description: " + project.getShortDescription() + "\n"
					+ "full description: " + project.getFullDescription() + "\n"
					+ "foto: " + project.getFoto() + "\n"
					+ "link: " + project.getLink() + "\n"
					+ "how much needed = " + project.getHowMuchNeeded() + "\n"
					+ "how much collected = " + project.getHowMuchCollected() + "\n"
					+ "how much remaining = " + project.getHowMuchRemaining() + "\n"
					+ "faq = " + project.getFaq() + "\n"
					+ "days to go = " + Integer.toString(project.getDaysLeft()));
	}
	
	public void printChoiceProjectOrPaymentOrQuestion(int menuProjects, int menuPayment, int menuQuestion){
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

	public void printClose() {
		printer("Thank you for your choice our Kickstarter. One minute, i will close so soon");
	}
}
