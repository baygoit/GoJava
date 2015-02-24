package gojava.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import gojava.Interface.Category;

public class DAOCategory implements Category{
	private String categoryName;
	
	public DAOCategory(int i){
		Connection connection = null;
		int line=1;
		try {
			Class.forName("org.postgresql.Driver"); 
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/kickstarterdb", 
					"postgres",	"123");
			Statement stmt = connection.createStatement();
			String query = "select * from categories";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				if(line==i){
					categoryName=rs.getString("category_name");
					break;
				}
				line++;
			}
		} catch (SQLException | ClassNotFoundException e) { 
			e.printStackTrace(); 
		}
	}

	@Override
	public String showProjects() {
		if(getLength()==0){
			return "Empty!\n0 - Go back\n";
		}
		Connection connection = null;
		String result = "";
		int num =1;
		try {
			Class.forName("org.postgresql.Driver"); 
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/kickstarterdb", 
					"postgres",	"123");
			Statement stmt = connection.createStatement();
			String query = "select * from projects where category=\'"+categoryName+"\'";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()){
		        result+=num+ " - " + rs.getString("project_name")+"\n"+
		        	rs.getString("description")+"\n"+
		        	"Money needed: " + rs.getString("value")+ 
		        	"; Money collected: " + rs.getString("recieved") + "\n"+
		        	"Days left: " + rs.getString("days")+ "\n" +
		        	"--------------------------"+"\n";
		        num++;
			}
			connection.close();
		} catch (SQLException | ClassNotFoundException e) { 
			e.printStackTrace(); 
		}

		result+="0 - Go back\n";
		return result;
	}

	@Override
	public int getLength() {
		Connection connection = null;
		int count=0;
		try {			 
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5433/kickstarterdb", 
					"postgres",	"123"); 
			Statement st = connection.createStatement();
			String query = "select * from projects where category=\'"+categoryName+"\'";
			ResultSet rs = st.executeQuery(query);
			while(rs.next()){
				count++;
			}
			connection.close();
		} catch (ClassNotFoundException | SQLException e) { 
			e.printStackTrace(); 
		} 
		return count;
	}

	@Override
	public Object getTitle() {
		return categoryName;
	}

	@Override
	public Object getProject(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void addProject(String string) {
		// TODO Auto-generated method stub
		
	}
	
}
