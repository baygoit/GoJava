package belskii.artem.kickstarter.dao.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class ProjectDaoImplHiber implements ProjectDao {
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	private Long getNextId() {
		Session session = null;
		Transaction transaction = null;
		Long maxId=null;
		try{
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		transaction.begin();
		Criteria criteria = session.createCriteria(Project.class).setProjection(Projections.max("projectId"));
		maxId = (Long) criteria.uniqueResult();
		session.close();
		if (maxId == null) {
			maxId = 0L;
		}
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}
		return maxId + 1;
	}

	@Override
	public void addProject(Project projectDetails) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			transaction.begin();
			projectDetails.setProjectId(getNextId());
			session.save(projectDetails);
			session.getTransaction().commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}
	}

	@Override
	public Map<Long, Project> getProjectList() {
		Session session = null;
		Transaction transaction = null;
		HashMap<Long, Project> map = new HashMap<Long, Project>();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			transaction.begin();
			ArrayList<Project> arr = (ArrayList<Project>) session.createCriteria(Project.class).list();

			long iL = 0;
			for (int i = 0; arr.size() > i; i++) {
				map.put(iL, arr.get(i));
				iL++;
			}
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}
		return map;

	}

	@Override
	public Project getProjectDetails(int id) {
		Session session = null;
		Transaction transaction = null;
		Project project=new Project();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			transaction.begin();
			project = session.get(Project.class, new Long(id));
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}
		return project;
	}

	@Override
	public Map<Long, Project> getProjectFromCategory(int id) {
		Session session = null;
		Transaction transaction = null;
		HashMap<Long, Project> map = new HashMap<Long, Project>();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			transaction.begin();
			ArrayList<Project> arr = (ArrayList<Project>) session.createCriteria(Project.class).add(Restrictions.eq("categoryId", id)).list();
			long iL = 0;
			for (int i = 0; arr.size() > i; i++) {
				map.put(iL, arr.get(i));
				iL++;
			}
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}
		return map;

	}

	@Override
	public void update(Project updatedProject) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			transaction.begin();
			session.saveOrUpdate(updatedProject);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}

	}

	@Override
	public void initDemoDB() {
		// TODO Auto-generated method stub

	}

}
