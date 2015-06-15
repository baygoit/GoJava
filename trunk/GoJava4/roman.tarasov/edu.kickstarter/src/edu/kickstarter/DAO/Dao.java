package edu.kickstarter.DAO;

import edu.kickstarter.DAO.category.CategoryService;
import edu.kickstarter.DAO.category.DBcategoryServiceImpl;
import edu.kickstarter.DAO.category.DefaultCategoryServiceImpl;
import edu.kickstarter.DAO.project.DBprojectServiceImpl;
import edu.kickstarter.DAO.project.DefaultProjectServiceImpl;
import edu.kickstarter.DAO.project.ProjectService;
import edu.kickstarter.DAO.quote.DBquoteService;
import edu.kickstarter.DAO.quote.DefaultQuoteServiceImpl;
import edu.kickstarter.DAO.quote.QuoteService;
import edu.kickstarter.database.DatabaseService;
import edu.kickstarter.database.KickstarterException;

public class Dao {
	private volatile static Dao uniqueInstance;
	private static DatabaseService databaseService;
	private static CategoryService categoryService;
	private static QuoteService quoteService;
	private static ProjectService projectService;

	public static ProjectService getProjectService() {
		return projectService;
	}

	public static DatabaseService getDatabaseService() {
		return databaseService;
	}

	public static CategoryService getCategoryService() {
		return categoryService;
	}

	public static QuoteService getQuoteService() {
		return quoteService;
	}

	private Dao() {
	}

	public static Dao getInstance() {
		if (uniqueInstance == null) {
			synchronized (Dao.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new Dao();
					databaseService = DatabaseService.getInstance();
					try {
						databaseService.getConnection();
						categoryService = new DBcategoryServiceImpl();
						quoteService = new DBquoteService();
						projectService = new DBprojectServiceImpl();
						// quoteService = new DefaultQuoteServiceImpl();
						// categoryService = new DefaultCategoryServiceImpl();
						// projectService=new DBprojectServiceImpl();

					} catch (KickstarterException e) {
						categoryService = new DefaultCategoryServiceImpl();
						quoteService = new DefaultQuoteServiceImpl();
						projectService = new DefaultProjectServiceImpl();
					}
				}
			}
		}
		return uniqueInstance;
	}
}
