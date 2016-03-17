package com.anmertrix;

import java.io.IOException;
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

	private IO io;
	private static final int EXIT = -1;
	protected static final String SOLID_LINE = "─────────────────────────────────────────";
	public static ManagementSystem ms = new ManagementSystem();
	String readEnv = System.getenv("READ_OBJECT_KICKSTARTER");

	public Kickstarter(IO io) {
		this.io = io;
	}

	public static void main(String[] args) throws IOException {
		new Kickstarter(new ConsoleIO()).run();
	}

	private void run() throws IOException {
		
		if (readEnv.isEmpty()) {
			io.println("Add environment variable READ_OBJECT_KICKSTARTER.");
			return;
		}
		
		io.println("Read data: " + readEnv);
		
		QuoteDao quoteDao = initQuoteDao();
		quoteDao.fillQuotes();
		CategoryDao categoryDao = initCategoryDao();
		categoryDao.fillCategory();
		ProjectDao projectDao = initProjectDao(categoryDao);
		io.println(quoteDao.getRandomQuote());

		while (true) {
			io.println(categoryDao.getCategoriesMenu());
			int numberCategory = numberCategory(categoryDao);

			while (true) {
				io.println(projectDao.getProjectList(numberCategory));
				io.println(SOLID_LINE);
				int numberProject = 0;
				numberProject = getParseInputNumber(io.readConsole());
				if (numberProject == EXIT) {
					break;
				} else {
					io.println("You select: " + projectDao.getInfoSelectedProject(numberCategory, numberProject));
					int numberMenuItem = getNumberMenuItem(projectDao);
					
					Category category = categoryDao.getCategory(numberCategory);
					List<Project> projects = category.getProjects();
					Project project = projects.get(numberProject);
					if (numberMenuItem == EXIT) {
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
	}

	public int getParseInputNumber(String text) {
		int result = 0;
		try {
			result = Integer.parseInt(text);
		} catch (NumberFormatException e) {
			io.println("You can enter only numbers. \"" + text + "\" is not a number.\n ");
		}
		return result - 1;
	}
	
    private QuoteDao initQuoteDao() {
    	QuoteDao quoteDao = null;
    	if (readEnv.equals("file")) {
			quoteDao = new QuoteDaoFile();
		} else if (readEnv.equals("memory")) {
			quoteDao = new QuoteDaoMemory();
		} else if (readEnv.equals("sql")) {
			quoteDao = new QuoteDaoSql();
		}
    	return quoteDao;
    }
    
    private ProjectDao initProjectDao(CategoryDao categoryDao) {
    	ProjectDao projectDao = new ProjectDaoMemory(categoryDao);
		if (readEnv.equals("memory")) {
			projectDao = new ProjectDaoMemory(categoryDao);
			projectDao.fillCategory();
		} else if (readEnv.equals("sql")) {
			projectDao = new ProjectDaoSql(categoryDao);
			projectDao.fillCategory();
		}
    	return projectDao;
    }
    
    private CategoryDao initCategoryDao() {
    	CategoryDao categoryDao = null;
    	if (readEnv.equals("file")) {
    		categoryDao = new CategoryDaoFile();
		} else if (readEnv.equals("memory")) {
			categoryDao = new CategoryDaoMemory();
		} else if (readEnv.equals("sql")) {
			categoryDao = new CategoryDaoSql();
		}
    	return categoryDao;
    }
    
    private int numberCategory(CategoryDao categoryDao) {
    	int numberCategory = 0;
    	while (true) {
			numberCategory = getParseInputNumber(io.readConsole());
			if (numberCategory == -1) {
				throw new RuntimeException("Bye..!");
			} else {
				try {
					io.print("You select: ");
					io.println(categoryDao.getNameSelectedCategory(numberCategory));
					break;
				} catch (Exception e) {
					io.println("There is no such category!");
					continue;
				}
			}
    	}
		return numberCategory;
    }
    
    private boolean selectReward(Project project) {
    	io.println("Select one or enter 0 - to exit:  ");
		io.println("1 - 1$ - BIG THANK!");
		io.println("2 - 20$ - Solo supporter!");
		io.println("3 - 40$ - Calm supporter!");
		int numberCount = 0;
		numberCount = getParseInputNumber(io.readConsole());
		if (numberCount == -1) {
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
		if (amountNumber == -1) {
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
