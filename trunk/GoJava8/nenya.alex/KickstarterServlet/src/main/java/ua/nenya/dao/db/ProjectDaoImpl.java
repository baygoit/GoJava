package ua.nenya.dao.db;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.nenya.dao.ProjectDao;
import ua.nenya.domain.Payment;
import ua.nenya.domain.Project;

@Transactional(readOnly = true)
@Repository
public class ProjectDaoImpl implements ProjectDao {

	private static final String GET_PROJECTS_BY_CATEGORY_ID = "FROM Project P WHERE P.category.id=:categoryId ORDER BY P.name";
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getProjectsByCategoryId(int categoryId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(GET_PROJECTS_BY_CATEGORY_ID);
		query.setParameter("categoryId", categoryId);
		List<Project> projects = query.list();
		
		List<Project> resultProjects = new ArrayList<>();
		for(Project it: projects){
			long sum = getPaymentSum(it);
			it.setAvailableAmount(sum);
			resultProjects.add(it);
		}
		return resultProjects;
	}

	@Override
	public Project getProjectByProjectId(int projectId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Project.class, projectId);
	}

	@Override
	public boolean isProjectExist(int projectId) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Project.class);
		criteria.add(Restrictions.eq("id", projectId));
		long count = (long) criteria.setProjection(Projections.rowCount()).uniqueResult();
		return count == 1;
	}

	@Override
	public void getProjectPayments(Project project) {
		Session session = sessionFactory.getCurrentSession();
        session.lock(project, LockMode.NONE);
        Hibernate.initialize(project.getPayments());
	}

	
	@Override
	public long getPaymentSum(Project project) {
		long sum = 0;
		List<Payment> payments = project.getPayments();
		for(Payment it: payments){
			sum = sum + it.getAmount();
		}
		return sum;
	}
	
}
