package ua.nenya.dao.db;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.nenya.dao.RewardDao;
import ua.nenya.domain.Reward;

@Repository
public class RewardDaoImpl implements RewardDao {

	private static final String GET_REWARDS_BY_PROJECT_ID = "FROM Reward R WHERE R.project.id=:projectId ORDER BY R.id";
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@SuppressWarnings("unchecked")
	@Override
	public List<Reward> getRewards(int projectId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(GET_REWARDS_BY_PROJECT_ID);
		query.setParameter("projectId", projectId);
		return query.list();
	}

}
