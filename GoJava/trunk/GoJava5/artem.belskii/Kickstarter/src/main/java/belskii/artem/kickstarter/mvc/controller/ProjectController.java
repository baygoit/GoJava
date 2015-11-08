
package belskii.artem.kickstarter.mvc.controller; 

import java.util.Map;
import belskii.artem.kickstarter.dao.project.Project;
import belskii.artem.kickstarter.mvc.model.ProjectModel;

public class ProjectController {
	private ProjectModel model;
	
	public ProjectController(ProjectModel model) {
		this.model = model;

	}
	
	public void addProject(Project projectDetails){
		model.addProject(projectDetails);
	}
	
	public Map<Long, Project> getProjectList(){
		return model.getProjectList();
	}
	
	public Map<Long, Project> getProjectFromCategory(int id){
		return model.getProjectFromCategory(id);
	}
	
	public Project getProjectById(int id){
		return model.getProjectDetails(id);
	}
	
	public void save(Project project){
		model.save(project);
	}
	
}
