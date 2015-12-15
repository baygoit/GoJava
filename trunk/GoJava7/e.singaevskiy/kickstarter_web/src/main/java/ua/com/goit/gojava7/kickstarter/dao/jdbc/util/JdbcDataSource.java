package ua.com.goit.gojava7.kickstarter.dao.jdbc.util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface JdbcDataSource<T> {

	T read(ResultSet resultSet) throws SQLException ;

	void prepare(T element, PreparedStatement statement) throws SQLException;
	
}
