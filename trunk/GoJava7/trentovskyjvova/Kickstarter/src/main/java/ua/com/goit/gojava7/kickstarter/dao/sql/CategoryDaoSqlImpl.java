package ua.com.goit.gojava7.kickstarter.dao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.exception.IODatabaseException;

public class CategoryDaoSqlImpl implements CategoryDao {
	private DataSource dataSource;

	public CategoryDaoSqlImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<Category> getCategories() {
		List<Category> categories = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;

		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement("SELECT id, name FROM category");
			rset = stmt.executeQuery();

			Category category;
			while (rset.next()) {
				int id = rset.getInt("id");
				String name = rset.getString("name");
				category = new Category();
				category.setId(id);
				category.setName(name);
				categories.add(category);
			}
		} catch (SQLException e) {
			throw new IODatabaseException("Problem with database", e);
		} finally {
            try { if (rset != null) rset.close(); } catch(Exception e) { }
            try { if (stmt != null) stmt.close(); } catch(Exception e) { }
            try { if (conn != null) conn.close(); } catch(Exception e) { }
		}
		return categories;
	}

	@Override
	public Category getCategory(int id) {
		Category category = null;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;

		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement("SELECT name FROM category WHERE id = " + id);
			rset = stmt.executeQuery();

			while (rset.next()) {

				String name = rset.getString("name");
				category = new Category();
				category.setId(id);
				category.setName(name);

			}
		} catch (SQLException e) {
			throw new IODatabaseException("Problem with database", e);
		} finally {
			try { if (rset != null) rset.close(); } catch(Exception e) { }
			try { if (stmt != null) stmt.close(); } catch(Exception e) { }
			try { if (conn != null) conn.close(); } catch(Exception e) { }
		}
		return category;
	}

	@Override
	public int size() {
		int size = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;

		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement("SELECT COUNT(*) size FROM category");
			rset = stmt.executeQuery();

			while (rset.next()) {
				size = rset.getInt("size");
			}	
		} catch (SQLException e) {
			throw new IODatabaseException("Problem with database", e);
		} finally {
			try { if (rset != null) rset.close(); } catch(Exception e) { }
			try { if (stmt != null) stmt.close(); } catch(Exception e) { }
			try { if (conn != null) conn.close(); } catch(Exception e) { }
		}

		return size;
	}

}
