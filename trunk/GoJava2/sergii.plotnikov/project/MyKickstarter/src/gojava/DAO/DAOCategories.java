package gojava.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import gojava.Interface.Categories;

public class DAOCategories implements Categories{

	@Override
	public String showCategories() {
		Connection connection = null;
		String result = "";
		int num =1;
		try {
			Class.forName("org.postgresql.Driver"); 
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/kickstarterdb", 
					"postgres",	"123");
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select category_name from categories");

			while (rs.next()){
		        result+=num+ " - " + rs.getString("category_name")+"\n";
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
			ResultSet rs = st.executeQuery("select * from categories;");
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
	public void fillCategories() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getCategory(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void addCategory(String string) {
		// TODO Auto-generated method stub
		
	}
}
