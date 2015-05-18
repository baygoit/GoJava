package ua.com.goit.gojava.kickstarter.control;

import java.util.ArrayList;

import ua.com.goit.gojava.kickstarter.model.Category;
import ua.com.goit.gojava.kickstarter.model.Project;
import ua.com.goit.gojava.kickstarter.model.ProjectsRepository;

public class ProjectsControl {
    
    ProjectsRepository projectsRepository;
    
    public ProjectsControl(){
	projectsRepository = new ProjectsRepository(); 
    }
    
    public ArrayList <Project> getProjectsByCategory(Category category){
	return projectsRepository.getProjectsByCategory(category);
    }

}
