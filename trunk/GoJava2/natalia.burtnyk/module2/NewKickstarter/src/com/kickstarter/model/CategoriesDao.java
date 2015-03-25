package com.kickstarter.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoriesDao implements Categories {
	static {
		try {
			Class.forName("org.postgresql.Driver");	
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Something is wrong with driver downloads");
		}
	}
	
	 private Connection connection;
	
	public CategoriesDao () {
		try {
		connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DataForKickstarter",
				"postgres", "Berezhnoi");
		} catch (SQLException e) {
			throw new RuntimeException("Something wrong with connection. ",e);
		}
		
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
					category = new Сategory (resultSet.getString("name"));
					result.add(category);
				}
			} catch (Exception e) {
			} finally {
				if(connection != null) {
					try {
						connection.close();
						statement.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
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
				category = new Сategory(resultSet.getString("name"));
			}
		} catch (Exception e) {
		} finally {
			if(connection != null) {
				try {
					connection.close();
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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
		} finally {
			if(connection != null) {
				try {
					connection.close();
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result.size();
	}
}