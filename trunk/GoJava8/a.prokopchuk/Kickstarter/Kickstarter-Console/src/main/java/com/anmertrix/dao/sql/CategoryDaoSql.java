package com.anmertrix.dao.sql;


import com.anmertrix.ConnectionManager;
import com.anmertrix.dao.CategoryDao;

public class CategoryDaoSql extends CategoryDao {

	private ConnectionManager connectionManager;

	public CategoryDaoSql(ConnectionManager connectionManager) {
		this.connectionManager = connectionManager;
	}

	public void fillCategory() {
		categories = connectionManager.getCategories();
	}
}
