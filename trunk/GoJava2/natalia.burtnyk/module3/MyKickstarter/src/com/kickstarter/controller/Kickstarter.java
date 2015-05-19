package com.kickstarter.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.kickstarter.model.Categories;
import com.kickstarter.model.CategoriesDAO;
import com.kickstarter.model.Projects;
import com.kickstarter.model.ProjectsDAO;
import com.kickstarter.model.QuotesDAO;
import com.kickstarter.view.In;
import com.kickstarter.view.InPutConsole;
import com.kickstarter.view.OutConsole;
import com.kickstarter.view.View;

public class Kickstarter {

	public static void main(String[] args) {
		Connection connection = null;
		QuotesDAO quotesStorage = null;
		Categories categories = null;
		Projects projects = null;
		In inPut = null;
		View consoleView = null;

		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DataForKickstarter",
													"postgres", "Berezhnoi");
			
			consoleView = new View(new OutConsole());
			quotesStorage = new QuotesDAO(connection);
			inPut = new InPutConsole();
			categories = new CategoriesDAO(connection);
			projects = new ProjectsDAO(connection);

		} catch (SQLException e) {
			throw new RuntimeException("Something is wrong with driver downloads", e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		KickstarterEngine engine = new KickstarterEngine(consoleView,
				quotesStorage, inPut, categories, projects);
		engine.run();
	}
}