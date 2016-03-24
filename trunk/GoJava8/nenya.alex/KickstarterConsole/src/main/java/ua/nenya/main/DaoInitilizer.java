package ua.nenya.main;

import ua.nenya.dao.CategoryDao;
import ua.nenya.dao.QuoteDao;
import ua.nenya.dao.db.CategoryDaoDbImpl;
import ua.nenya.dao.db.QuoteDaoDbImpl;
import ua.nenya.dao.file.CategoryDaoFileImpl;
import ua.nenya.dao.file.QuoteDaoFileImpl;
import ua.nenya.dao.memory.CategoryDaoMemoryImpl;
import ua.nenya.dao.memory.QuoteDaoMemoryImpl;
import ua.nenya.util.ConnectionManager;

public class DaoInitilizer {
	private ConnectionManager connectionManager = new ConnectionManager();
	private QuoteDao quoteDao;
	private CategoryDao categoryDao;

	private enum DaoMode {
		MEMORY("memory"), FILE("file"), DB("db");
		private String name;

		DaoMode(String name) {
			this.name = name;
		}
	}

	public void initDao(String switcher) {
		if (DaoMode.DB.name.equalsIgnoreCase(switcher)) {
			System.err.println("FromDB");

			quoteDao = new QuoteDaoDbImpl(connectionManager);
			quoteDao.initQuotes();

			categoryDao = new CategoryDaoDbImpl(connectionManager);

		} else {
			if (DaoMode.FILE.name.equalsIgnoreCase(switcher)) {
				System.err.println("FromFile");

				quoteDao = new QuoteDaoFileImpl();
				quoteDao.initQuotes();

				categoryDao = new CategoryDaoFileImpl();

			} else {
				System.err.println("FromMemory");

				quoteDao = new QuoteDaoMemoryImpl();
				quoteDao.initQuotes();

				categoryDao = new CategoryDaoMemoryImpl();

			}
		}
	}

	public QuoteDao getQuoteDao() {
		return quoteDao;
	}

	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

	public void setQuoteDao(QuoteDao quoteDao) {
		this.quoteDao = quoteDao;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

}
