package control;

import model.Category;
import model.Project;
import model.ProjectRepository;

public class ProjectControl {

	private ProjectRepository projectRepository;
	
	public ProjectControl(){
		projectRepository = new ProjectRepository();
	}
	
	public Project[] getProjects(Category category){
		return projectRepository.getProjectsOfChosenCategory(category);
	}
}
