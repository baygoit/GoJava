package edu.kickstarter.DAO;

import edu.kickstarter.DAO.category.CategoryService;
import edu.kickstarter.DAO.category.DBcategoryServiceImpl;
import edu.kickstarter.DAO.category.DefaultCategoryServiceImpl;
import edu.kickstarter.DAO.quote.DBquoteService;
import edu.kickstarter.DAO.quote.DefaultQuoteServiceImpl;
import edu.kickstarter.DAO.quote.QuoteService;
import edu.kickstarter.database.DatabaseService;

public class Dao  {
	private volatile static Dao uniqueInstance;
	private static DatabaseService databaseService;
	private static CategoryService categoryService;
	private static QuoteService quoteService;
	public static DatabaseService getDatabaseService() {
		return databaseService;
	}

	public static  CategoryService getCategoryService() {
		return categoryService;
	}

	public  static QuoteService getQuoteService() {
		return quoteService;
	}

	private Dao() {
	}
	public  static Dao getInstance() {
		if (uniqueInstance == null) {
			synchronized (Dao.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new Dao();
					databaseService = DatabaseService.getInstance();
					if (databaseService.getConnection() == null) {
						categoryService = new DefaultCategoryServiceImpl();
						quoteService = new DefaultQuoteServiceImpl();
					} else {
						categoryService = new DBcategoryServiceImpl();
						quoteService = new DBquoteService();
					}
				}
			}
		}
		return uniqueInstance;
	}
}
