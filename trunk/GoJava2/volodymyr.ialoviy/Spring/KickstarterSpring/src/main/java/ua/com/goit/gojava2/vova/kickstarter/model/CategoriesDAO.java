package ua.com.goit.gojava2.vova.kickstarter.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class CategoriesDAO implements Categories{
	
	private DataSource dataSource;
	
	public CategoriesDAO(DataSource dataSource){
		this.dataSource = dataSource;
	}
	
	private Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	
	@Override
	public List<Category> getCategories() {
		List<Category> categories = new ArrayList<Category>();
		ResultSet result;
		try {
			Statement statement = getConnection().createStatement();
			result = statement.executeQuery("SELECT * FROM categories ORDER BY id_category");
			while (result.next()) {
			    categories.add(new Category(result.getInt("id_category"), result.getString("name_category")));
			}
		} catch (SQLException e) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
		}
		return categories;
	}

	@Override
	public String showCatecoryName(int categoryId) {
		Category category = getCategories().get(categoryId - 1);
		String name = category.getCategoryName();
		return name;
	}
}