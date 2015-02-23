package ua.home.kickstarter.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ua.home.kickstarter.model.CategoriesDao;
import ua.home.kickstarter.model.ProjectsDao;
import ua.home.kickstarter.model.QuotationsDao;

public class DaoFactory {
	private String user = "user12";
	private String password = "123456";
	private String url = "jdbc:postgresql://localhost/kickstarterDB";

	String driver = "org.postgresql.Driver";

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	public ProjectsDao getProjectsDao(Connection connection) {
		return new ProjectsDao(connection);
	}

	public CategoriesDao getCategoriesDao(Connection connection) {
		return new CategoriesDao(connection);
	}
		
	public QuotationsDao getQuotationsDao(Connection connection) {
		return new QuotationsDao(connection);
	}

	public DaoFactory() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Что-то не так с загрузкой драйвера", e);
		}
	}
}
