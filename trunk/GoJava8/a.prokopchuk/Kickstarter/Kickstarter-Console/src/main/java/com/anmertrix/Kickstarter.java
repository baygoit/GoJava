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

	private static final String SQL_MODE = "sql";
	private static final String MEMORY_MODE = "memory";
	private static final String FILE_MODE = "file";
	private static final int EXIT_INPUT = -1;

	private static final String KICKSTARTER_MODE = "KICKSTARTER_MODE";
    protected static final String SOLID_LINE = "─────────────────────────────────────────";

	private IO io;
	private ConnectionManager connectionManager;
	private String mode;
	private CategoryDao categoryDao;
    private QuoteDao quoteDao;

	public Kickstarter(IO io) {
		this.io = io;
	}

	public static void main(String[] args) throws IOException {
		new Kickstarter(new ConsoleIO()).run();
	}

	private void run() throws IOException {
		
		initMode();
		initConnectionManager();
		initQuoteDao();
		initCategoryDao();
		ProjectDao projectDao = initProjectDao(categoryDao);
		
		io.println(quoteDao.getRandomQuote());

		int numberCategory = 0;
		while (numberCategory != EXIT_INPUT) {
			io.println(categoryDao.getCategoriesMenu());
			numberCategory = numberCategory(categoryDao);

			while (numberCategory != EXIT_INPUT) {
				io.println(projectDao.getProjectList(numberCategory));
				io.println(SOLID_LINE);
				int numberProject = 0;
				numberProject = getParseInputNumber(io.readConsole());
				if (numberProject == EXIT_INPUT) {
					break;
				} else {
					io.println("You select: " + projectDao.getInfoSelectedProject(numberCategory, numberProject));
					int numberMenuItem = getNumberMenuItem(projectDao);
					
					Category category = categoryDao.getCategory(numberCategory);
					List<Project> projects = category.getProjects();
					Project project = projects.get(numberProject);
					if (numberMenuItem == EXIT_INPUT) {
						break;
					} else if (numberMenuItem == 0) {
						selectQuestion(project);
						continue;
					} else if (numberMenuItem == 1) {
						if (selectInvest(project)) {
							break;
						}
						continue;
					} else if (numberMenuItem == 2) {
						if (selectReward(project)) {
							break;
						}
						continue;
					} else if (numberMenuItem == 3) {
						continue;
					}
				}
				io.println("Enter 0 to see all projects.");
				int number = getParseInputNumber(io.readConsole());
				if (number == 0) {
					continue;
				}
			}
		}

		destroyConnectionManager();
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

	private void initMode() {
		mode = System.getenv(KICKSTARTER_MODE);
		// TODO Add more info about supported modes
		// TODO Add more checks
		if (mode == null || mode.isEmpty()) {
			throw new IllegalStateException("Environment variable " + KICKSTARTER_MODE + " is not found not empty.");
		}
		
		System.err.println("Mode is " + mode);
	}

	public int getParseInputNumber(String text) {
		int result = 0;

		try {
			result = (Integer.parseInt(text));
		} catch (NumberFormatException e) {
			io.println("You can enter only numbers. \"" + text
					+ "\" is not a number.\n ");
		}

		return result - 1;
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
    
    private ProjectDao initProjectDao(CategoryDao categoryDao) {
    	ProjectDao projectDao = new ProjectDaoMemory(categoryDao);
		if (MEMORY_MODE.equals(mode)) {
			projectDao = new ProjectDaoMemory(categoryDao);
			projectDao.fillCategory();
		} else if (SQL_MODE.equals(mode)) {
			projectDao = new ProjectDaoSql(connectionManager, categoryDao);
			projectDao.fillCategory();
		}
    	return projectDao;
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
		int numberCategory = EXIT_INPUT;
		do {
			numberCategory = getParseInputNumber(io.readConsole());
			if (numberCategory != EXIT_INPUT) {
				try {
					io.print("You select: ");
					io.println(categoryDao.getNameSelectedCategory(numberCategory));
					break;
				} catch (Exception e) {
					io.println("There is no such category!");
					continue;
				}
			}
		} while (numberCategory != EXIT_INPUT);
		return numberCategory;
    }
    
    private boolean selectReward(Project project) {
    	io.println("Select one or enter 0 - to exit:  ");
		io.println("1 - 1$ - BIG THANK!");
		io.println("2 - 20$ - Solo supporter!");
		io.println("3 - 40$ - Calm supporter!");
		int numberCount = 0;
		numberCount = getParseInputNumber(io.readConsole());
		if (numberCount == EXIT_INPUT) {
			return true;
		} else if (numberCount == 0) {
			project.setGatheredBudget(1);
		} else if (numberCount == 1) {
			project.setGatheredBudget(10);
		} else if (numberCount == 2) {
			project.setGatheredBudget(40);
		}
		io.println(SOLID_LINE);
		
		return false;
    }
    
    private boolean selectInvest(Project project) {
    	io.println("Enter your amount of money to invest or enter 0 - to exit:  ");
		int amountNumber = 0;
		amountNumber = getParseInputNumber(io.readConsole());
		if (amountNumber == EXIT_INPUT) {
			return true;
		} 
		project.setGatheredBudget(amountNumber + 1);
		io.println(SOLID_LINE);
		
		return false;
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
