package ua.com.goit.gojava7.kickstarter.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import ua.com.goit.gojava7.kickstarter.DAO.AbstractCategoryStorage;
import ua.com.goit.gojava7.kickstarter.DAO.AbstractProjectStorage;
import ua.com.goit.gojava7.kickstarter.DAO.AbstractQuoteStorage;
import ua.com.goit.gojava7.kickstarter.DAO.dbStorage.CategoryDbStorage;
import ua.com.goit.gojava7.kickstarter.DAO.dbStorage.PaymentDbStorage;
import ua.com.goit.gojava7.kickstarter.DAO.dbStorage.ProjectDbStorage;
import ua.com.goit.gojava7.kickstarter.DAO.dbStorage.QuestionDbStorage;
import ua.com.goit.gojava7.kickstarter.DAO.dbStorage.QuoteDbStorage;
import ua.com.goit.gojava7.kickstarter.DAO.fileStorage.CategoryFileStorage;
import ua.com.goit.gojava7.kickstarter.DAO.fileStorage.PaymentFileStorage;
import ua.com.goit.gojava7.kickstarter.DAO.fileStorage.ProjectFileStorage;
import ua.com.goit.gojava7.kickstarter.DAO.fileStorage.QuestionFileStorage;
import ua.com.goit.gojava7.kickstarter.DAO.fileStorage.QuoteFileStorage;
import ua.com.goit.gojava7.kickstarter.DAO.memoryStorages.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.DAO.memoryStorages.PaymentStorage;
import ua.com.goit.gojava7.kickstarter.DAO.memoryStorages.ProjectStorage;
import ua.com.goit.gojava7.kickstarter.DAO.memoryStorages.QuestionStorage;
import ua.com.goit.gojava7.kickstarter.DAO.memoryStorages.QuoteStorage;
import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.console.ConsoleReader;
import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.model.Quote;

public class KickstarterRunner {

	public static void main(String[] args) throws IOException, SQLException {

		ConsoleReader consoleReader = new ConsoleReader();
		ConsolePrinter consolePrinter = new ConsolePrinter();

		QuoteDbStorage quoteStorage = new QuoteDbStorage();
		CategoryDbStorage categoryStorage = new CategoryDbStorage();
		ProjectDbStorage projectStorage = new ProjectDbStorage();
		PaymentDbStorage paymentStorage = new PaymentDbStorage();
		QuestionDbStorage questionStorage = new QuestionDbStorage();

//		QuoteFileStorage quoteStorage = new QuoteFileStorage();
//		CategoryFileStorage categoryStorage = new CategoryFileStorage();
//		ProjectFileStorage projectStorage = new ProjectFileStorage();
//		PaymentFileStorage paymentStorage = new PaymentFileStorage();
//		QuestionFileStorage questionStorage = new QuestionFileStorage();
		
		
//		QuoteStorage quoteStorage = initQuotes();
//		CategoryStorage categoryStorage = initCategiries();
//		ProjectStorage projectStorage = initProjects();
//		PaymentStorage paymentStorage = new PaymentStorage();
//		QuestionStorage questionStorage = new QuestionStorage();

		Kickstarter kickstarter = new Kickstarter(consoleReader, consolePrinter,
				quoteStorage, categoryStorage, projectStorage, paymentStorage, questionStorage);
		kickstarter.start();
		kickstarter.stop();
		
	}

	private static QuoteStorage initQuotes() {
		QuoteStorage quoteStorage = new QuoteStorage(new Random());
		Quote quote1 = new Quote();
		quote1.setText("Your work is going to fill a large part of your life");
		quote1.setAuthor("Steve Jobs");
		quoteStorage.add(quote1);
		
		Quote quote2 = new Quote();
		quote2.setText("Innovation distinguishes between a leader and a follower");
		quote2.setAuthor("Steve Jobs");
		quoteStorage.add(quote2);
		
		return quoteStorage;
	}

	private static CategoryStorage initCategiries() {
		CategoryStorage categoryStorage = new CategoryStorage();
		Category movie = new Category();
		movie.setCategoryName("Movie");
		categoryStorage.add(movie);
		
		Category art = new Category();
		art.setCategoryName("Art");
		categoryStorage.add(art);
		
		Category food = new Category();
		food.setCategoryName("Food");
		categoryStorage.add(food);
		
		return categoryStorage;
	}

	private static ProjectStorage initProjects() {

		ProjectStorage projectStorage = new ProjectStorage();

		Project boondockSaints = new Project();

		boondockSaints.setProjectName("Boondock Saints");
		boondockSaints.setIdParentCategory(1);
		boondockSaints.setProjectCostNeed(15000000);
		boondockSaints.setDeadline(180);
		boondockSaints.setProjectShortDescription("The Boondock Saints is a 1999 American crime film");
		boondockSaints
				.setProjectDescription("The MacManus brothers are living a quiet life in Ireland with their father.");
		boondockSaints.setVideoUrl("http://youtube.com/boondocksaints");

		projectStorage.add(boondockSaints);

		Project pulpFiction = new Project();

		pulpFiction.setProjectName("Pulp Fiction");
		pulpFiction.setIdParentCategory(1);
		pulpFiction.setProjectCostNeed(2000000);
		pulpFiction.setDeadline(210);
		pulpFiction.setProjectShortDescription("Jules Winnfield and Vincent Vega are two hitmen.");
		pulpFiction.setProjectDescription("The lives of two mob hit men, a boxer, a gangster's wife.");
		pulpFiction.setVideoUrl("http://youtube.com/pulpfiction");
		
		projectStorage.add(pulpFiction);
		
		Project artGallery = new Project();
		artGallery.setProjectName("Art Gallery");
		artGallery.setIdParentCategory(2);
		artGallery.setProjectCostNeed(400000);
		artGallery.setDeadline(80);
		artGallery.setProjectShortDescription("Art Gallery in town");
		artGallery.setProjectDescription("Art Gallery in town near something");
		artGallery.setVideoUrl("http://youtube.com/artgallery");

		projectStorage.add(artGallery);
		
		return projectStorage;
	}
}
