package presenter;

import model.Categories;
import model.CategoriesFromFile;
import model.Projects;
import model.ProjectsFromFile;
import view.Inputs;
import view.InputsConsole;
import view.Output;
import view.OutputConsole;

public class KickstarterMain {
    public static void main(String[] args){
    	Inputs in = new InputsConsole();
    	Output out = new OutputConsole();
    	Categories categories = new CategoriesFromFile();
    	Projects projects = new ProjectsFromFile();

    	KickstarterS run = new KickstarterS(in, out, categories, projects);
    	run.kickstarter();
    }
}