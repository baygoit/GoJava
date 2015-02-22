package ua.com.goit.gojava.kickstarter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class InDBCategory implements Category {
	private int id;
	private Connection c;

	public InDBCategory(Connection c,int i) {
		id=i;
		this.c = c;
	}

	@Override
	public String getName() {
		ResultSet rs;
		String name="";
		try{
			Statement stmt = c.createStatement();
			rs = stmt.executeQuery( "SELECT name FROM category WHERE id="+id+";" );
			while(rs.next()){
			name = rs.getString("name");
			}
			stmt.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return name;
	}

	@Override
	public List<String> getProjectCatalog() {
		List<String> list = new LinkedList<>();
		try{
		Statement stmt = c.createStatement();
		ResultSet rs = stmt.executeQuery( "SELECT name FROM project WHERE category_id="+id+";" );
		while(rs.next()){
			list.add(rs.getString("name"));
		}
		}catch(SQLException e){
			throw new RuntimeException("operation not complite");
		}
		return list;
	}

	@Override
	public Project getProject(int i) throws IlligalInputException {
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
