package ua.com.goit.gojava7.kikstarter.config;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import ua.com.goit.gojava7.kikstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kikstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kikstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kikstarter.dao.database.CategoryDaoDb;
import ua.com.goit.gojava7.kikstarter.dao.database.ProjectDaoDb;
import ua.com.goit.gojava7.kikstarter.dao.database.QuoteDaoDb;

public class DaoProvider {

	private MyDataSource myDataSource;
	private Connection connection = null;

	public DaoProvider(MyDataSource myDataSource) {
		this.myDataSource = myDataSource;
	}

	public void open() {
		if (myDataSource == MyDataSource.ORACLE) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");

				connection = MysqlProvider.getInstance().getConnection();
			} catch (SQLException e) {
				throw new IllegalStateException("Cannot open connection. " + e.getMessage(), e);
			} catch (ClassNotFoundException e) {
				throw new IllegalStateException("Cannot open load mysql driver. " + e.getMessage(),
						e);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (PropertyVetoException e) {
				e.printStackTrace();
			}
		}
	}

	public void close() {
		if (myDataSource == MyDataSource.ORACLE) {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new IllegalStateException(
						"Cannot close connection " + connection + ". " + e.getMessage(), e);
			}
		}
	}

	public QuoteDao getQuoteDao() {
		QuoteDao quoteDao;
		if (myDataSource == MyDataSource.ORACLE) {
			QuoteDaoDb quoteDaoDb = new QuoteDaoDb(connection);
			quoteDao = quoteDaoDb;
		} else {
			throw new IllegalArgumentException("Unknown data source " + myDataSource);
		}

		return quoteDao;
	}

	public CategoryDao getCategoryDao() {
		CategoryDao categoryDao;
		if (myDataSource == MyDataSource.ORACLE) {
			CategoryDaoDb categoryDaoDb = new CategoryDaoDb(connection);
			categoryDao = categoryDaoDb;
		} else {
			throw new IllegalArgumentException("Unknown data source " + myDataSource);
		}

		return categoryDao;
	}

	public ProjectDao getProjectDao() {
		ProjectDao projectDao;
		if (myDataSource == MyDataSource.ORACLE) {
			ProjectDaoDb projectDaoDb = new ProjectDaoDb(connection);
			projectDao = projectDaoDb;
		} else {
			throw new IllegalArgumentException("Unknown data source " + myDataSource);
		}

		return projectDao;
	}
}
