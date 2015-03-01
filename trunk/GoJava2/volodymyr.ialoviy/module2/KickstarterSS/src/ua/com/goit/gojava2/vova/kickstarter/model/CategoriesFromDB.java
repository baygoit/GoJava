package ua.com.goit.gojava2.vova.kickstarter.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava2.vova.kickstarter.util.ConnectToDB;

public class CategoriesFromDB implements Categories{
	
	private List<Category> categories = new ArrayList<Category>();
	
	@Override
	public List<Category> getCategories() {
		return categories;
	}

	@Override
	public void showAllCatecoriesInKickstarter() {
//		StringBuilder s = new StringBuilder();

		ResultSet result;
		try {
			result = ConnectToDB.statement.executeQuery("SELECT * FROM categories");
			while (result.next()) {
//			    s.append(result.getInt("id_category"))
//			    		.append(" ")
//			    		.append(result.getString("name_category"))
//			    		.append("\n").toString();
			    
			    
			    categories.add(new Category(result.getInt("id_category"), result.getString("name_category")));
			}
		} catch (SQLException e) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
		}

//		return s.substring(0, s.length() - 1);
	}

	@Override
	public String showAllProjectInCategory(int categoryId) {
		StringBuilder s = new StringBuilder();

		ResultSet result;
		try {
			result = ConnectToDB.statement.executeQuery("SELECT * FROM projects WHERE id_category =" + categoryId + "ORDER BY id_project");
            while (result.next()) {
                s.append(result.getInt("id_project"))
                	.append(", ").append(result.getString("name_project"))
					.append(", ").append(result.getString("short_description_project"))
					.append(", ").append(result.getString("how_much_needed_project"))
					.append(", ").append(result.getString("how_much_collected_project"))
					.append("\n").toString();
            }
		} catch (SQLException e) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
		}
		
		return s.substring(0, s.length() - 1);
	}

	@Override
	public String showCatecoryName(int categoryId) {
		StringBuilder s = new StringBuilder();

		ResultSet result;
		try {
			result = ConnectToDB.statement.executeQuery("SELECT * FROM categories WHERE id_category =" + categoryId);
            while (result.next()) {
                s.append(result.getString("name_category")).toString();
            }
		} catch (SQLException e) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
		}
		
		return s.toString();
	}

	@Override
	public int[] getKickCategories() {
		ArrayList<Integer> array = new ArrayList<Integer>();

		ResultSet result;
		try {
			result = ConnectToDB.statement.executeQuery("SELECT * FROM categories");
            while (result.next()) {
            	array.add(result.getInt("id_category"));
            }
		} catch (SQLException e) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
		}

        int[] a = new int[array.size()];
        int j = 0;
        for (Integer i : array){
        	a[j] = i;
        	j++;
        }
		return a;
	}

	@Override
	public int[] projectsThatAreContainedInTheCategory(int categoryId) {
		ArrayList<Integer> array = new ArrayList<Integer>();

		ResultSet result;
		try {
			result = ConnectToDB.statement.executeQuery("SELECT id_category, id_project FROM projects WHERE id_category =" + categoryId + "ORDER BY id_project");
            while (result.next()) {
            	array.add(result.getInt("id_project"));
            }
		} catch (SQLException e) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
		}

        int[] a = new int[array.size()];
        int j = 0;
        for (Integer i : array){
        	a[j] = i;
        	j++;
        }
		return a;
	}
}