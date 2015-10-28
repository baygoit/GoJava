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
		Long maxId = null;
		Transaction transaction = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Project.class).setProjection(Projections.max("projectId"));
			maxId = (Long) criteria.uniqueResult();
			transaction.commit();
			if (maxId == null) {
				maxId = 0L;
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return maxId + 1;
	}

	@Override
	public void addProject(Project projectDetails) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			projectDetails.setProjectId(getNextId());
			session.saveOrUpdate(projectDetails);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}

	@Override
	public Map<Long, Project> getProjectList() {
		HashMap<Long, Project> map = new HashMap<Long, Project>();
		Transaction transaction = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			ArrayList<Project> arr = (ArrayList<Project>) session.createCriteria(Project.class).list();
			long iL = 0;
			for (int i = 0; arr.size() > i; i++) {
				map.put(iL, arr.get(i));
				iL++;
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return map;
	}

	@Override
	public Project getProjectDetails(int id) {

		Project project = new Project();
		Transaction transaction = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			project = session.get(Project.class, new Long(id));
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return project;
	}

	@Override
	public Map<Long, Project> getProjectFromCategory(int id) {
		HashMap<Long, Project> map = new HashMap<Long, Project>();
		Transaction transaction = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			ArrayList<Project> arr = (ArrayList<Project>) session.createCriteria(Project.class).add(Restrictions.eq("categoryId", id)).list();
			long iL = 0;
			for (int i = 0; arr.size() > i; i++) {
				map.put(iL, arr.get(i));
				iL++;
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return map;

	}

	@Override
	public void update(Project updatedProject) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Transaction transaction = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(updatedProject);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}

	@Override
	public void initDemoDB() {
		// TODO Auto-generated method stub

	}

}
