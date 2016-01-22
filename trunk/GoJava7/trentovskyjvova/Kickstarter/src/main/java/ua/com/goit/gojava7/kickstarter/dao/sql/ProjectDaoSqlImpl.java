package ua.com.goit.gojava7.kickstarter.dao.sql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.domain.Project;

@Repository
@Transactional
public class ProjectDaoSqlImpl implements ProjectDao {
	@PersistenceContext
	private EntityManager em;
	
	@Override	
	public List<Project> getProjects(int categoryId) {

		/*String sql = "SELECT p.id, p.categoryId, p.name, p.daysToGo, p.description, "
				+ "p.goal, p.owner, p.videoUrl, SUM(CASE WHEN pledge IS NULL THEN 0 ELSE pledge END) amountPledge "
				+ "FROM project p "
				+ "LEFT JOIN payment ON p.id = payment.projectId "
				+ "WHERE categoryId = :categoryId "
				+ "GROUP BY p.id, p.categoryId, p.name, p.daysToGo, p.description, p.goal, p.owner, p.videoUrl";			
		
		Session session = sessionFactory.getCurrentSession();

		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Project.class);
		query.setParameter("categoryId", categoryId);
		*/

		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

		CriteriaQuery<Project> criteriaQuery = criteriaBuilder.createQuery(Project.class);
		Root<Project> entityRoot = criteriaQuery.from(Project.class);
		//Join payments = entityRoot.join("payments", JoinType.LEFT);
		criteriaQuery.select(entityRoot);
		//criteriaQuery.multiselect(entityRoot.get("name"), criteriaBuilder.sum(entityRoot.get("payments").get("pledge")).alias("amountPledge"));
		criteriaQuery.where(criteriaBuilder.equal(entityRoot.get("category") , categoryId));
		//criteriaQuery.groupBy(entityRoot.get("name"));
		TypedQuery<Project> query = em.createQuery(criteriaQuery);

		return query.getResultList();		
	}

	@Override
	public Project getProject(int projectId) {

		/*String sql = "SELECT p.id, p.categoryId, p.name, p.daysToGo, p.description, "
				+ "p.goal, p.owner, p.videoUrl, SUM(CASE WHEN pledge IS NULL THEN 0 ELSE pledge END) amountPledge "
				+ "FROM project p "
				+ "LEFT JOIN payment ON p.id = payment.projectId "
				+ "WHERE p.id = :projectId "
				+ "GROUP BY p.id, p.categoryId, p.name, p.daysToGo, p.description, p.goal, p.owner, p.videoUrl";
		
		Session session = sessionFactory.getCurrentSession();
		
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Project.class);
		query.setParameter("projectId", projectId);
		
		return (Project) query.uniqueResult();
	
		return (Project) em.createQuery(sql).setParameter("projectId", projectId).getSingleResult();
*/
		return em.find(Project.class, projectId);
	}

}
