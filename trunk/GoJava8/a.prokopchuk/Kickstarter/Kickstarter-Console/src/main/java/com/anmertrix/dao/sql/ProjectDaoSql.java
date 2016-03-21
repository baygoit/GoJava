package com.anmertrix.dao.sql;

import com.anmertrix.ConnectionManager;
import com.anmertrix.dao.CategoryDao;
import com.anmertrix.dao.ProjectDao;

public class ProjectDaoSql  extends ProjectDao  {

	private ConnectionManager connectionManager;

	public ProjectDaoSql(ConnectionManager connectionManager, CategoryDao categoryDao) {
		super(categoryDao);
		this.connectionManager = connectionManager;
	}

	@Override
	public void fillCategory() {
		connectionManager.getProjects(categoryDao);
	}
	
	
}
