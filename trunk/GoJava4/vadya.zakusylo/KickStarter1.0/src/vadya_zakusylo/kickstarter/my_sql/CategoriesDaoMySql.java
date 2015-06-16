package vadya_zakusylo.kickstarter.my_sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import vadya_zakusylo.kickstarter.model.Category;
import vadya_zakusylo.kickstarter.model.dao.CategoriesDao;

public class CategoriesDaoMySql extends CategoriesDao {
	private Connection connection;
	private List<Category> categories = new ArrayList<Category>();

	public CategoriesDaoMySql(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Category> getCategoriesList() {
		try {
			PreparedStatement preparedStatement = (PreparedStatement) connection
					.prepareStatement(selectCategories());
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				categories.add(new Category(resultSet.getString("category")));
			}
		} catch (SQLException e) {
			System.out.println("Can't connect to table \"Categories\"");
		}
		return categories;
	}

	private String selectCategories() {
		StringBuilder sql = new StringBuilder();
		sql.append("select id_category, category ");
		sql.append("from category;");
		return sql.toString();
	}
}
