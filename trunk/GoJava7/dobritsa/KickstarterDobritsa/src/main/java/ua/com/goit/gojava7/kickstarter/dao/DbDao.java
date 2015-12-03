package ua.com.goit.gojava7.kickstarter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public abstract class DbDao<T> implements Dao<T> {

	protected String FIELDS = null;
	protected String TABLE = null;
	protected List<T> data;
	protected Connection connection;
	protected BasicDataSource basicDataSource;

	protected DbDao(BasicDataSource basicDataSource, String FIELDS, String TABLE) {
		this.basicDataSource = basicDataSource;
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
		try (Connection connection = basicDataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(query); ResultSet resultSet = ps.executeQuery()) {
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
		try (Connection connection = basicDataSource.getConnection(); PreparedStatement ps = connection.prepareStatement(query); ResultSet resultSet = ps.executeQuery()) {
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
		try (Connection connection = basicDataSource.getConnection(); PreparedStatement ps = connection.prepareStatement(query); ResultSet resultSet = ps.executeQuery()) {
			if (resultSet.next()) {
				return resultSet.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
