package com.anmertrix;

import java.sql.SQLException;

import com.anmertrix.dao.CategoryDao;
import com.anmertrix.dao.QuoteDao;
import com.anmertrix.dao.file.CategoryDaoFile;
import com.anmertrix.dao.file.QuoteDaoFile;
import com.anmertrix.dao.memory.CategoryDaoMemory;
import com.anmertrix.dao.memory.QuoteDaoMemory;
import com.anmertrix.dao.sql.CategoryDaoSql;
import com.anmertrix.dao.sql.QuoteDaoSql;

public class ViewPage {
	
	private static final String SQL_MODE = "SQL";
	private static final String MEMORY_MODE = "MEMORY";
	private static final String FILE_MODE = "FILE";
	
	private ConnectionManager connectionManager;
    public QuoteDao quoteDao;
	public CategoryDao categoryDao;
	
	private boolean isExit = false;
	private int selectedMenuItemCategory;
	private int selectedMenuItemProject;
	private String mode;

	public ViewPage() {
		mode = DaoSwitch.getMode();
		initConnectionManager();
		initQuoteDao();
		initCategoryDao();
	}
	
	private void initQuoteDao() {
		if (FILE_MODE.equals(mode)) {
			this.quoteDao = new QuoteDaoFile();
		} else if (MEMORY_MODE.equals(mode)) {
			this.quoteDao = new QuoteDaoMemory();
		} else if (SQL_MODE.equals(mode)) {
			this.quoteDao = new QuoteDaoSql(connectionManager);
		}
    }
    
    private void initCategoryDao() {
		if (FILE_MODE.equals(mode)) {
    		this.categoryDao = new CategoryDaoFile();
		} else if (MEMORY_MODE.equals(mode)) {
			this.categoryDao = new CategoryDaoMemory();
		} else if (SQL_MODE.equals(mode)) {
			this.categoryDao = new CategoryDaoSql(connectionManager);
		}
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
	
	private void initConnectionManager() {
		if (SQL_MODE.equals(mode)) {
			connectionManager = new ConnectionManager();
		}
	}

	public boolean isExit() {
		return isExit;
	}

	public void setExit(boolean isExit) {
		this.isExit = isExit;
		destroyConnectionManager();
	}

	public int getSelectedMenuItemCategory() {
		return selectedMenuItemCategory;
	}

	public void setSelectedMenuItemCategory(int selectedMenuItemCategory) {
		this.selectedMenuItemCategory = selectedMenuItemCategory;
	}
	
	public int getSelectedMenuItemProject() {
		return selectedMenuItemProject;
	}

	public void setSelectedMenuItemProject(int selectedMenuItemProject) {
		this.selectedMenuItemProject = selectedMenuItemProject;
	}
	
	public QuoteDao getQuoteDao() {
		return quoteDao;
	}
	
	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

}
