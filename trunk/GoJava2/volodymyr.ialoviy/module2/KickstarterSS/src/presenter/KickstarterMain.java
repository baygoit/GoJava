package presenter;

import model.Categories;
import model.CategoriesFromDB;
import model.Projects;
import model.ProjectsFromDB;
import view.Inputs;
import view.InputsConsole;
import view.Output;
import view.OutputConsole;
import view.View;

public class KickstarterMain {
    public static void main(String[] args){
    	Inputs in = new InputsConsole();
    	Output out = new OutputConsole();
    	Categories categories = new CategoriesFromDB();
    	Projects projects = new ProjectsFromDB();
    	View view = new View(out);
    	
    	KickstarterS run = new KickstarterS(in, categories, projects, view);
    	run.kickstarter();
    }
}