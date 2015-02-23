package ua.com.goit.gojava.kickstarter.in_database_storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import ua.com.goit.gojava.kickstarter.Category;
import ua.com.goit.gojava.kickstarter.CategoryCatalog;
import ua.com.goit.gojava.kickstarter.exceptions.IlligalInputException;

public class InDBCatalog implements CategoryCatalog {
	Connection c;
	private int size = 0;

	public InDBCatalog() {
		size=0;
		Statement stmt=null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/kickstarter", "postgres",
					"admin");
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT COUNT(*) FROM category;" );
			while(rs.next()){
				size=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void addCategory(String name) {
		Statement stmt=null;
		try{
		stmt = c.createStatement();
		String sql = "INSERT INTO category (name) "
		       + "VALUES ('"+name+"');";
		 stmt.executeUpdate(sql);
		 size++;
		}catch(SQLException e){
			throw new RuntimeException("operation not complite");
		}finally{
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

	}

	@Override
	public List<String> getCatalog() {
		List<String> list = new LinkedList<>();
		Statement stmt = null;
		try{
		stmt = c.createStatement();
		ResultSet rs = stmt.executeQuery( "SELECT name FROM category;" );
		while(rs.next()){
			list.add(rs.getString("name"));
		}
		}catch(SQLException e){
			throw new RuntimeException("operation not complite");
		}finally{
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public Category getCategory(int i) {
		if(i>size) throw new IlligalInputException();
		return new InDBCategory(c,i);
	}

	@Override
	public int size() {
		return size;
	}

}
