package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.goit.gojava7.kickstarter.models.Project;

@Component
public class ProjectDao {
	
	@Autowired
	private DbDao dbDao;
	
	private static final Logger log = LoggerFactory.getLogger(ProjectDao.class);	 

	public ProjectDao() {	
		log.info("Constructor ProjectDao()...");			
	}
	
	public List<Project> getByCategory(int categoryId) {			
		log.info("<Project> getByCategory({})...", categoryId);	
		String query = "select  id, name, description, goal, pledged, daysToGo, history, link, category_id from project where category_id = " + categoryId;
		return dbDao.getProjects(query);
	}	
	
	public Project get(int index) {				
		log.info("<Project> get({})...", index);
		String query = "select id, name, description, goal, pledged, daysToGo, history, link, category_id from project where id = " + index;
		return dbDao.getProject(query);
	}	
	
	public String getName(int index) {				
		log.info("<Project> get({})...", index);
		String query = "select name from project where id = " + index;
		return dbDao.getProjectName(query);
	}	
	
	public List<Project> getTop5ProjectsByPledged() {				
		log.info("<projects> getTop5ByPledged()...");		
		String query = "select sum(amount) as sum, project_id as projectId from payment group by project_id order by sum desc limit 5";
		List<Project> projects = dbDao.getTop5ProjectsByPledged(query);
		
		for(Project project : projects) {
			project.setName(getName(project.getId()));			
		}
		return projects;				
	}		

	private String prepareStringForDb(String original) {
		log.info("prepareStringForDb({original})...");	
		return original.replace("'", "\\'");
	}	
}
