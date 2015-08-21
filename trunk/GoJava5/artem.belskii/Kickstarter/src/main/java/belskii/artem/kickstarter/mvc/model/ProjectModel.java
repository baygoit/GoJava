package belskii.artem.kickstarter.mvc.model;

import java.util.Map;

import belskii.artem.kickstarter.dao.project.Project;
import belskii.artem.kickstarter.dao.project.ProjectDao;
import belskii.artem.kickstarter.dao.project.ProjectDaoImplPsql;

public class ProjectModel {
	ProjectDao projectDao = new ProjectDaoImplPsql("src/main/conf/database.conf");
	
	public void addProject(Project projectDetails){
		projectDao.addProject(projectDetails);
	}
	
	public Map<Long, Project> getProjectList(){
		return projectDao.getProjectList();
	}
	
	public Project getProjectDetails(int projectId){
		//if (projectId>=1){projectId-=1;}
		return projectDao.getProjectDetails(projectId);
	}
	
	public Map<Long, Project> getProjectFromCategory(int CategoryId){
		
		return projectDao.getProjectFromCategory(CategoryId);
	}
	public void save(Project project){
		projectDao.update(project);
	}
}
