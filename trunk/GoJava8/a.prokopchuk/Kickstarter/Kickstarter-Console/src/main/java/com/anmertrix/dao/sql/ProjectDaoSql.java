package com.anmertrix.dao.sql;

import com.anmertrix.ManagementSystem;
import com.anmertrix.dao.CategoryDao;
import com.anmertrix.dao.ProjectDao;

public class ProjectDaoSql  extends ProjectDao  {

	public ProjectDaoSql(CategoryDao categoryDao) {
		super(categoryDao);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fillCategory() {
		try {
			ManagementSystem.getInstance().getProjects(categoryDao);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
