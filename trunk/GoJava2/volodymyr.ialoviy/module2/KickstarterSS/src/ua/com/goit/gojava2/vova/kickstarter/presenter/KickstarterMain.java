package ua.com.goit.gojava2.vova.kickstarter.presenter;

import ua.com.goit.gojava2.vova.kickstarter.model.Categories;
import ua.com.goit.gojava2.vova.kickstarter.model.CategoriesFromDB;
import ua.com.goit.gojava2.vova.kickstarter.model.Projects;
import ua.com.goit.gojava2.vova.kickstarter.model.ProjectsFromDB;
import ua.com.goit.gojava2.vova.kickstarter.view.Inputs;
import ua.com.goit.gojava2.vova.kickstarter.view.InputsConsole;
import ua.com.goit.gojava2.vova.kickstarter.view.Output;
import ua.com.goit.gojava2.vova.kickstarter.view.OutputConsole;
import ua.com.goit.gojava2.vova.kickstarter.view.View;

public class KickstarterMain {
    public static void main(String[] args){
    	Inputs in = new InputsConsole();
    	Output out = new OutputConsole();
    	Categories categories = new CategoriesFromDB();
    	Projects projects = new ProjectsFromDB();
    	View view = new View(out);
    	
    	Presenter run = new Presenter(in, categories, projects, view);
    	run.kickstarter();
    }
}