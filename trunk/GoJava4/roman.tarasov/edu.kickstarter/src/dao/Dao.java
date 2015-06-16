package dao;

import dao.category.CategoryService;
import dao.category.DBcategoryServiceImpl;
import dao.category.DefaultCategoryServiceImpl;
import dao.comments.CommentService;
import dao.comments.DBcommentServiceImpl;
import dao.comments.DefaultCommentServiceImpl;
import dao.project.DBprojectServiceImpl;
import dao.project.DefaultProjectServiceImpl;
import dao.project.ProjectService;
import dao.quote.DBquoteService;
import dao.quote.DefaultQuoteServiceImpl;
import dao.quote.QuoteService;
import database.DatabaseService;
import database.KickstarterException;

public class Dao {
	private volatile static Dao uniqueInstance;
	private static DatabaseService databaseService;
	private static CategoryService categoryService;
	private static QuoteService quoteService;
	private static ProjectService projectService;
	private static CommentService commentService;

	public static CommentService getCommentService() {
		return commentService;
	}

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
						commentService = new DBcommentServiceImpl();

					} catch (KickstarterException e) {
						categoryService = new DefaultCategoryServiceImpl();
						quoteService = new DefaultQuoteServiceImpl();
						projectService = new DefaultProjectServiceImpl();
						commentService = new DefaultCommentServiceImpl();
					}
				}
			}
		}
		return uniqueInstance;
	}
}
