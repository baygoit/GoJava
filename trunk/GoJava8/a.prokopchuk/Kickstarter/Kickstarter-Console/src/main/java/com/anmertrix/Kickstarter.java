package com.anmertrix;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.anmertrix.dao.CategoryDao;
import com.anmertrix.dao.QuoteDao;
import com.anmertrix.dao.file.CategoryDaoFile;
import com.anmertrix.dao.file.QuoteDaoFile;
import com.anmertrix.dao.memory.CategoryDaoMemory;
import com.anmertrix.dao.memory.QuoteDaoMemory;
import com.anmertrix.dao.sql.CategoryDaoSql;
import com.anmertrix.dao.sql.QuoteDaoSql;
import com.anmertrix.domain.Category;
import com.anmertrix.domain.Project;
import com.anmertrix.domain.Quote;

public class Kickstarter {

	private static final String SQL_MODE = "SQL";
	private static final String MEMORY_MODE = "MEMORY";
	private static final String FILE_MODE = "FILE";
	private static final int EXIT_INPUT = 0;

	protected static final String HEADER = "                    ***  KICKSTARTER   ***   ";
    protected static final String SOLID_LINE = "─────────────────────────────────────────";

	private IO io;
	private ConnectionManager connectionManager;
	private String mode;
	private QuoteDao quoteDao;
	private CategoryDao categoryDao;
    private int selectedMenuItemCategory;

	public Kickstarter(IO io) {
		this.io = io;
	}

	public static void main(String[] args) throws IOException {
		new Kickstarter(new ConsoleIO()).run();
	}

	private void run() throws IOException {
		
		mode = DaoSwitch.getMode();
		initConnectionManager();
		initQuoteDao();
		initCategoryDao();
		showHeader();

		selectedMenuItemCategory = -1;
		while (selectedMenuItemCategory != EXIT_INPUT) {
			showCategoriesMenu();
			while (selectedMenuItemCategory != EXIT_INPUT) {
				io.print(showProjects());
				int numberProject = getParseInputNumber(io.readConsole());
				if (numberProject == EXIT_INPUT) {
					break;
				} else {
					io.println(SOLID_LINE);
					io.println(showSelectedProject(numberProject));
					int numberMenuItem = getNumberMenuItem();
					List<Project> projects = categoryDao.getProjectsByCategoryId(selectedMenuItemCategory);
					Project project = projects.get(numberProject - 1);
					if (numberMenuItem == EXIT_INPUT) {
						break;
					} else if (numberMenuItem == 1) {
						selectQuestion(project);
					} else if (numberMenuItem == 2) {
						selectInvest(project);
					} else if (numberMenuItem == 3) {
						selectReward(project);
					}
					io.println(SOLID_LINE);
					continue;
				}
			}
		}
		destroyConnectionManager();
	}

