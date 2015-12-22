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

	private String prepareStringForDb(String original) {
		log.info("prepareStringForDb({original})...");	
		return original.replace("'", "\\'");
	}	
}
