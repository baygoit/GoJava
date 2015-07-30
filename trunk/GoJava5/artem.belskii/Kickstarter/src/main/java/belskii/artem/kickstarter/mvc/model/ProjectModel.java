package belskii.artem.kickstarter.mvc.model;

import java.util.ArrayList;

import belskii.artem.kickstarter.dao.project.Project;
import belskii.artem.kickstarter.dao.project.ProjectDao;
import belskii.artem.kickstarter.dao.project.ProjectDaoImplHardCoding;

public class ProjectModel {
	ProjectDao projectDao = new ProjectDaoImplHardCoding();
	
	public void addProject(Project projectDetails){
		projectDao.addProject(projectDetails);
	}
	
	public ArrayList<Project> getProjectList(){
		return projectDao.getProjectList();
	}
	
	public Project getProjectDetails(int projectId){
		return projectDao.getProjectDetails(projectId);
	}
	
	public ArrayList<Project> getProjectFromCategory(int CategoryId){
		return projectDao.getProjectFromCategory(CategoryId);
	}
}
