package com.kickstarter.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoriesDAO implements Categories {
	
	private Connection connection;
	
	public CategoriesDAO(Connection connection) {
		this.connection = connection;
	}	

	@Override
	public void add(Сategory category) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<Сategory> getCategories() {
			Сategory category;
			Statement statement = null;
			List <Сategory> result = null;
			
			try {
				statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM categories");
				result = new ArrayList<Сategory>();
				while (resultSet.next()) {
					category = new Сategory(resultSet.getInt("id"), resultSet.getString("name"));
					result.add(category);
				}
			} catch (Exception e) {
			} 
			return result;
		}

	@Override
	public Сategory get(int index) {
		Сategory category = null;
		Statement statement = null;
		
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM categories where id = " + index);
			while (resultSet.next()) {
				category = new Сategory(resultSet.getInt("id"), resultSet.getString("name"));
			}
		} catch (Exception e) {
		}
		return category;
	}

	@Override
	public int size() {
		Statement statement = null;
		List <Сategory> result = null;
		
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM categories");
			result = new ArrayList<Сategory>();
			while (resultSet.next()) {
				Сategory category = new Сategory (resultSet.getString("name"));
				result.add(category);
			}
		} catch (Exception e) {
		}
		return result.size();
	}
}