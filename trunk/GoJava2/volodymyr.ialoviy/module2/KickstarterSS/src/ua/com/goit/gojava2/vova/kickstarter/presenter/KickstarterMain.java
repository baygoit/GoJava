package ua.com.goit.gojava2.vova.kickstarter.presenter;


import java.sql.Connection;

import ua.com.goit.gojava2.vova.kickstarter.model.Categories;
import ua.com.goit.gojava2.vova.kickstarter.model.CategoriesFromDB;
import ua.com.goit.gojava2.vova.kickstarter.model.Projects;
import ua.com.goit.gojava2.vova.kickstarter.model.ProjectsFromDB;
import ua.com.goit.gojava2.vova.kickstarter.model.Quotes;
import ua.com.goit.gojava2.vova.kickstarter.model.QuotesFromDB;
import ua.com.goit.gojava2.vova.kickstarter.view.InputsConsole;
import ua.com.goit.gojava2.vova.kickstarter.view.OutputConsole;
import ua.com.goit.gojava2.vova.kickstarter.view.View;


public class KickstarterMain {
	
    public static void main(String[] args){
    	
    	ConnectToDB connectToDB = new ConnectToDB();
    	Connection connection = connectToDB.createStatement();
    	
    	Categories categories = new CategoriesFromDB(connection);
    	Projects projects = new ProjectsFromDB(connection);
    	View view = new View(new OutputConsole());
    	
    	Quotes quote = new QuotesFromDB(connection);
		view.printQuote(quote.getQuote());
		
    	Presenter run = new Presenter(new InputsConsole(), categories, projects, view);

    	run.kickstarter();

    	connectToDB.closeStatement();
        System.out.println("done, i closed");
    }
}