package belskii.artem.kickstarter.mvc.model;

import java.util.HashMap;

import belskii.artem.kickstarter.dao.project.Project;
import belskii.artem.kickstarter.dao.project.ProjectDao;
import belskii.artem.kickstarter.dao.project.ProjectDaoImplHardCoding;

public class ProjectModel {
	ProjectDao projectDao = new ProjectDaoImplHardCoding();
	
	public void addProject(Project projectDetails){
		projectDao.addProject(projectDetails);
	}
	
	public HashMap<Long, Project> getProjectList(){
		return projectDao.getProjectList();
	}
	
	public Project getProjectDetails(int projectId){
		//if (projectId>=1){projectId-=1;}
		return projectDao.getProjectDetails(projectId);
	}
	
	public HashMap<Long, Project> getProjectFromCategory(int CategoryId){
		
		return projectDao.getProjectFromCategory(CategoryId);
	}
}
