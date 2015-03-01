package ua.com.goit.gojava2.vova.kickstarter.presenter;


import ua.com.goit.gojava2.vova.kickstarter.model.Categories;
import ua.com.goit.gojava2.vova.kickstarter.model.CategoriesFromDB;
import ua.com.goit.gojava2.vova.kickstarter.model.Projects;
import ua.com.goit.gojava2.vova.kickstarter.model.ProjectsFromDB;
import ua.com.goit.gojava2.vova.kickstarter.util.ConnectToDB;
import ua.com.goit.gojava2.vova.kickstarter.view.InputsConsole;
import ua.com.goit.gojava2.vova.kickstarter.view.OutputConsole;
import ua.com.goit.gojava2.vova.kickstarter.view.View;


public class KickstarterMain {
	
    public static void main(String[] args){
    	Categories categories = new CategoriesFromDB();
    	Projects projects = new ProjectsFromDB();
    	View view = new View(new OutputConsole());
    	Presenter run = new Presenter(new InputsConsole(), categories, projects, view);

    	ConnectToDB.createStatement();

    	run.kickstarter();

    	ConnectToDB.closeStatement();
        System.out.println("done, i closed");
    }
}