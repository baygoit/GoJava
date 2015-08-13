
package belskii.artem.kickstarter.mvc.controller; 

import java.util.Map;
import belskii.artem.kickstarter.dao.project.Project;
import belskii.artem.kickstarter.mvc.model.ProjectModel;
import belskii.artem.kickstarter.mvc.view.ProjectView;

public class ProjectController {
	private ProjectModel model;
	private ProjectView view;
	
	public ProjectController(ProjectModel model, ProjectView view) {
		this.model = model;
		this.view = view;
	}
	
	public void addProject(Project projectDetails){
		model.addProject(projectDetails);
	}
	
	public Map<Long, Project> getProjectList(){
		return model.getProjectList();
	}
	
	public Project printProjectDetails(int id){
		return view.printProjectDetails(model.getProjectDetails(id));
	}
	
	public Map<Long, Project> getProjectFromCategory(int id){
		return model.getProjectFromCategory(id);
	}
	
	public Project getProjectById(Long id){
		return model.getProjectList().get(id);
	}
	
	public void save(Project project){
		model.save(project);
	}
	
}
