package com.anmertrix;

//import java.sql.SQLException;

import com.anmertrix.dao.CategoryDao;
import com.anmertrix.dao.QuoteDao;
import com.anmertrix.dao.sql.CategoryDaoSql;
import com.anmertrix.dao.sql.QuoteDaoSql;

public class Kickstarter {
	
	private ConnectionManager connectionManager;
	private QuoteDao quoteDao;
	private CategoryDao categoryDao;

	public Kickstarter() {
		connectionManager = new ConnectionManager();
		initDao();
	}
	
	private void initDao() {
		this.quoteDao = new QuoteDaoSql(connectionManager);
		this.categoryDao = new CategoryDaoSql(connectionManager);
    }
	
	public QuoteDao getQuoteDao() {
		return quoteDao;
	}
	
	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

}
