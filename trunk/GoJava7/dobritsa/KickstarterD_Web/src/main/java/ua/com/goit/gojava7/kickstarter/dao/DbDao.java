package ua.com.goit.gojava7.kickstarter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class DbDao<T> implements Dao<T> {

	protected String FIELDS = null;
	protected String TABLE = null;
	protected List<T> data;
	protected Connection connection;
	
	@Autowired
	protected BasicDataSource basicDataSource;
	
	protected DbDao(){		
	}

	protected DbDao(BasicDataSource basicDataSource, String FIELDS, String TABLE) {
		this.basicDataSource = basicDataSource;
		this.FIELDS = FIELDS;
		this.TABLE = TABLE;
	}	
	
	public BasicDataSource getBasicDataSource() {
		return basicDataSource;
	}

	public void setBasicDataSource(BasicDataSource basicDataSource) {
		this.basicDataSource = basicDataSource;
	}
	
	@Override
	public T get(int index) {
		ResultSet resultSet = null;		
		String query = "select " + FIELDS + " from " + TABLE + " where id = " + index;
		try (PreparedStatement ps = basicDataSource.getConnection().prepareStatement(query)) {
				resultSet = ps.executeQuery();
			if (resultSet.next()) {
				return readElement(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();		
		}
		return null;
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
	public List<T> getAll() {
		ResultSet resultSet = null;
		List<T> data = new ArrayList<>();
		String query = "select " + FIELDS + " from " + TABLE;
		try (PreparedStatement ps = basicDataSource.getConnection().prepareStatement(query)) {
			resultSet = ps.executeQuery();
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
		ResultSet resultSet = null;
		String query = "select count(*) as cnt from " + TABLE;
		try (PreparedStatement ps = basicDataSource.getConnection().prepareStatement(query)) {
			resultSet = ps.executeQuery();
			if (resultSet.next()) {
				return resultSet.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
