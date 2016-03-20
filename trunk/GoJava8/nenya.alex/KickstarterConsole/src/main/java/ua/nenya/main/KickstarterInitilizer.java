package ua.nenya.main;

import ua.nenya.dao.CategoryDao;
import ua.nenya.dao.QuoteDao;
import ua.nenya.dao.UserDao;
import ua.nenya.dao.db.CategoryDaoDbImpl;
import ua.nenya.dao.db.QuoteDaoDbImpl;
import ua.nenya.dao.db.UserDaoDbImpl;
import ua.nenya.dao.file.CategoryDaoFileImpl;
import ua.nenya.dao.file.QuoteDaoFileImpl;
import ua.nenya.dao.file.UserDaoFileImpl;
import ua.nenya.dao.memory.CategoryDaoMemoryImpl;
import ua.nenya.dao.memory.QuoteDaoMemoryImpl;
import ua.nenya.dao.memory.UserDaoMemoryImpl;
import ua.nenya.util.ConnectionManager;

public class KickstarterInitilizer {
	private ConnectionManager connectionManager = new ConnectionManager();
	private QuoteDao quoteDao;
	private UserDao userDao;
	private CategoryDao categoryDao;

	private enum DaoMode {
		MEMORY("memory"), FILE("file"), DB("db");
		private String name;

		DaoMode(String name) {
			this.name = name;
		}
	}

	public void initKickstarter(String switcher) {
		if (DaoMode.DB.name.equalsIgnoreCase(switcher)) {
			System.err.println("FromDB");

			quoteDao = new QuoteDaoDbImpl(connectionManager);
			quoteDao.initQuotes();

			userDao = new UserDaoDbImpl(connectionManager);
			userDao.initUsers();

			categoryDao = new CategoryDaoDbImpl(connectionManager);
			categoryDao.initCategories();

		} else {
			if (DaoMode.FILE.name.equalsIgnoreCase(switcher)) {
				System.err.println("FromFile");

				quoteDao = new QuoteDaoFileImpl();
				quoteDao.initQuotes();

				userDao = new UserDaoFileImpl();
				userDao.initUsers();

				categoryDao = new CategoryDaoFileImpl();
				categoryDao.initCategories();

			} else {
				System.err.println("FromMemory");

				quoteDao = new QuoteDaoMemoryImpl();
				quoteDao.initQuotes();

				userDao = new UserDaoMemoryImpl();
				userDao.initUsers();

				categoryDao = new CategoryDaoMemoryImpl();
				categoryDao.initCategories();

			}
		}
	}

	public QuoteDao getQuoteDao() {
		return quoteDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

	public void setQuoteDao(QuoteDao quoteDao) {
		this.quoteDao = quoteDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	
}
