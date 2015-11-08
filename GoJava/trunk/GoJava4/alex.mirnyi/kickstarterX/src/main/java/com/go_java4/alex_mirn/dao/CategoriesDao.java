package com.go_java4.alex_mirn.dao;

import java.sql.SQLException;
import java.util.List;

import com.go_java4.alex_mirn.data.Category;

public interface CategoriesDao {
	void add(Category category) throws SQLException;
	
	Category getCategoriesIndex(int index) throws SQLException;
	
	int getCategoriesSize() throws SQLException;
	
	List<Category> getAll() throws SQLException;
}
