package ua.com.goit.gojava7.kickstarter.console;

import ua.com.goit.gojava7.kickstarter.UserManager;
import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.MENU_OPTIONS;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.model.User;
import ua.com.goit.gojava7.kickstarter.model.UserSettings;
import ua.com.goit.gojava7.kickstarter.payment.CreditCardSystem;
import ua.com.goit.gojava7.kickstarter.payment.PaymentSystem;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.storage.ProjectManager;

public class Menu {
	private static final String PLEASE_SELECT = "Please select";
	private static final String PROJECT = " project";
	private static final String CATEGORY = " category";
	private static final String O_FOR_EXIT = " (0 to go back): ";
	private static final String YOU_SELECTED_PROJECT = "You selected project: ";
	private static final String YOU_SELECTED_CATEGORY_NUMBER = "You selected category number ";
	private static final String PLEASE_ENTER_THE_NUMBER_BETWEEN_1_AND = "Please, enter the number between 1 and ";
	private UserManager userManager;
	private User user;
	private ConsolePrinter consolePrinter;
	private ConsoleScanner consoleScanner;
	public Menu(UserManager userManager, User u) {
		this.setUserManager(userManager);
		this.user = u;
		this.consolePrinter = userManager.getConsolePrinter();
		this.consoleScanner = userManager.getConsoleScanner();
		showMenu();
	}

	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	
	
	
	
	public void showMenu(){
		switch (user.getSettings().getMenuOption()) {
		case SHOW_MAIN_MENU:
			chooseCategory();
			break;
		case SHOW_CATEGORIES:
			chooseCategory();
			break;
		case SHOW_PROJECTS_IN_SPECIFIC_CATEGORY:
			chooseProject();
			break;
		case SHOW_SPECIFIC_PROJECT:
			showFullProjectInfo();
			break;
		case DONATE_TO_PROJECT:
			donateToProject();
			break;
		case ADD_PAYMENT_SYSTEM_TO_ACCOUNT:
			addPaymentSystem();
			break;
		case EXIT:
			consolePrinter.print("Exiting menu");
			break;
		default:
			break;
		}
	}
	public double enterAmount(){
		consolePrinter.print("Please enter amount you want to contribute: ");
		return consoleScanner.getInt();
	}
	private void addPaymentSystem() {
		String name;
		int cardnumber;
		consolePrinter.print("Please add card holder name: ");
		name = consoleScanner.getString();
		consolePrinter.print("Please add card number: ");
		cardnumber = consoleScanner.getInt();
		
		
		
		CreditCardSystem userPaymentSystem = new CreditCardSystem();
		userPaymentSystem.setCardNumber(cardnumber);
		userPaymentSystem.setHolderName(name);
		ProjectManager projectManager = userManager.getKickStarter().getProjectManager();
		if(projectManager.userContributeToProject(user.getSettings().getSelectedProject(), user, enterAmount())){
			consolePrinter.print("Payment done.");
			user.getSettings().setMenuOption(MENU_OPTIONS.SHOW_SPECIFIC_PROJECT);
			
		}
		
		showMenu();
	}

	public void donateToProject(){
		if(user.getPaymentSystem() == null){
			user.getSettings().setMenuOption(MENU_OPTIONS.ADD_PAYMENT_SYSTEM_TO_ACCOUNT);
			consolePrinter.print("You don't have any payment system. Add new one please");
		}else{
			
		}
		
		showMenu();
	}

	public void showFullProjectInfo(){
		consolePrinter.printFullProjectInfo(user.getSettings().getSelectedProject());
		int selectedOption = -1;
		while(selectedOption == -1){
			consolePrinter.print("Do you want to donate: (1) - Yes (0) - No");
			selectedOption = consoleScanner.getInt();
			if(selectedOption == 1){
				user.getSettings().setMenuOption(MENU_OPTIONS.DONATE_TO_PROJECT);
				
			}
			if(selectedOption == 0){
				user.getSettings().setMenuOption(MENU_OPTIONS.SHOW_PROJECTS_IN_SPECIFIC_CATEGORY);
			}
		}
		showMenu();
	}
		
	public void chooseCategory() {
		int selectedCategory = -1;
		while (selectedCategory == -1) {
			CategoryStorage categoryStorage = userManager.getCategoryStorage();
			consolePrinter.print(categoryStorage.getCategories());
			consolePrinter.print(PLEASE_SELECT + CATEGORY + O_FOR_EXIT);
			selectedCategory = consoleScanner.getInt();

			if (selectedCategory < 0 || selectedCategory > categoryStorage.size()) {
				consolePrinter.print(PLEASE_ENTER_THE_NUMBER_BETWEEN_1_AND + categoryStorage.size());
				continue;
			} else if (selectedCategory != 0) {
				consolePrinter.print(YOU_SELECTED_CATEGORY_NUMBER + selectedCategory );
				user.getSettings().setCategory(categoryStorage.getCategoryById(selectedCategory));
				user.getSettings().setMenuOption(MENU_OPTIONS.SHOW_PROJECTS_IN_SPECIFIC_CATEGORY);
				
			} else {
				user.getSettings().setMenuOption(MENU_OPTIONS.EXIT);
				consolePrinter.printDeflector();
			}
			showMenu();
	}
	}

	public void chooseProject() {
		int selectedOption = -1;
		ProjectManager projectManager = userManager.getKickStarter().getProjectManager();
		Category category = user.getSettings().getCategory();
		do {
			consolePrinter.print("Projects in category " + user.getSettings().getCategory().getCategoryName());
			consolePrinter.showProjectList(user.getSettings().getCategory(), projectManager);
			consolePrinter.print(PLEASE_SELECT + PROJECT + O_FOR_EXIT);
			selectedOption = consoleScanner.getInt();

			if (selectedOption < 0 || selectedOption > projectManager.getProjectsByCategory(category).size()) {
				consolePrinter.print(PLEASE_ENTER_THE_NUMBER_BETWEEN_1_AND + userManager.getCategoryStorage().size() + 1);
				continue;
			} else if (selectedOption != 0) {
				Project selectedProject = projectManager.getProjectsByCategory(category).get(selectedOption - 1);
				consolePrinter.print(YOU_SELECTED_PROJECT
						+ selectedProject.getProjectName());
				user.getSettings().setSelectedProject(selectedProject);
				user.getSettings().setMenuOption(MENU_OPTIONS.SHOW_SPECIFIC_PROJECT);
			} else {
				user.getSettings().setMenuOption(MENU_OPTIONS.SHOW_CATEGORIES);
				consolePrinter.print("Exit [Choose Project]");
				consolePrinter.printDeflector();
			}
		} while (selectedOption == -1);
		showMenu();
	}
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
