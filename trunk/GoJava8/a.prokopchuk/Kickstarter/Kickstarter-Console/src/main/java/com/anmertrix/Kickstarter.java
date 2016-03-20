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
		
		mode = DaoSwitch.getMode();
		initConnectionManager();
		initQuoteDao();
		initCategoryDao();
		ProjectDao projectDao = initProjectDao(categoryDao);
		
		io.println(quoteDao.getRandomQuote());

		int numberCategory = -1;
		while (numberCategory != EXIT_INPUT) {
			io.println(categoryDao.getCategoriesMenu());
			numberCategory = numberCategory(categoryDao);

			while (numberCategory != EXIT_INPUT) {
				io.println(projectDao.getProjectList(numberCategory - 1));
				io.println(SOLID_LINE);
				int numberProject = getParseInputNumber(io.readConsole());
				if (numberProject == EXIT_INPUT) {
					break;
				} else {
					io.println("You select: " + projectDao.getInfoSelectedProject(numberCategory - 1, numberProject - 1));
					int numberMenuItem = getNumberMenuItem(projectDao);
					
					Category category = categoryDao.getCategory(numberCategory - 1);
					List<Project> projects = category.getProjects();
					Project project = projects.get(numberProject - 1);
					if (numberMenuItem == EXIT_INPUT) {
						break;
					} else if (numberMenuItem == 1) {
						selectQuestion(project);
						continue;
					} else if (numberMenuItem == 2) {
						if (selectInvest(project)) {
							break;
						}
						continue;
					} else if (numberMenuItem == 3) {
						if (selectReward(project)) {
							break;
						}
						continue;
					} else if (numberMenuItem == 4) {
						continue;
					}
				}
				io.println("Enter 0 to see all projects.");
				int number = getParseInputNumber(io.readConsole());
				if (number == EXIT_INPUT) {
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
		int categoryId = EXIT_INPUT;
		do {
			categoryId = getParseInputNumber(io.readConsole());
			if (categoryId != EXIT_INPUT) {
				try {
					io.println("You select: " + categoryDao.getNameSelectedCategory(categoryId - 1));
					break;
				} catch (Exception e) {
					io.println("There is no such category!");
					continue;
				}
			}
		} while (categoryId != EXIT_INPUT);
		return categoryId;
    }
    
    private boolean selectReward(Project project) {
    	io.println("Select one or enter 0 - to exit:  ");
		io.println("1 - 1$ - BIG THANK!");
		io.println("2 - 20$ - Solo supporter!");
		io.println("3 - 40$ - Calm supporter!");
		int numberCount = getParseInputNumber(io.readConsole());
		if (numberCount == EXIT_INPUT) {
			return true;
		} else if (numberCount == 1) {
			project.setGatheredBudget(1);
		} else if (numberCount == 2) {
			project.setGatheredBudget(10);
		} else if (numberCount == 3) {
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
		project.setGatheredBudget(amountNumber);
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
