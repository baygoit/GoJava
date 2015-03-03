package ua.com.goit.gojava2.vova.kickstarter.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava2.vova.kickstarter.util.ConnectToDB;

public class CategoriesFromDB implements Categories{

	private List<Category> categories;
	
	@Override
	public void setCatecories() {
		categories = new ArrayList<Category>();
		ResultSet result;
		try {
			result = ConnectToDB.statement.executeQuery("SELECT * FROM categories ORDER BY id_category");
			while (result.next()) {
			    categories.add(new Category(result.getInt("id_category"), result.getString("name_category")));
			}
		} catch (SQLException e) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
		}
	}

	@Override
	public List<Category> getCategories() {
		return categories;
	}

	@Override
	public String showCatecoryName(int categoryId) {
		Category category = getCategories().get(categoryId - 1);
		String name = category.getCategoryName();
		return name;
	}

	@Override
	public int[] getKickCategories() {
		ArrayList<Integer> array = new ArrayList<Integer>();
		List<Category> category = getCategories();
		for (Category cat : category){
			array.add(cat.getCategoryID());
		}

		int[] a = new int[array.size()];//TODO DELETE, INT[] = lIST
        int j = 0;
        for (Integer i : array){
        	a[j] = i;
        	j++;
        }
		return a;
	}
}