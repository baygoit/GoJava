package com.anmertrix;

//import java.sql.SQLException;

import com.anmertrix.dao.CategoryDao;
import com.anmertrix.dao.QuoteDao;
import com.anmertrix.dao.file.CategoryDaoFile;
import com.anmertrix.dao.file.QuoteDaoFile;
import com.anmertrix.dao.memory.CategoryDaoMemory;
import com.anmertrix.dao.memory.QuoteDaoMemory;
import com.anmertrix.dao.sql.CategoryDaoSql;
import com.anmertrix.dao.sql.QuoteDaoSql;

public class Kickstarter {
	
	private static final String SQL_MODE = "SQL";
	private static final String MEMORY_MODE = "MEMORY";
	private static final String FILE_MODE = "FILE";
	
	private ConnectionManager connectionManager;
	private QuoteDao quoteDao;
	private CategoryDao categoryDao;
	private String mode;

	public Kickstarter() {
		mode = DaoSwitch.getMode();
		initConnectionManager();
		initDao();
	}
	
	private void initDao() {
		if (FILE_MODE.equals(mode)) {
			this.quoteDao = new QuoteDaoFile();
			this.categoryDao = new CategoryDaoFile();
		} else if (MEMORY_MODE.equals(mode)) {
			this.quoteDao = new QuoteDaoMemory();
			this.categoryDao = new CategoryDaoMemory();
		} else if (SQL_MODE.equals(mode)) {
			this.quoteDao = new QuoteDaoSql(connectionManager);
			this.categoryDao = new CategoryDaoSql(connectionManager);
		}
    }
/*
	private void destroyConnectionManager() {
		if (connectionManager != null) {
			try {
				connectionManager.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	*/
	private void initConnectionManager() {
		if (SQL_MODE.equals(mode)) {
			connectionManager = new ConnectionManager();
		}
	}
	
	public QuoteDao getQuoteDao() {
		return quoteDao;
	}
	
	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

}
