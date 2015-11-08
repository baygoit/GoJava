package ua.goit.goitjava.kickstarter.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.goit.goitjava.kickstarter.model.Category;

public class CategoriesDAO {
	
	public List<Category> getAllCategories(){
		Connection c = null;
		Statement st = null;
		Category cat = null;
		List<Category> arr = new ArrayList<Category>();
		try{
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/kickstarterdb",
					"postgres", "12345");
						
			st = c.createStatement();
			String string = "SELECT * FROM categories;";
			ResultSet rs = st.executeQuery(string);
			int id = 0;
			String name = null;
			while(rs.next()){
				id = rs.getInt("id");
				name = rs.getString("name");
				cat = new Category(name,id);
				arr.add(cat);
			}
			st.close();
			c.close();
		} catch(Exception e) {
			
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			System.out.println("Problems with getProject DB");
		}
		return arr;
	}
	
	public Category getSelectCategory(int id){
		Connection c = null;
		Statement st = null;
		Category cat = null;
		try{
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/kickstarterdb",
					"postgres", "12345");
						
			st = c.createStatement();
			String string = "SELECT * FROM categories WHERE id =" + id + ";";
			ResultSet rs = st.executeQuery(string);
			int idd = 0;
			String name = null;
			while(rs.next()){
				idd = rs.getInt("id");
				name = rs.getString("name");
				cat = new Category(name,idd);
			}
			st.close();
			c.close();
		} catch(Exception e) {
			
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			System.out.println("Problems with getProject DB");
		}
		return cat;
	}
}
