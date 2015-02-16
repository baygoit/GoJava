package presenter;

import model.Categories;
import model.Projects;
import model.Quotes;
import util.InputChecker;
import view.InputsConsole;
import view.OutputConsole;


public class KickstarterS {
	private int menuCategories = 222;
	private int menuProjects = 333;
	private int menuProject = 444;
	private int menuPayment = 555;
	private int menuQuestion = 666;
	private int exit = 999;
	private int menu = menuCategories;
	private int choiceTo;//TODO DELETE
	private int chosenPay;//TODO DELETE
	private int chosenCategoryID;//TODO DELETE
	private int chosenProject;//TODO DELETE

    private InputsConsole in;
    private OutputConsole out;
	private Categories categories;
	private Projects projects;

	public KickstarterS(InputsConsole in, OutputConsole out, Categories categories, Projects projects) {
		this.in = in;
		this.setOut(out);
		this.categories = categories;
		this.projects = projects;
	}

    public OutputConsole getOut() {
        return out;
    }

	public void setOut(OutputConsole out) {
	        this.out = out;
	}

	public void kickstarter() {
		Quotes quote = new Quotes();
		printer(quote.getQuote());
		
		categories.writeAllCatecories();
		projects.writeAllProjects();
		
		categories();
	}

	private void categories() {
		showAllCategories();
		askCategory();
		
		menu = menuProjects;
		switchMenu();
	}

	private void projects() {
		int[] optionVariant = { menuCategories };
		printProjectsInCategory();
		askProject(optionVariant);

		if (elementInArray(optionVariant, chosenProject)) {
			menu = menuCategories;
			switchMenu();
		}

		menu = menuProject;
		switchMenu();
	}

	private void project() {
		int[] optionVariant = { menuProjects, menuPayment, menuQuestion, exit };

		printProject();
		askAfterProject(optionVariant);

		if (exit == choiceTo){
			return;
		}
		
		if (elementInArray(optionVariant, choiceTo)) {
			menu = choiceTo;
			switchMenu();
		}
	}

	private void payment() {
		int[] optionVariant = { 0, 1, 2, 3 };

		printChoicePayment();
		askHowMuchPay(optionVariant);

		printAskName();
		String name = "";
		askName(name);

		printAskCard();
		long cardNumber = 0;
		inCardNumber(cardNumber);

		
		if (chosenPay == 0) {
			printAskAmount();
			inAmount();
		}

		projects.setDonation(chosenProject - 1, chosenPay);
		
		printThank(name, chosenPay);
		
		menu = menuProject;
		switchMenu();
	}

	private void question() {
		printAskQuestion();
		askQuestion();

		menu = menuProject;
		switchMenu();
	}

	private void switchMenu() {
		switch (menu) {
		case 222:
			categories();
			break;
		case 333:
			projects();
			break;
		case 444:
			project();
			break;
		case 555:
			payment();
			break;
		case 666:
			question();
			break;
		case 999:
			System.exit(0);
			break;
		}
	}

	private void showAllCategories() {
		printer(categories.getStringAllCatecories());
		printer("Choice Category Number: ");
	}

	private void askCategory() {
		String choice = in.enter();
		if (InputChecker.checkNumber(categories.getKickCategories(), choice)){
			chosenCategoryID = Integer.valueOf(choice) - 1;
		}
		else {
			printBug();
			askCategory();
		}
	}

	private void askProject(int[] allowedVariants) {
		int[] concatProjectsAndVariants = concatArray(categories.projectsContain(chosenCategoryID), allowedVariants);
		String choice = in.enter();
		if (InputChecker.checkNumber(concatProjectsAndVariants, choice)){
			chosenProject = Integer.valueOf(choice);
		}
		else {
			printBug();
			askProject(allowedVariants);
		}
	}

	private void askAfterProject(int[] intSwitch) {
		String choice = in.enter();
		if (InputChecker.checkNumber(intSwitch, choice)){
			choiceTo = Integer.valueOf(choice);
		}
		else {
			printBug();
			askAfterProject(intSwitch);
		}
	}

	private void askHowMuchPay(int[] intSwitch) {
		String choice = in.enter();
		if (InputChecker.checkNumber(intSwitch, choice)){
			chosenPay = Integer.valueOf(choice);
		}
		else {
			printBug();
			askHowMuchPay(intSwitch);
		}
	}
	
	private void inAmount() {
		String choice = in.enter();
		if (InputChecker.checkAmount(choice)){
			chosenPay = Integer.valueOf(choice);
		}
		else {
			printBug();
			inAmount();
		}
	}

	private void inCardNumber(long cardNumber){
		String choice = in.enter();
		if (InputChecker.checkCard(choice)){
			cardNumber = Long.valueOf(choice);
		}
		else {
			printBug();
			inCardNumber(cardNumber);
		}
	}
	
	private void askName(String name) {
		String choice = in.enter();
		if (InputChecker.checkName(choice)){
			name = choice;
		}
		else {			
			printBug();
			askName(name);
		}
	}
	
	private void printBug() {
		out.print("You have entered an incorrect value or a null value, check the value you entered and try again");		
	}
	
	private void askQuestion() {
		projects.addFAQ(chosenProject - 1, in.enter());
	}
	
	private void printProjectsInCategory() {
		printer("Your chosen category: "
				+ categories.showCatecoryName(chosenCategoryID)
				+ ", containing the following projects: ");
		printer(categories.showAllProjectInCategory(chosenCategoryID, projects));
		printer("Choice Project Number or " + menuCategories
				+ " for exit to Category: ");
	}
	
	private void printProject() {
		printer(projects.showProjectFull(chosenProject - 1));
		printer("Choice "
				+ menuProjects
				+ " for exit to Project list.\nChoice "
				+ menuPayment
				+ " to invest in the project:"
				+ "Have a question? If the info above doesn't help, you can ask the project creator directly - Choice "
				+ menuQuestion + ":");
	}

	private void printChoicePayment() {
		printer("\"0\" - No thanks, I just want to help the project."
				+ " \"1\" - 1$ = OUR UNDYING LOVE"
				+ " \"2\" - 10$ = HEY… NICE SHIRT"
				+ " \"3\" - 40$ = KICKSTARTER EXCLUSIVE");
	}
	
	private void printAskAmount() {
		printer("Enter the amount of donations:");
	}

	private void printAskCard() {
		printer("Enter your credit card number:");
	}

	private void printAskName() {
		printer("Enter your name:");
	}

	private void printAskQuestion() {
		printer("Enter your question:");
	}
	
	private void printThank(String name, int chosenPay) {
		printer("Thank you " + name + " for your generous (" + chosenPay + ") contribution.");
	}

	private void printer(String string) {
		out.print(string);
	}

	private Boolean elementInArray(int[] a, int b) {
		Boolean c = false;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == b) {
				c = true;
				break;
			}
		}
		return c;
	}

	private int[] concatArray(int[] a, int[] b) {
		if (a == null)
			return b;
		if (b == null)
			return a;
		int[] r = new int[a.length + b.length];
		System.arraycopy(a, 0, r, 0, a.length);
		System.arraycopy(b, 0, r, a.length, b.length);
		return r;
	}
}