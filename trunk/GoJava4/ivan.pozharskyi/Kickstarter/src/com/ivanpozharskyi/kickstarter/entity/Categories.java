package com.ivanpozharskyi.kickstarter.entity;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface Categories {
	void addCategory(Category category);
	Category getCategory(int id) throws SQLException;
	int getSize() throws SQLException;
	Set<Category> getAll() throws SQLException; 				
}
