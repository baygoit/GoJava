package ua.com.goit.gojava.kickstarter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class InDBCatalog implements CategoryCatalog {
	Connection c;
	private int size = 0;

	public InDBCatalog() {
		size=0;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/kickstarter", "postgres",
					"admin");
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT COUNT(*) FROM category;" );
			while(rs.next()){
				size=rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Connetcion error");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Driver not found");
		}
	}

	@Override
	public void addCategory(String name) {
		try{
		Statement stmt = c.createStatement();
		String sql = "INSERT INTO category (name) "
		       + "VALUES ('"+name+"');";
		 stmt.executeUpdate(sql);
		 stmt.close();
		 size++;
		}catch(SQLException e){
			throw new RuntimeException("operation not complite");
		}finally{
			
		}

	}

	@Override
	public List<String> getCatalog() {
		List<String> list = new LinkedList<>();
		try{
		Statement stmt = c.createStatement();
		ResultSet rs = stmt.executeQuery( "SELECT name FROM category;" );
		while(rs.next()){
			list.add(rs.getString("name"));
		}
		}catch(SQLException e){
			throw new RuntimeException("operation not complite");
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
