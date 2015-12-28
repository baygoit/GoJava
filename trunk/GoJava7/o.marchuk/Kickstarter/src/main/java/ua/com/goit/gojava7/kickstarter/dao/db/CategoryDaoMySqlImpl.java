package ua.com.goit.gojava7.kickstarter.dao.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.domain.Category;

@Repository
public class CategoryDaoMySqlImpl implements CategoryDao {

	@Autowired
	private DataSource dataSource;

	@Override
	public List<Category> getAll() {
		List<Category> categories = new ArrayList<Category>();

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			connection = dataSource.getConnection();
			ps = connection.prepareStatement("SELECT id, name FROM category order by name");
			rs = ps.executeQuery();

			while (rs.next()) {
				Category category = new Category();
				category.setId(rs.getLong("id"));
				category.setName(rs.getString("name"));

				categories.add(category);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return categories;
	}

	@Override
	public int count() {
		int count = 0;

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			connection = dataSource.getConnection();
			ps = connection.prepareStatement("SELECT count(*) as cnt FROM category");
			rs = ps.executeQuery();

			while (rs.next()) {
				count = rs.getInt("cnt");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return count;

	}

}
