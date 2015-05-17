package control;

import java.util.ArrayList;

import model.Category;
import model.Project;
import model.ProjectsRepository;

public class ProjectsControl {
    
    ProjectsRepository projectsRepository;
    
    public ProjectsControl(){
	projectsRepository = new ProjectsRepository(); 
    }
    
    public ArrayList <Project> getProjectsByCategory(Category category){
	return projectsRepository.getProjectsByCategory(category);
    }

}
