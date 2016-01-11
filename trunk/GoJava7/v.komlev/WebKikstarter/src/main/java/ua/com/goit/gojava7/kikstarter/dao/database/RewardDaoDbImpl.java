package ua.com.goit.gojava7.kikstarter.dao.database;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kikstarter.dao.RewardDao;
import ua.com.goit.gojava7.kikstarter.domain.Reward;

@Repository
public class RewardDaoDbImpl implements RewardDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Reward reward) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(reward);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void remove(Reward reward) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(reward);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reward> getProjectRewards(int projectId) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Reward.class);
		criteria.add(Restrictions.eq("projects.id", projectId));
		List<Reward> rewards = criteria.list();

		session.close();
		return rewards;
	}

}
