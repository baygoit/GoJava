package ua.com.goit.gojava2.vova.kickstarter.presenter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.JDBCType;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import ua.com.goit.gojava2.vova.kickstarter.model.Categories;
import ua.com.goit.gojava2.vova.kickstarter.model.CategoriesFromDB;
import ua.com.goit.gojava2.vova.kickstarter.model.Projects;
import ua.com.goit.gojava2.vova.kickstarter.model.ProjectsFromDB;
import ua.com.goit.gojava2.vova.kickstarter.model.Quotes;
import ua.com.goit.gojava2.vova.kickstarter.model.QuotesFromDB;
import ua.com.goit.gojava2.vova.kickstarter.view.Inputs;
import ua.com.goit.gojava2.vova.kickstarter.view.InputsConsole;
import ua.com.goit.gojava2.vova.kickstarter.view.Output;
import ua.com.goit.gojava2.vova.kickstarter.view.OutputConsole;
import ua.com.goit.gojava2.vova.kickstarter.view.View;


public class KickstarterMain {
	
	private static final String PASS_DB = "7575";
	private static final String NAME_DB = "postgres";
	private static final String JDBC_POSTGRESQL_PATH = "jdbc:postgresql://127.0.0.1:5432/kickstarter";
	
    public static void main(String[] args){
    	
    	
    	Connection connection = null;
    	try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(JDBC_POSTGRESQL_PATH, NAME_DB, PASS_DB);
            Statement statement = connection.createStatement();

            Inputs in = new InputsConsole();
        	Output out = new OutputConsole();
        	Categories categories = new CategoriesFromDB(statement);
        	Projects projects = new ProjectsFromDB(statement);
        	View view = new View(out);
	    	Presenter run = new Presenter(in, categories, projects, view);
	    	
	    	Quotes quote = new QuotesFromDB(statement);
			view.printQuote(quote.getQuote());
			
	    	run.kickstarter();
	    	
	    	System.out.println("one minute");
    	
        } catch (Exception ex) {
	        Logger.getLogger(JDBCType.class.getName()).log(Level.SEVERE, null, ex);
	    } finally {
	        if (connection != null) {
	            try {
	                connection.close();
	            } catch (SQLException ex) {
	                Logger.getLogger(JDBCType.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
	    }
        
        System.out.println("done");
        
    }
}