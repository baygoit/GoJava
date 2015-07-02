package com.ivanpozharskyi.kickstarter.entity;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface Categories {
	void addCategory(String name) throws SQLException;
	Category getCategory(int id) throws SQLException;
	int getSize() throws SQLException;
	List<Category> getAll() throws SQLException; 				
}
