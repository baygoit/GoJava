package ua.com.goit.gojava7.kickstarter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class DbDao<T> implements Dao<T> {

	protected String FIELDS = null;
	protected String TABLE = null;
	protected List<T> data;
	protected Connection connection;

	protected DbDao(Connection connection, String FIELDS, String TABLE) {
		this.connection = connection;
		this.FIELDS = FIELDS;
		this.TABLE = TABLE;
	}

	protected abstract T readElement(ResultSet resultSet) throws SQLException;

	public T getByNumber(int number) {
		return get(number);
	}

	@Override
	public void setAll(List<T> data) {
		this.data = data;
	}

	public String prepareStringForDb(String original) {
		return original.replace("'", "\\'");
	}

	@Override
	public T get(int index) {
		String query = "select " + FIELDS + " from " + TABLE + " where id = " + index;
		try (PreparedStatement ps = connection.prepareStatement(query); ResultSet resultSet = ps.executeQuery()) {
			if (resultSet.next()) {
				return readElement(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<T> getAll() {
		List<T> data = new ArrayList<>();
		String query = "select " + FIELDS + " from " + TABLE;
		try (PreparedStatement ps = connection.prepareStatement(query); ResultSet resultSet = ps.executeQuery()) {
			while (resultSet.next()) {
				data.add(readElement(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public int size() {
		String query = "select count(*) as cnt from " + TABLE;
		try (PreparedStatement ps = connection.prepareStatement(query); ResultSet resultSet = ps.executeQuery()) {
			if (resultSet.next()) {
				return resultSet.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
