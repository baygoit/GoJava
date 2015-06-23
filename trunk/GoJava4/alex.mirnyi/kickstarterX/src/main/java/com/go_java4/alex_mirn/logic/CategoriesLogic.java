package com.go_java4.alex_mirn.logic;

import java.util.List;
import java.io.IOException;
import java.sql.SQLException;

import com.go_java4.alex_mirn.dao.Dao;
import com.go_java4.alex_mirn.data.Category;
import com.go_java4.alex_mirn.logic.Logic;

public class CategoriesLogic implements Logic{
	private Dao repository;


	public CategoriesLogic(Dao repository) {
		this.repository = repository;
	}
	
	public int getSize() throws SQLException {
		return repository.getCategoriesSize();
	}

	public String getIndex(int index1) throws SQLException {
		String index = repository.getCategoriesIndex(index1).toString();
		return index;
	}
	
	public String getQuote() throws SQLException {
		String quote = repository.getRandomQuote().toString();
		return quote;
	}

	public List<Category> getAll() throws SQLException {
		List<Category> categories = repository.getAll();
		return categories;
	}

}

