package belskii.artem.kickstarter.dao.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;

import belskii.artem.kickstarter.dao.category.Category;

public class ProjectDaoImplHiber implements  ProjectDao{
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	private Long getNextId() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria = session
			    .createCriteria(Project.class)
			    .setProjection(Projections.max("projectId"));
			Long maxId = (Long)criteria.uniqueResult();
			session.close();
			if (maxId==null){
				maxId=0L;
			}
			return maxId+1;
	}
	
	@Override
	public void addProject(Project projectDetails) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		projectDetails.setProjectId(getNextId());
		session.save(projectDetails);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Map<Long, Project> getProjectList() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		ArrayList<Project> arr = (ArrayList<Project>) session.createCriteria(Project.class).list();
		System.out.println(arr.size());
		HashMap<Long,Project> map=new HashMap<Long,Project>();
		long iL=0;
		for (int i=0;arr.size()>i;i++) {
			map.put(iL,arr.get(i));
			iL++;
		}
		return map;

	}

	@Override
	public Project getProjectDetails(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Project project = session.get(Project.class, new Long(id));
		return project;
	}

	@Override
	public Map<Long, Project> getProjectFromCategory(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Project updatedProject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initDemoDB() {
		// TODO Auto-generated method stub
		
	}

}
