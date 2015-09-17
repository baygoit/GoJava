package belskii.artem.kickstarter.mvc.model;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import belskii.artem.kickstarter.dao.project.Project;
import belskii.artem.kickstarter.dao.project.ProjectDao;

public class ProjectModel {
	ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-context.xml");
	ProjectDao projectDao = (ProjectDao) context.getBean("projectDaoImpl");  
	
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
