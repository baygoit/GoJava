package ua.com.goit.gojava7.kickstarter.console;

import ua.com.goit.gojava7.kickstarter.dao.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.dao.storage.ProjectStorage;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.MenuOptions;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.User;
import ua.com.goit.gojava7.kickstarter.payment.CreditCardSystem;

public class Menu{
	private static final int[]	DONATE_OPTIONS							= {0, 1, 10, 40};
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
	private ProjectStorage		projectStorage;
	private CategoryStorage		categoryStorage;

	public Menu(User u, ProjectStorage projectManager, CategoryStorage categoryStorage) {
		this.user = u;
		this.setProjectManager(projectManager);
		this.categoryStorage = categoryStorage;
	}

	public CategoryStorage getCategoryStorage() {
		return categoryStorage;
	}

	public void setCategoryStorage(CategoryStorage categoryStorage) {
		this.categoryStorage = categoryStorage;
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
				showDonateInfo();
				break;
			case ADD_PAYMENT_SYSTEM_TO_ACCOUNT :
				addPaymentSystem();
				break;
			case ASK_QUESTION :
				askQuestion();
				break;
			case EXIT :
				ConsolePrinter.print("Exiting menu");
				break;
			default :
				break;
		}
	}

	public String getQuestion() {
		ConsolePrinter.print("Enter your question: ");
		return ConsoleScanner.getString();
	}

	public void askQuestion() {

		user.getSettings().getSelectedProject().getQuestionsAndAnswers().put(getQuestion(), "");
		user.getSettings().setMenuOption(MenuOptions.SHOW_SPECIFIC_PROJECT);
		showMenu();

	}

	public double enterAmount() {
		ConsolePrinter.print("Please enter amount you want to contribute: ");
		return ConsoleScanner.getInt();
	}

	public void donateMoney(int option) {
		if (isPaymentOption(option)) {
			projectStorage.userContributeToProject(user, Double.valueOf(DONATE_OPTIONS[option]), user.getSettings().getSelectedProject().getProjectName());
			ConsolePrinter.print("Payment of " + DONATE_OPTIONS[option] + "$ is done.");
			user.getSettings().setMenuOption(MenuOptions.SHOW_SPECIFIC_PROJECT);
		} else {
			double enterAmount = enterAmount();
			projectStorage.userContributeToProject(user, enterAmount, user.getSettings().getSelectedProject().getProjectName());
			ConsolePrinter.print("Payment of " + enterAmount + "$ is done.");
			user.getSettings().setMenuOption(MenuOptions.SHOW_SPECIFIC_PROJECT);

		}
	}

	private void addPaymentSystem() {
		ConsolePrinter.print("Please add card holder name: ");
		String name = ConsoleScanner.getString();

		ConsolePrinter.print("Please add card number: ");
		int cardnumber = ConsoleScanner.getInt();

		CreditCardSystem userPaymentSystem = new CreditCardSystem();
		userPaymentSystem.setCardNumber(cardnumber);
		userPaymentSystem.setHolderName(name);
		user.setPaymentSystem(userPaymentSystem);
		user.getSettings().setMenuOption(MenuOptions.DONATE_TO_PROJECT);

		showMenu();
	}

	public void donateToProject(int option) {
		if (isPaymentOption(option)) {
			donateMoney(DONATE_OPTIONS[option]);
		} else {
			donateMoney(0);
		}
		showMenu();
	}

	public static boolean isPaymentOption(int option) {
		return option > 0 && option < 4;
	}

	public void showFullProjectInfo() {
		ConsolePrinter.printFullProjectInfo(user.getSettings().getSelectedProject(), categoryStorage);
		int selectedOption = MENU_DEFAULT_OPTION;
		while (selectedOption == MENU_DEFAULT_OPTION) {
			ConsolePrinter.print("(2) - Ask question (1) - Donate (0) - Go back");
			selectedOption = ConsoleScanner.getInt();
			if (selectedOption == 2) {
				user.getSettings().setMenuOption(MenuOptions.ASK_QUESTION);

			} else if (selectedOption == 1) {
				if (user.getPaymentSystem() == null) {
					user.getSettings().setMenuOption(MenuOptions.ADD_PAYMENT_SYSTEM_TO_ACCOUNT);
				} else {
					user.getSettings().setMenuOption(MenuOptions.DONATE_TO_PROJECT);

				}

			} else if (selectedOption == 0) {
				user.getSettings().setMenuOption(MenuOptions.SHOW_PROJECTS_IN_SPECIFIC_CATEGORY);
			}

		}
		showMenu();
	}

	public void showDonateInfo() {
		int selectedOption = MENU_DEFAULT_OPTION;
		while (selectedOption == MENU_DEFAULT_OPTION) {
			ConsolePrinter.printHorizontalLine();
			ConsolePrinter.print("Donate options:");
			ConsolePrinter.print("(1) - 1$, (2) - 10$, (3) - 40$");
			ConsolePrinter.print("(4) - Enter your own amount (0) - Go Back");
			selectedOption = ConsoleScanner.getInt();
			if (isPaymentOption(selectedOption)) {
				user.getSettings().setMenuOption(MenuOptions.DONATE_TO_PROJECT);
				donateMoney(selectedOption);

			} else if (selectedOption == 4) {
				user.getSettings().setMenuOption(MenuOptions.DONATE_TO_PROJECT);
				donateMoney(selectedOption);

			}
			if (selectedOption == 0) {
				user.getSettings().setMenuOption(MenuOptions.SHOW_PROJECTS_IN_SPECIFIC_CATEGORY);
			}
		}
		showMenu();
	}

	public void chooseCategory() {
		int selectedCategory = MENU_DEFAULT_OPTION;
		while (selectedCategory == MENU_DEFAULT_OPTION) {

			ConsolePrinter.print(categoryStorage.getAll());
			ConsolePrinter.print(PLEASE_SELECT + CATEGORY + O_FOR_EXIT);
			selectedCategory = ConsoleScanner.getInt();

			if (selectedCategory < MENU_EXIT_OPTION || selectedCategory > categoryStorage.size()) {
				ConsolePrinter.print(PLEASE_ENTER_THE_NUMBER_BETWEEN_1_AND + categoryStorage.size());
				continue;
			} else if (selectedCategory != MENU_EXIT_OPTION) {
				ConsolePrinter.print(YOU_SELECTED_CATEGORY_NUMBER + selectedCategory);
				user.getSettings().setCategory(categoryStorage.getCategoryById(selectedCategory));
				user.getSettings().setMenuOption(MenuOptions.SHOW_PROJECTS_IN_SPECIFIC_CATEGORY);

			} else {
				user.getSettings().setMenuOption(MenuOptions.EXIT);
				ConsolePrinter.printHorizontalLine();
			}
			showMenu();
		}
	}

	public void chooseProject() {
		int selectedOption = MENU_DEFAULT_OPTION;
		Category category = user.getSettings().getCategory();
		do {
			ConsolePrinter.print("Projects in category " + user.getSettings().getCategory().getCategoryName());
			ConsolePrinter.showProjectList(user.getSettings().getCategory(), projectStorage);
			ConsolePrinter.print(PLEASE_SELECT + PROJECT + O_FOR_EXIT);
			selectedOption = ConsoleScanner.getInt();

			if (selectedOption < MENU_EXIT_OPTION
					|| selectedOption > projectStorage.getByCategory(category.getCategoryName()).size()) {
				ConsolePrinter.print(PLEASE_ENTER_THE_NUMBER_BETWEEN_1_AND + getCategoryStorage().size() + 1);
				continue;
			} else if (selectedOption != 0) {
				Project selectedProject = projectStorage.getByCategory(category.getCategoryName())
						.get(selectedOption - 1);
				ConsolePrinter.print(YOU_SELECTED_PROJECT + selectedProject.getProjectName());
				user.getSettings().setSelectedProject(selectedProject);
				user.getSettings().setMenuOption(MenuOptions.SHOW_SPECIFIC_PROJECT);
			} else {
				user.getSettings().setMenuOption(MenuOptions.SHOW_CATEGORIES);
				ConsolePrinter.print("Exit [Choose Project]");
				ConsolePrinter.printHorizontalLine();
			}
		} while (selectedOption == MENU_DEFAULT_OPTION);
		showMenu();
	}

	public ProjectStorage getProjectManager() {
		return projectStorage;
	}

	public void setProjectManager(ProjectStorage projectManager) {
		this.projectStorage = projectManager;
	}

}
