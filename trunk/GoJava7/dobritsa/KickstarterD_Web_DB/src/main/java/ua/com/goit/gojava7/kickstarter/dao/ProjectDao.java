package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;
import ua.com.goit.gojava7.kickstarter.models.Category;
import ua.com.goit.gojava7.kickstarter.models.Project;
import ua.com.goit.gojava7.kickstarter.models.Question;

@Repository
@Transactional
public class ProjectDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private QuestionDao questionDao;

	@Autowired
	private PaymentDao paymentDao;

	private static final Logger log = LoggerFactory.getLogger(ProjectDao.class);
	
	public Project get(Long projectId) {
		log.info("<Project> get({})...", projectId);
		Session session = sessionFactory.getCurrentSession();

		Project project = (Project) session.createCriteria(Project.class)
				.add(Restrictions.eq("projectId", projectId))
				.uniqueResult();

		if(project!=null)
			setPledged(project);

		return project;
	}

	public List<Project> getByCategory(Long categoryId) {
		log.info("<projects> getByCategory({})...", categoryId);
		Session session = sessionFactory.getCurrentSession();

		List<Project> projects = session.createCriteria(Project.class)
				.add(Restrictions.eq("category.id", categoryId))
				.list();

		setPledged(projects);

		return projects;
	}

	private void setPledged(List<Project> projects){
		log.info("<projects> setPledged()...");

		for(Project project : projects)
			setPledged(project);
	}

	private void setPledged(Project project){
		Long projectId = project.getProjectId();
		log.info("<void> setPledged({})...", projectId);

		project.setPledged(paymentDao.calculatePledgedForProject(projectId));
	}

	public List<Question> getQuestions(Long projectId) {
		log.info("<questions> getQuestions({})...", projectId);

		return questionDao.getByProject(projectId);
	}

	public Category getCategory(Project project) {
		log.info("<Category> getCategory({})...", project);

		Long categoryId = project.getCategoryId();

		return categoryDao.get(categoryId);
	}
}
