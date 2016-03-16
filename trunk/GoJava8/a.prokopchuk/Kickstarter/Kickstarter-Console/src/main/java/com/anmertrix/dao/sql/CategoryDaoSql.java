package com.anmertrix.dao.sql;


import com.anmertrix.Kickstarter;
import com.anmertrix.dao.CategoryDao;

public class CategoryDaoSql extends CategoryDao {
	
	public void fillCategory() {
		
		try {
			categories = Kickstarter.ms.getInstance().getCategories();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
