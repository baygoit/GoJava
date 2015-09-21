package goit.nz.kickstarter.dao.hibernate;

import goit.nz.kickstarter.dao.AbstractHibernateDAO;
import goit.nz.kickstarter.dao.ProjectDAO;
import goit.nz.kickstarter.domain.FAQ;
import goit.nz.kickstarter.domain.Project;

import java.util.List;

import org.hibernate.Query;

public class ProjectDAOImplHibernate extends AbstractHibernateDAO implements
		ProjectDAO {

	@Override
	@SuppressWarnings("unchecked")
	public List<Project> getProjects(long categoryId) {
		Query query = getSession().createQuery("from Project p where p.category.id = :id");
		query.setLong("id", categoryId);
		return (List<Project>) query.list();
	}

	@Override
	public Project getProject(long id) {
		Query query = getSession().createQuery("from Project where id = :id");
		query.setLong("id", id);
		return (Project) query.uniqueResult();
	}

	@Override
	public void updatePledgedAmount(long projectId, int pledgedAmount) {
		Project project = getProject(projectId);
		project.addPledgedAmount(pledgedAmount);
		save(project);
	}

	@Override
	public void addQuestion(long projectId, String question) {
		Project project = getProject(projectId);
		FAQ faq = new FAQ();
		faq.setQuestion(question);
		faq.setProject(project);
		project.addFAQ(faq);
		save(project);
	}
	
	private void save(Project project) {
		getSession().merge(project);
	}

}
