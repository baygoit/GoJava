package com.anmertrix.dao.sql;

import com.anmertrix.Kickstarter;
import com.anmertrix.dao.CategoryDao;
import com.anmertrix.dao.ProjectDao;

public class ProjectDaoSql  extends ProjectDao  {

	public ProjectDaoSql(CategoryDao categoryDao) {
		super(categoryDao);
	}

	@Override
	public void fillCategory() {
		try {
			Kickstarter.ms.getInstance().getProjects(categoryDao);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
