package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.goit.gojava7.kickstarter.models.Project;

@Component
public class ProjectDbDao {
	
	@Autowired
	private DbManager dbManager;
	
	private static final Logger log = LoggerFactory.getLogger(ProjectDbDao.class);	 

	public ProjectDbDao() {	
		log.info("Constructor ProjectDbDao()...");			
	}

	public void updatePledged(Project project, int amount) {
		log.info("updatePledged({}, {})...", project, amount);		
		String query = "update project set pledged = pledged + " + amount + " WHERE name = '"
				+ prepareStringForDb(project.getName()) + "'";		
		dbManager.updatePledged(project, query);
		project.updatePledged(amount);
	}

	public List<Project> getByCategory(int categoryId) {			
		log.info("<Project> getByCategory({})...", categoryId);	
		String query = "select  id, name, description, goal, pledged, daysToGo, history, link, category_id from project where category_id = " + categoryId;
		return dbManager.getProjects(query);
	}	
	
	public Project get(int index) {				
		log.info("<Project> get({})...", index);
		String query = "select id, name, description, goal, pledged, daysToGo, history, link, category_id from project where id = " + index;
		return dbManager.getProject(query);
	}	

	public int size() {			
		log.info("<int> size()...");
		String query = "select count(*) as cnt from project";
		return dbManager.size(query);
	}
	
	private String prepareStringForDb(String original) {
		log.info("prepareStringForDb({original})...");	
		return original.replace("'", "\\'");
	}	
}
