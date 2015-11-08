package com.go_java4.alex_mirn.dao;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Random;

import javax.management.RuntimeErrorException;

import com.go_java4.alex_mirn.data.Category;
import com.go_java4.alex_mirn.data.Project;
import com.go_java4.alex_mirn.data.Quote;
import com.go_java4.alex_mirn.view.io.ConsoleIO;
import com.go_java4.alex_mirn.view.pages.PageDispatcher;

public class DaoImpl implements Dao {
	ConnectionPool connectionPool;
	private QuotesDao quotes;
	private CategoriesDao categories;
	private ProjectsDao projects;
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Problems with postgres driver", e);
		}
	}
	
	public DaoImpl(Random random) throws IOException, SQLException {
		this.connectionPool = new ConnectionPoolImpl();
		this.quotes = new QuotesDaoImpl(connectionPool);
		this.categories = new CategoriesDaoImpl(connectionPool);
		this.projects = new ProjectsDaoImpl(connectionPool);
	}
	
	@Override
	public List<Project> getProjectsInCategory(int index) throws SQLException {
		return projects.getProjectsInCategory(index);
	}
	
	@Override
	public void add(Project project) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public int getProjectsSize() throws SQLException {
		return projects.getProjectsSize();
	}
	
	@Override
	public Project getProjectIndex(int index) throws SQLException {
		return projects.getProjectIndex(index);
	}

	@Override
	public List<Project> getAllProjects() throws SQLException {
		return projects.getAllProjects();
	}
	
	@Override
	public void add(Category category) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Category getCategoriesIndex(int index) throws SQLException {
		return categories.getCategoriesIndex(index);
	}

	@Override
	public int getCategoriesSize() throws SQLException {
		return categories.getCategoriesSize();
	}

	@Override
	public List<Category> getAll() throws SQLException {
		return categories.getAll();
	}
		
	@Override
	public void add(Quote quote) throws SQLException {
		quotes.add(quote);
	}

	@Override
	public Quote getRandomQuote() throws SQLException {
		return quotes.getRandomQuote();
	}

	@Override
	public void createTableQuotes() throws SQLException {
		quotes.createTableQuotes();
	}

}