	private void showCategoriesMenu() {
		io.println(SOLID_LINE);
		List<Category> categories = categoryDao.getCategories();
		
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < categories.size(); i++) {
			result.append(i + 1).append(" - ")
					.append(categories.get(i).getName()).append("    ");
		}
		result.append("0 - EXIT");
		result.append("\n \n");
		result.append("Please, select category...");
		io.print(result.toString());
		selectedMenuItemCategory = numberCategory();
	}

	private void showHeader() {
		io.println(HEADER);
		io.println(getQuoteText());
	}
	
	public String showProjects() {
		StringBuilder result = new StringBuilder();
		List<Project> projects = categoryDao.getProjectsByCategoryId(selectedMenuItemCategory);
		for (int i = 0; i < projects.size(); i++) {
			Project project = projects.get(i);
			result.append(i + 1).append(" - ").append(project.getName() + "\n");
		}
		result.append("0 - EXIT \n")
			.append("\n")
			.append("Please, select project...");
		return result.toString().trim();
	}

	public String showSelectedProject(int idProject) {
		List<Project> projects = categoryDao.getProjectsByCategoryId(selectedMenuItemCategory);
		Project project = projects.get(idProject - 1);

		StringBuilder result = new StringBuilder();
		result.append(project.getName() + "\n")
				.append(SOLID_LINE + "\n")
				.append("Description: " + project.getDescription() + "\n")
				.append("Required budget: " + project.getRequiredBudget()
						+ "\n")
				.append("Gathered budget: " + project.getGatheredBudget()
						+ "\n")
				.append("Days left: " + project.getDaysLeft() + "\n")
				.append("History: " + project.getHistory() + "\n")
				.append("Video URL: " + project.getURL() + "\n")
				.append("Question and answer: \n" + project.getQuestionAnswer());
		return result.toString();
	}

	public String getProjectMenu() {
		StringBuilder result = new StringBuilder();
		result.append("1 - Ask a question").append("    ")
				.append("2 - Invest project").append("    ")
				.append("3 - Rewards").append("    ")
				.append("4 - Exit to categories menu").append("    ")
				.append("0 - EXIT")
				.append("\n \n")
				.append("Please, select menu item...");

		return result.toString().trim();
	}

	private void destroyConnectionManager() {
		if (connectionManager != null) {
			try {
				connectionManager.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
	private void initConnectionManager() {
		if (SQL_MODE.equals(mode)) {
			connectionManager = new ConnectionManager();
		}
	}

	public int getParseInputNumber(String text) {
		int result = 0;
		try {
			result = (Integer.parseInt(text));
		} catch (NumberFormatException e) {
			io.println("You can enter only numbers. \"" + text + "\" is not a number.\n ");
		}

		return result;
	}
	
	public String getQuoteText() {
		Quote quote = quoteDao.getRandomQuote();
		return quote.getQuoteText() + " (" + quote.getAuthor() + ")";
	}

    private void initQuoteDao() {
		if (FILE_MODE.equals(mode)) {
			this.quoteDao = new QuoteDaoFile();
		} else if (MEMORY_MODE.equals(mode)) {
			this.quoteDao = new QuoteDaoMemory();
		} else if (SQL_MODE.equals(mode)) {
			this.quoteDao = new QuoteDaoSql(connectionManager);
		}
    }
    
    private void initCategoryDao() {
		if (FILE_MODE.equals(mode)) {
    		this.categoryDao = new CategoryDaoFile();
		} else if (MEMORY_MODE.equals(mode)) {
			this.categoryDao = new CategoryDaoMemory();
		} else if (SQL_MODE.equals(mode)) {
			this.categoryDao = new CategoryDaoSql(connectionManager);
		}
    }
    
    private int numberCategory() {
		int categoryId = EXIT_INPUT;
		do {
			categoryId = getParseInputNumber(io.readConsole());
			if (categoryId != EXIT_INPUT) {
				try {
					io.println(SOLID_LINE);
					io.println(categoryDao.getCategory(categoryId).getName());
					io.println(SOLID_LINE);
					break;
				} catch (Exception e) {
					io.println("There is no such category!");
					continue;
				}
			}
		} while (categoryId != EXIT_INPUT);
		return categoryId;
    }
    
    private void selectReward(Project project) {
    	io.println(SOLID_LINE);
    	io.println("Rewards");
    	io.println(SOLID_LINE);
		io.println("1 - 1$ - BIG THANK!");
		io.println("2 - 20$ - Solo supporter!");
		io.println("3 - 40$ - Calm supporter!");
		io.println("0 - EXIT");
		io.print("Please, select menu item...");
		int numberCount = getParseInputNumber(io.readConsole());
		if (numberCount == 1) {
			project.setGatheredBudget(1);
		} else if (numberCount == 2) {
			project.setGatheredBudget(10);
		} else if (numberCount == 3) {
			project.setGatheredBudget(40);
		}
    }
    
    private void selectInvest(Project project) {
    	io.println(SOLID_LINE);
    	io.println("Invest project");
    	io.println(SOLID_LINE);
    	io.println("Enter your amount of money to invest or enter 0 - to exit:  ");
		int amountNumber = 0;
		amountNumber = getParseInputNumber(io.readConsole());
		if (amountNumber == EXIT_INPUT) {
			return;
		} 
		project.setGatheredBudget(amountNumber);
    }
    
    private void selectQuestion(Project project) {
    	io.print("Enter your guestion: ");
		String guestion = io.readConsole();
		project.setQuestion(guestion);
    }
    
    private int getNumberMenuItem() {
		io.println(SOLID_LINE);
		io.print(getProjectMenu());
		return getParseInputNumber(io.readConsole());
    }

}
