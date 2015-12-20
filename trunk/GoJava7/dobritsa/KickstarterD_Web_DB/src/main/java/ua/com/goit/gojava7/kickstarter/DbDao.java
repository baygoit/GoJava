package ua.com.goit.gojava7.kickstarter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class DbDao<T> implements Dao<T>{
	
	private static final Logger log = LoggerFactory.getLogger(DbDao.class);	 
	protected String FIELDS = null;
	protected String TABLE = null;
	protected List<T> data;
	protected Connection connection;
	
	@Autowired
	protected BasicDataSource basicDataSource;
	
	protected DbDao(){		
		log.info("Constructor DbDao()...");		
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

	public T readElement(ResultSet resultSet) throws SQLException {
		return null;		
	}

	public T getByNumber(int number) {
		log.info("<{}> getByNumber()...");
		return get(number);
	}	

	public String prepareStringForDb(String original) {
		log.info("<{}> prepareStringForDb({original})...", TABLE);	
		return original.replace("'", "\\'");
	}	
	
	@Override
	public List<T> getAll() {		
		log.info("<{}> getAll()...", TABLE);
		List<T> data = new ArrayList<>();
		String query = "select " + FIELDS + " from " + TABLE;		
		log.debug("<{}> getAll() built query: {}", TABLE, query);
		
		try (Connection connection = basicDataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(query); ResultSet resultSet = ps.executeQuery()) {
			while (resultSet.next()) {
				data.add(readElement(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		log.debug("<{}> getAll() returned data: {}", TABLE, data);
		return data;
	}
	
	@Override
	public T get(int index) {		
		log.info("<{}> get({})...", TABLE, index);
		String query = "select " + FIELDS + " from " + TABLE + " where id = " + index;
		log.debug("<{}> get({}) built query: {}", TABLE, index, query);
		
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
	public int size() {	
		log.info("<{}> size()...", TABLE);
		String query = "select count(*) as cnt from " + TABLE;
		log.debug("{} size() built query: {}", TABLE, query);
		try (Connection connection = basicDataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(query); ResultSet resultSet = ps.executeQuery()) {
			if (resultSet.next()) {
				return resultSet.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
