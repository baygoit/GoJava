package com.goit.kickstarter.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.goit.kickstarter.model.Category;

public class CategoryDAO {
	private String user = "postgres";
	private String password = "123";
	private String url = "jdbc:postgresql://localhost:5433/kickstarterdb";
	
	private Connection connection;

	public CategoryDAO(Connection connection) {
		this.connection = connection;
	}
	
	static{
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}	
	
	public Category getCategory(int id) {
		Category cat = null;
		try {
			String query = "SELECT categories.category_name "
					+ "FROM categories WHERE id =?";
			
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				cat = new Category(rs.getString("category_name"));
			}
			
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cat;
	}

	public void createCategory(Category category) {
		try {
			String query = "INSERT into categories(category_name)"
					+"VALUES(?);";
			
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, category.getTitle());
			
			stmt.executeUpdate();	
			stmt.close();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateCategory(Category category) {
		try {
			String query = "UPDATE categories SET category_name=? "
					+ "WHERE category_name=?";
			
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, category.getTitle());
			
			stmt.executeUpdate();	
			stmt.close();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteCategory(String title) {
		try {
			String query = "DELETE FROM categories WHERE category_name=?";
			
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, title);
			
			stmt.executeUpdate();	
			stmt.close();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password); 
	} 

	public int getLength() {
		int count=0;
		try {			 
			String query = "SELECT * FROM categories";
			
			PreparedStatement stmt = connection.prepareStatement(query);
						
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				count++;
			}
			stmt.close();
		} catch (SQLException e) { 
			e.printStackTrace(); 
		} 
		return count;
	}
	
	public List<Category> getCategories() {
		List<Category> list = new ArrayList<Category>();
		try {			 
			String query = "SELECT * FROM categories";
			
			PreparedStatement stmt = connection.prepareStatement(query);
						
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				list.add(new Category(rs.getString("category_name"), rs.getInt("id")));
			}
			stmt.close();
		} catch (SQLException e) { 
			e.printStackTrace(); 
		} 
		return list;
	}
}
