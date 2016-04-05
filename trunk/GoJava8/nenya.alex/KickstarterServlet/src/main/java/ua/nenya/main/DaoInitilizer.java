package ua.nenya.main;

import ua.nenya.dao.CategoryDao;
import ua.nenya.dao.QuoteDao;
import ua.nenya.dao.db.CategoryDaoDbImpl;
import ua.nenya.dao.db.QuoteDaoDbImpl;
import ua.nenya.util.ConnectionManager;

public class DaoInitilizer {
	private ConnectionManager connectionManager = new ConnectionManager();
	private QuoteDao quoteDao;
	private CategoryDao categoryDao;

	public void initDao() {
		
			quoteDao = new QuoteDaoDbImpl(connectionManager);
			quoteDao.initQuotes();

			categoryDao = new CategoryDaoDbImpl(connectionManager);
		
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
