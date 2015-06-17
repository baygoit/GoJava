package dao.category;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import dao.pool.KickstarterException;

public class DBcategoryServiceImpl implements CategoryService {

	private Connection conn;

	public DBcategoryServiceImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<Category> getAll() throws KickstarterException {
		List<Category> categories = new ArrayList<Category>();
		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement
					.executeQuery("SELECT COUNT(*) AS rowcount FROM categories");
			resultSet.next();
			int count = resultSet.getInt("rowcount");

			resultSet = statement
					.executeQuery("SELECT id,category  FROM categories");

			if (resultSet.wasNull()) {
				throw new KickstarterException("categories not found");
			}
			for (int pointer = 0; pointer < count; pointer++) {
				resultSet.next();
				Category category = new Category();
				category.setID(resultSet.getInt("id"));
				category.setName(resultSet.getString("category"));
				categories.add(category);
			}

		} catch (SQLException e) {
			categories = null;

		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (categories == null) {
				throw new KickstarterException("categories not found");
			}
		}
		return categories;
	}
}