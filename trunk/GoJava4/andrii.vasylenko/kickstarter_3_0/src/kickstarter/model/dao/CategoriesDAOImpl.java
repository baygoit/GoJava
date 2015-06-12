package kickstarter.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kickstarter.exception.NoSuchDataException;
import kickstarter.model.engine.Category;

public class CategoriesDAOImpl implements CategoriesDAO {
	private ConnectionPool connectionPool;

	public CategoriesDAOImpl(ConnectionPool connectionPool) {
		this.connectionPool = connectionPool;
	}

	@Override
	public void addCategory(String name) throws SQLException {
		String sql = getInsertQuery();
		PreparedStatement statement = connectionPool.getConnection().prepareStatement(sql);

		statement.setString(1, name);

		statement.executeUpdate();
	}

	@Override
	public List<Category> getCategories() throws SQLException {
		List<Category> result = new ArrayList<>();

		String sql = getMultiSelectQuery();
		PreparedStatement statement = connectionPool.getConnection().prepareStatement(sql);

		ResultSet resultQuery = statement.executeQuery();

		while (resultQuery.next()) {
			result.add(getCategory(resultQuery));
		}

		return result;
	}

	@Override
	public Category getCategory(int id) throws NoSuchDataException, SQLException {
		String sql = getSelectQuery();
		PreparedStatement statement = connectionPool.getConnection().prepareStatement(sql);

		statement.setInt(1, id);

		ResultSet resultQuery = statement.executeQuery();

		if (resultQuery.next()) {
			return getCategory(resultQuery);
		} else {
			throw new NoSuchDataException(String.format("Category where id = %d", id));
		}
	}

	@Override
	public void createTableCategories() throws SQLException {
		Statement statement = connectionPool.getConnection().createStatement();
		String sql = getCreateQuery();
		statement.execute(sql);
	}

	private Category getCategory(ResultSet resultQuery) throws SQLException {
		int id = resultQuery.getInt("id");
		String name = resultQuery.getString("name");

		return new Category(id, name);
	}

	private String getInsertQuery() {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into Categories ");
		sql.append("(name) values(?)");
		return sql.toString();
	}

	private String getMultiSelectQuery() {
		StringBuilder sql = new StringBuilder();
		sql.append("select id, name ");
		sql.append("from Categories");
		return sql.toString();
	}

	private String getSelectQuery() {
		StringBuilder sql = new StringBuilder();
		sql.append("select id, name ");
		sql.append("from Categories ");
		sql.append("where id = ?");
		return sql.toString();
	}

	private String getCreateQuery() {
		StringBuilder sql = new StringBuilder();
		sql.append("drop table IF EXISTS Categories CASCADE; ");
		sql.append("create table Categories (");
		sql.append("id serial not null PRIMARY KEY, ");
		sql.append("name varchar(255)");
		sql.append(")");
		return sql.toString();
	}
}
