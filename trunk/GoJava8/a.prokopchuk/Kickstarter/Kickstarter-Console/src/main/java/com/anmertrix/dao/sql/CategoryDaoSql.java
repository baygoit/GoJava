package com.anmertrix.dao.sql;


import com.anmertrix.ManagementSystem;
import com.anmertrix.dao.CategoryDao;

public class CategoryDaoSql extends CategoryDao {
	
	public void fillCategory() {
		
		try {
			categories = ManagementSystem.getInstance().getCategories();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
