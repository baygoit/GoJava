package ua.com.goit.gojava7.kickstarter.console;

import ua.com.goit.gojava7.kickstarter.Kickstarter;
import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.MenuOptions;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.model.User;
import ua.com.goit.gojava7.kickstarter.payment.CreditCardSystem;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.storage.ProjectManager;

public class Menu{
	private static final int	MENU_EXIT_OPTION						= 0;
	private static final int	MENU_DEFAULT_OPTION						= -1;
	private static final String	PLEASE_SELECT							= "Please select";
	private static final String	PROJECT									= " project";
	private static final String	CATEGORY								= " category";
	private static final String	O_FOR_EXIT								= " (0 to go back): ";
	private static final String	YOU_SELECTED_PROJECT					= "You selected project: ";
	private static final String	YOU_SELECTED_CATEGORY_NUMBER			= "You selected category number ";
	private static final String	PLEASE_ENTER_THE_NUMBER_BETWEEN_1_AND	= "Please, enter the number between 1 and ";
	private User				user;
	private ConsolePrinter		consolePrinter;
	private ConsoleScanner		consoleScanner;
	private Kickstarter			kickstarter;

	public Menu(Kickstarter kickstarter, User u) {
		this.user = u;
		this.kickstarter = kickstarter;
		this.consolePrinter = kickstarter.getConsolePrinter();
		this.consoleScanner = kickstarter.getConsoleScanner();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void showMenu() {
		switch (user.getSettings().getMenuOption()) {
			case SHOW_MAIN_MENU :
				chooseCategory();
				break;
			case SHOW_CATEGORIES :
				chooseCategory();
				break;
			case SHOW_PROJECTS_IN_SPECIFIC_CATEGORY :
				chooseProject();
				break;
			case SHOW_SPECIFIC_PROJECT :
				showFullProjectInfo();
				break;
			case DONATE_TO_PROJECT :
				donateToProject();
				break;
			case ADD_PAYMENT_SYSTEM_TO_ACCOUNT :
				addPaymentSystem();
				break;
			case EXIT :
				consolePrinter.print("Exiting menu");
				break;
			default :
				break;
		}
	}

	public double enterAmount() {
		consolePrinter.print("Please enter amount you want to contribute: ");
		return consoleScanner.getInt();
	}

	private void addPaymentSystem() {
		consolePrinter.print("Please add card holder name: ");
		String name = consoleScanner.getString();
		consolePrinter.print("Please add card number: ");
		int cardnumber = consoleScanner.getInt();

		CreditCardSystem userPaymentSystem = new CreditCardSystem();
		userPaymentSystem.setCardNumber(cardnumber);
		userPaymentSystem.setHolderName(name);
		ProjectManager projectManager = kickstarter.getProjectManager();
		if (projectManager.userContributeToProject(user, enterAmount())) {
			consolePrinter.print("Payment done.");
			user.getSettings()
					.setMenuOption(MenuOptions.SHOW_SPECIFIC_PROJECT);

		}

		showMenu();
	}

	public void donateToProject() {
		if (user.getPaymentSystem() == null) {
			user.getSettings()
					.setMenuOption(MenuOptions.ADD_PAYMENT_SYSTEM_TO_ACCOUNT);
			consolePrinter.print(
					"You don't have any payment system. Add new one please");
		} 

		showMenu();
	}

	public void showFullProjectInfo() {
		consolePrinter
				.printFullProjectInfo(user.getSettings().getSelectedProject());
		int selectedOption = MENU_DEFAULT_OPTION;
		while (selectedOption == MENU_DEFAULT_OPTION) {
			consolePrinter.print("Do you want to donate: (1) - Yes (0) - No");
			selectedOption = consoleScanner.getInt();
			if (selectedOption == 1) {
				user.getSettings()
						.setMenuOption(MenuOptions.DONATE_TO_PROJECT);

			}
			if (selectedOption == 0) {
				user.getSettings().setMenuOption(
						MenuOptions.SHOW_PROJECTS_IN_SPECIFIC_CATEGORY);
			}
		}
		showMenu();
	}

	public void chooseCategory() {
		int selectedCategory = MENU_DEFAULT_OPTION;
		while (selectedCategory == MENU_DEFAULT_OPTION) {
			CategoryStorage categoryStorage = kickstarter.getCategoryStorage();
			consolePrinter.print(categoryStorage.getCategories());
			consolePrinter.print(PLEASE_SELECT + CATEGORY + O_FOR_EXIT);
			selectedCategory = consoleScanner.getInt();

			if (selectedCategory < MENU_EXIT_OPTION
					|| selectedCategory > categoryStorage.size()) {
				consolePrinter.print(PLEASE_ENTER_THE_NUMBER_BETWEEN_1_AND
						+ categoryStorage.size());
				continue;
			} else if (selectedCategory != MENU_EXIT_OPTION) {
				consolePrinter
						.print(YOU_SELECTED_CATEGORY_NUMBER + selectedCategory);
				user.getSettings().setCategory(
						categoryStorage.getCategoryById(selectedCategory));
				user.getSettings().setMenuOption(
						MenuOptions.SHOW_PROJECTS_IN_SPECIFIC_CATEGORY);

			} else {
				user.getSettings().setMenuOption(MenuOptions.EXIT);
				consolePrinter.printHorizontalLine();
			}
			showMenu();
		}
	}

	public void chooseProject() {
		int selectedOption = MENU_DEFAULT_OPTION;
		ProjectManager projectManager = kickstarter.getProjectManager();
		Category category = user.getSettings().getCategory();
		do {
			consolePrinter.print("Projects in category "
					+ user.getSettings().getCategory().getCategoryName());
			consolePrinter.showProjectList(user.getSettings().getCategory(),
					projectManager);
			consolePrinter.print(PLEASE_SELECT + PROJECT + O_FOR_EXIT);
			selectedOption = consoleScanner.getInt();

			if (selectedOption < MENU_EXIT_OPTION || selectedOption > projectManager
					.getProjectsByCategory(category).size()) {
				consolePrinter.print(PLEASE_ENTER_THE_NUMBER_BETWEEN_1_AND
						+ kickstarter.getCategoryStorage().size() + 1);
				continue;
			} else if (selectedOption != 0) {
				Project selectedProject = projectManager
						.getProjectsByCategory(category)
						.get(selectedOption - 1);
				consolePrinter.print(YOU_SELECTED_PROJECT
						+ selectedProject.getProjectName());
				user.getSettings().setSelectedProject(selectedProject);
				user.getSettings()
						.setMenuOption(MenuOptions.SHOW_SPECIFIC_PROJECT);
			} else {
				user.getSettings().setMenuOption(MenuOptions.SHOW_CATEGORIES);
				consolePrinter.print("Exit [Choose Project]");
				consolePrinter.printHorizontalLine();
			}
		} while (selectedOption == MENU_DEFAULT_OPTION);
		showMenu();
	}

}
