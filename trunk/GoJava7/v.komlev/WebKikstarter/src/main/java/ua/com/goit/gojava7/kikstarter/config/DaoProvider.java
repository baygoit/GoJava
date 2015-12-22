package ua.com.goit.gojava7.kikstarter.config;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import ua.com.goit.gojava7.kikstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kikstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kikstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kikstarter.dao.database.CategoryDaoDbImpl;
import ua.com.goit.gojava7.kikstarter.dao.database.ProjectDaoDbImpl;
import ua.com.goit.gojava7.kikstarter.dao.database.QuoteDaoDbImpl;

public class DaoProvider {

	private MyDataSource myDataSource;
	private Connection connection;
	private ConnectionPoolSource connectionPoolSource;

	public DaoProvider(MyDataSource myDataSource) {
		this.myDataSource = myDataSource;
	}

	public void open() {
		if (myDataSource == MyDataSource.ORACLE) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");

				connection = ConnectionPoolSource.getInstance().getConnection();
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
			QuoteDaoDbImpl quoteDaoDbImpl = new QuoteDaoDbImpl(connectionPoolSource);
			quoteDao = quoteDaoDbImpl;
		} else {
			throw new IllegalArgumentException("Unknown data source " + myDataSource);
		}

		return quoteDao;
	}

	public CategoryDao getCategoryDao() {
		CategoryDao categoryDao;
		if (myDataSource == MyDataSource.ORACLE) {
			CategoryDaoDbImpl categoryDaoDbImpl = new CategoryDaoDbImpl(connectionPoolSource);
			categoryDao = categoryDaoDbImpl;
		} else {
			throw new IllegalArgumentException("Unknown data source " + myDataSource);
		}

		return categoryDao;
	}

	public ProjectDao getProjectDao() {
		ProjectDao projectDao;
		if (myDataSource == MyDataSource.ORACLE) {
			ProjectDaoDbImpl projectDaoDbImpl = new ProjectDaoDbImpl(connectionPoolSource);
			projectDao = projectDaoDbImpl;
		} else {
			throw new IllegalArgumentException("Unknown data source " + myDataSource);
		}

		return projectDao;
	}
}
