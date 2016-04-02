package com.anmertrix.page;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.anmertrix.ConnectionManager;
import com.anmertrix.dao.CategoryDao;
import com.anmertrix.dao.QuoteDao;
import com.anmertrix.dao.sql.CategoryDaoSql;
import com.anmertrix.dao.sql.QuoteDaoSql;

public abstract class Page extends HttpServlet {
	
 	private static final long serialVersionUID = 1L;
 	
	private ConnectionManager connectionManager;
	protected QuoteDao quoteDao;
	protected CategoryDao categoryDao;
	
	public void init() throws ServletException {
		connectionManager = new ConnectionManager();
		this.quoteDao = new QuoteDaoSql(connectionManager);
		this.categoryDao = new CategoryDaoSql(connectionManager);
	}

}
