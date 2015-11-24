package com.kickstarter.dao;

import com.kickstarter.dao.interfaces.CategoryDaoType;
import com.kickstarter.dao.interfaces.DbCategoryDaoImpl;

public class CategoryDao extends CategoryDaoType {
	
public CategoryDao() {
		
	 categoryDaoInterface = new DbCategoryDaoImpl();
	}

}
