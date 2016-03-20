package com.anmertrix;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.anmertrix.dao.CategoryDao;
import com.anmertrix.dao.ProjectDao;
import com.anmertrix.dao.QuoteDao;
import com.anmertrix.dao.file.CategoryDaoFile;
import com.anmertrix.dao.file.QuoteDaoFile;
import com.anmertrix.dao.memory.CategoryDaoMemory;
import com.anmertrix.dao.memory.ProjectDaoMemory;
import com.anmertrix.dao.memory.QuoteDaoMemory;
import com.anmertrix.dao.sql.CategoryDaoSql;
import com.anmertrix.dao.sql.ProjectDaoSql;
import com.anmertrix.dao.sql.QuoteDaoSql;

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
    private ProjectDao projectDao;
    private int inputMenuItem;

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
		initProjectDao(categoryDao);
		showHeader();

		inputMenuItem = -1;
		while (inputMenuItem != EXIT_INPUT) {
			
			showCategoriesMenu();

			while (inputMenuItem != EXIT_INPUT) {
				io.print(projectDao.getProjectList(inputMenuItem - 1));
				int numberProject = getParseInputNumber(io.readConsole());
				if (numberProject == EXIT_INPUT) {
					break;
				} else {
					io.println(SOLID_LINE);
					io.println(projectDao.getInfoSelectedProject(inputMenuItem - 1, numberProject - 1));
					int numberMenuItem = getNumberMenuItem(projectDao);
					
					Category category = categoryDao.getCategory(inputMenuItem - 1);
					List<Project> projects = category.getProjects();
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
					continue;
				}
			}
		}
		destroyConnectionManager();
	}

	private void showCategoriesMenu() {
		io.println(SOLID_LINE);
		io.print(categoryDao.getCategoriesMenu());
		inputMenuItem = numberCategory(categoryDao);
	}

	private void showHeader() {
		io.println(HEADER);
		io.println(quoteDao.getRandomQuote());
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

	public int getParseInputNumber(String text) {
		int result = 0;
		try {
			result = (Integer.parseInt(text));
		} catch (NumberFormatException e) {
			io.println("You can enter only numbers. \"" + text + "\" is not a number.\n ");
		}

		return result;
	}
	
	private void initConnectionManager() {
		if (SQL_MODE.equals(mode)) {
			connectionManager = new ConnectionManager();
		}
	}

    private void initQuoteDao() {
		if (FILE_MODE.equals(mode)) {
			this.quoteDao = new QuoteDaoFile();
		} else if (MEMORY_MODE.equals(mode)) {
			this.quoteDao = new QuoteDaoMemory();
		} else if (SQL_MODE.equals(mode)) {
			this.quoteDao = new QuoteDaoSql(connectionManager);
		}
		quoteDao.fillQuotes();
    }
    
    private void initProjectDao(CategoryDao categoryDao) {
		if (MEMORY_MODE.equals(mode)) {
			this.projectDao = new ProjectDaoMemory(categoryDao);
			projectDao.fillCategory();
		} else if (SQL_MODE.equals(mode)) {
			this.projectDao = new ProjectDaoSql(connectionManager, categoryDao);
			projectDao.fillCategory();
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
		categoryDao.fillCategory();
    }
    
    private int numberCategory(CategoryDao categoryDao) {
		int categoryId = EXIT_INPUT;
		do {
			categoryId = getParseInputNumber(io.readConsole());
			if (categoryId != EXIT_INPUT) {
				try {
					io.println(SOLID_LINE);
					io.println(categoryDao.getNameSelectedCategory(categoryId - 1));
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
		io.println(SOLID_LINE);
		
    }
    
    private void selectInvest(Project project) {
    	io.println(SOLID_LINE);
    	io.println("Invest project");
    	io.println(SOLID_LINE);
    	io.println("Enter your amount of money to invest or enter 0 - to exit:  ");
		int amountNumber = 0;
		amountNumber = getParseInputNumber(io.readConsole());
		if (amountNumber == EXIT_INPUT) {
			io.println(SOLID_LINE);
			return;
		} 
		project.setGatheredBudget(amountNumber);
		io.println(SOLID_LINE);
    }
    
    private void selectQuestion(Project project) {
    	io.print("Enter your guestion: ");
		String guestion = io.readConsole();
		project.setQuestion(guestion);
		io.println(SOLID_LINE);
    }
    
    private int getNumberMenuItem(ProjectDao projectDao) {
		io.println(SOLID_LINE);
		io.print(projectDao.getProjectMenu());
		
		return getParseInputNumber(io.readConsole());
    }

}
