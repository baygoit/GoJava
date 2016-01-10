package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.models.Category;
import ua.com.goit.gojava7.kickstarter.models.Payment;
import ua.com.goit.gojava7.kickstarter.models.Project;
import ua.com.goit.gojava7.kickstarter.models.Question;

@Repository
public class ProjectDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private QuestionDao questionDao;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private static final Logger log = LoggerFactory.getLogger(ProjectDao.class);
	
	public Project get(Long projectId) {
		log.info("<Project> get({})...", projectId);		
		Session session = sessionFactory.openSession();

		Project project = (Project) session.createCriteria(Project.class)
				.add(Restrictions.eq("projectId", projectId))
				.uniqueResult();

		session.close();

		if(project!=null)
			setPledged(project);

		return project;
	}

	@SuppressWarnings("unchecked")
	public List<Project> getByCategory(Long categoryId) {
		log.info("<projects> getByCategory({})...", categoryId);		
		Session session = sessionFactory.openSession();

		List<Project> projects = session.createCriteria(Project.class)
				.add(Restrictions.eq("category.id", categoryId))
				.list();

		session.close();

		if (projects.isEmpty())
			return null;

		return setPledged(projects);
	}

	public List<Project> setPledged(List<Project> projects){
		log.info("<projects> setPledged()...");

		for(Project project : projects)
			setPledged(project);
		//projects.forEach(this::setPledged);

		return projects;
	}

	public Project setPledged(Project project){
		Long projectId = project.getProjectId();
		log.info("<void> setPledged({})...", projectId);

		project.setPledged(calculatePledged(projectId));
		return  project;
	}

	public Long calculatePledged(Long projectId){
		log.info("<Long> calculatePledged({})...", projectId);

		List<Payment> payments = getPayments(projectId);

		if(payments == null)
			return 0L;

		Long pledged = 0L;
		for(Payment payment : payments) {
			pledged += payment.getAmount();
		}

		return pledged;
	}

	public List<Question> getQuestions(Long projectId) {
		log.info("<questions> getQuestions({})...", projectId);

		return questionDao.getByProject(projectId);
	}

	public List<Payment> getPayments(Long projectId) {
		log.info("<payments> getPayments({})...", projectId);
		Session session = sessionFactory.openSession();

		List<Payment> payments = session.createCriteria(Payment.class)
				.add(Restrictions.eq("project.id", projectId))
				.list();

		session.close();

		if (payments.isEmpty())
			return null;

		return payments;
	}

	public Category getCategory(Project project) {
		log.info("<Category> getCategory({})...", project);

		Long categoryId = project.getCategoryId();

		return categoryDao.get(categoryId);
	}
}
