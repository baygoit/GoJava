package ua.com.goit.gojava7.kickstarter.dao.DBImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.model.Project;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class ProjectDaoDb implements ProjectDao {

	private static final Logger log = LoggerFactory.getLogger(ProjectDaoDb.class);

	@PersistenceContext
	private EntityManager em;
	
	public Project get(Long projectId) {
		log.info("<Project> get(projectId = {})...", projectId);
		return em.find(Project.class, projectId);
	}
}
