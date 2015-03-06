package ua.com.goit.gojava2.vova.kickstarter.presenter;

import ua.com.goit.gojava2.vova.kickstarter.model.Categories;
import ua.com.goit.gojava2.vova.kickstarter.model.Projects;
import ua.com.goit.gojava2.vova.kickstarter.util.InputChecker;
import ua.com.goit.gojava2.vova.kickstarter.view.Inputs;
import ua.com.goit.gojava2.vova.kickstarter.view.View;


public class Presenter {
	private MenuStatus menuStatus = new MenuStatus();
	private int menu = menuStatus.getMenuCategories();
	private int choiceTo;//TODO DELETE
	private int chosenPay;//TODO DELETE
	private int chosenCategoryID;//TODO DELETE
	private int chosenProject;//TODO DELETE

    private Inputs in;
	private Categories categories;
	private Projects projects;
	private View view;

	public Presenter(Inputs in, Categories categories, Projects projects, View view) {
		this.in = in;
		this.categories = categories;
		this.projects = projects;
		this.view = view;
	}

	public void kickstarter(){

		projects.setProjects();//TODO DELETE
		
		categories();
		view.printClose();
	}

	private void categories() {
		view.showAllCategories(categories.getCategories());
		askCategory();
		
		menu = menuStatus.getMenuProjects();
		switchMenu();
	}

	private void projects() {
		int[] optionVariant = { menuStatus.getMenuCategories() };
		printProjectsInCategory(chosenCategoryID, menuStatus.getMenuCategories());

		askProject(optionVariant);

		if (elementInArray(optionVariant, chosenProject)) {
			menu = menuStatus.getMenuCategories();
			switchMenu();
		}

		menu = menuStatus.getMenuProject();
		switchMenu();
	}

	private void project() {
		int[] optionVariant = { menuStatus.getMenuProjects(), menuStatus.getMenuPayment(), menuStatus.getMenuQuestion(), menuStatus.getExit() };

		view.printProject(projects.getProjects().get(chosenProject - 1));
				
		view.printChoiceProjectOrPaymentOrQuestion(menuStatus.getMenuProjects(), menuStatus.getMenuPayment(), menuStatus.getMenuQuestion());
		askAfterProject(optionVariant);

		if (menuStatus.getExit() == choiceTo){
			return;
		}
		
		if (elementInArray(optionVariant, choiceTo)) {
			menu = choiceTo;
			switchMenu();
		}
	}

	private void payment() {
		int[] optionVariant = { 0, 1, 2, 3 };

		view.printChoicePayment();
		askHowMuchPay(optionVariant);

		view.printAskName();
		String name = "";
		askName(name);

		view.printAskCard();
		long cardNumber = 0;
		inCardNumber(cardNumber);

		
		if (chosenPay == 0) {
			view.printAskAmount();
			inAmount();
		}

		projects.setDonation(chosenProject, chosenPay);
		
		view.printThank(name, chosenPay);
		
		menu = menuStatus.getMenuProject();
		switchMenu();
	}

	private void question() {
		view.printAskQuestion();
		askQuestion();

		menu = menuStatus.getMenuProject();
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

	private void askCategory() {
		String choice = in.enter();
		if (InputChecker.checkNumber(categories.getKickCategories(), choice)){
			chosenCategoryID = Integer.valueOf(choice);
		}
		else {
			view.printBug();
			askCategory();
		}
	}
	
	private void printProjectsInCategory(int chosenCategoryID, int menuCategories) {
		view.printYourChosenCategory(categories.showCatecoryName(chosenCategoryID));
		view.printShortProgect(projects.getProjects(), projects.projectsThatAreContainedInTheCategory(chosenCategoryID));
		view.printChoiceProjectNumber(menuCategories);
	}

	private void askProject(int[] allowedVariants) {
		int[] concatProjectsAndVariants = concatArray(projects.projectsThatAreContainedInTheCategory(chosenCategoryID), allowedVariants);
		String choice = in.enter();
		if (InputChecker.checkNumber(concatProjectsAndVariants, choice)){
			chosenProject = Integer.valueOf(choice);
		}
		else {
			view.printBug();
			askProject(allowedVariants);
		}
	}

	private void askAfterProject(int[] intSwitch) {
		String choice = in.enter();
		if (InputChecker.checkNumber(intSwitch, choice)){
			choiceTo = Integer.valueOf(choice);
		}
		else {
			view.printBug();
			askAfterProject(intSwitch);
		}
	}

	private void askHowMuchPay(int[] intSwitch) {
		String choice = in.enter();
		if (InputChecker.checkNumber(intSwitch, choice)){
			chosenPay = Integer.valueOf(choice);
		}
		else {
			view.printBug();
			askHowMuchPay(intSwitch);
		}
	}
	
	private void inAmount() {
		String choice = in.enter();
		if (InputChecker.checkAmount(choice)){
			chosenPay = Integer.valueOf(choice);
		}
		else {
			view.printBug();
			inAmount();
		}
	}

	private void inCardNumber(long cardNumber){
		String choice = in.enter();
		if (InputChecker.checkCard(choice)){
			cardNumber = Long.valueOf(choice);
		}
		else {
			view.printBug();
			inCardNumber(cardNumber);
		}
	}
	
	private void askName(String name) {
		String choice = in.enter();
		if (InputChecker.checkName(choice)){
			name = choice;
		}
		else {			
			view.printBug();
			askName(name);
		}
	}
	
	private void askQuestion() {
		projects.addFAQ(chosenProject, in.enter());
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