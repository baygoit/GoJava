package ua.com.goit.gojava7.kickstarter.dao.jdbc.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

public class JdbcDispatcher {

	private BasicDataSource datasource;

	public JdbcDispatcher(String driver, String url, String user, String password) throws SQLException {

		try {
			Class.forName(driver);
			Class.forName("org.apache.commons.dbcp2.BasicDataSource");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException(e.getMessage());
		}
		System.out.println(driver + " - " + url + " - " + user + " - " + password);
		datasource = new BasicDataSource();
		datasource.setDriverClassName(driver);
		datasource.setUrl(url);
		datasource.setUsername(user);
		datasource.setPassword(password);
	}

	public Connection getConnection() throws SQLException {
		Connection connection = datasource.getConnection();
		connection.setAutoCommit(false);
		return connection;
	}

	public void processException(Exception ex) {
		// ex.printStackTrace();
		printSQLException((SQLException)ex);
	}

	public static void printSQLException(SQLException ex) {

		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				if (ignoreSQLException(((SQLException) e).getSQLState()) == false) {

					System.err.println("SQLState: " + ((SQLException) e).getSQLState());
					System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
					System.err.println("Message: " + e.getMessage());

					Throwable t = ex.getCause();
					while (t != null) {
						System.out.println("Cause: " + t);
						t = t.getCause();
					}
				}
			}
		}
	}

	public static boolean ignoreSQLException(String sqlState) {

		if (sqlState == null) {
			System.out.println("The SQL state is not defined!");
			return false;
		}

		// X0Y32: Jar file already exists in schema
		if (sqlState.equalsIgnoreCase("X0Y32"))
			return true;

		// 42Y55: Table already exists in schema
		if (sqlState.equalsIgnoreCase("42Y55"))
			return true;

		return false;
	}

	public void close() {
		try {
			if (datasource != null && !datasource.isClosed()) {
				datasource.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clear(String sql) {
		try(Connection connection = this.getConnection(); 
			Statement statement = connection.createStatement();) {
			statement.execute(sql);
			connection.commit();
		} catch (SQLException e) {
			this.processException(e);
		}
	}

	public <T> void add(String sql, T element, JdbcDataSource<T> source) {
		try(Connection connection = this.getConnection();
	        PreparedStatement statement = connection.prepareStatement(sql)) {
			source.prepare(element, statement);
			statement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			this.processException(e);
		}
	}

	public <T> void add(String sql, List<T> elemens, JdbcDataSource<T> source) {
		try(Connection connection = this.getConnection();
	        PreparedStatement statement = connection.prepareStatement(sql)) {
			for (T element : elemens) {
				source.prepare(element, statement);
				statement.executeUpdate();
			}
			connection.commit();
		} catch (SQLException e) {
			this.processException(e);
		}
	}

	public <T> List<T> get(String sql, JdbcDataSource<T> source) {
		List<T> result = new ArrayList<>();
        try(Connection connection = this.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                result.add(source.read(resultSet));
            }
        } catch (SQLException e) {
        	this.processException(e);
        }
		return result;
	}

}
