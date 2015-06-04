package kickstarter.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kickstarter.exception.CannotAddDataException;
import kickstarter.exception.CannotCreateTableException;
import kickstarter.exception.CannotGetDataException;
import kickstarter.model.engine.Category;

public class CategoriesDAOImpl implements CategoriesDAO {

	private Connection connection;

	public CategoriesDAOImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void createTableCategories() throws CannotCreateTableException {
		try {
			Statement statement = connection.createStatement();

			StringBuilder sql = new StringBuilder();
			sql.append("drop table IF EXISTS Categories CASCADE; ");
			sql.append("create table Categories (");
			sql.append("id serial not null PRIMARY KEY, ");
			sql.append("name varchar(255)");
			sql.append(")");

			statement.execute(sql.toString());

		} catch (SQLException e) {
			throw new CannotCreateTableException(e);
		}
	}

	@Override
	public void addCategory(String name) throws CannotAddDataException {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("insert into Categories ");
			sql.append("(name) values(?)");

			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setString(1, name);

			statement.executeUpdate();

		} catch (SQLException e) {
			throw new CannotAddDataException(e);
		}
	}

	@Override
	public List<Category> getCategories() throws CannotGetDataException {
		List<Category> result = new ArrayList<>();

		try {
			StringBuilder sql = new StringBuilder();
			sql.append("select id, name ");
			sql.append("from Categories");

			PreparedStatement statement = connection.prepareStatement(sql.toString());

			ResultSet resultQuery = statement.executeQuery();

			while (resultQuery.next()) {
				result.add(getCategory(resultQuery));
			}

		} catch (SQLException e) {
			throw new CannotGetDataException(e);
		}

		return result;
	}

	@Override
	public Category getCategory(int id) throws CannotGetDataException {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("select id, name ");
			sql.append("from Categories ");
			sql.append("where id = ?");

			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setInt(1, id);

			ResultSet resultQuery = statement.executeQuery();

			if (resultQuery.next()) {
				return getCategory(resultQuery);
			} else {
				throw new CannotGetDataException("no existing data");
			}
		} catch (SQLException e) {
			throw new CannotGetDataException(e);
		}
	}

	private Category getCategory(ResultSet resultQuery) throws SQLException {
		int id = resultQuery.getInt("id");
		String name = resultQuery.getString("name");

		return new Category(id, name);
	}
}
