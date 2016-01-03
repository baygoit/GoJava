package ua.com.goit.gojava7.kickstarter.dao.sql;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.goit.gojava7.kickstarter.dao.RewardDao;
import ua.com.goit.gojava7.kickstarter.domain.Reward;

@Repository
public class RewardDaoSqlImpl implements RewardDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Reward> getRewards(int projectId) {

		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Reward.class);
		criteria.add(Restrictions.eq("projectId", projectId));
		List<Reward> rewards = criteria.list();

		return rewards;
	}

	@Override
	@Transactional
	public Reward getReward(int userChoise, int projectId) {
		if (userChoise == 0) {
			return null;
		} else {
			List<Reward> reward = getRewards(projectId);
			return reward.get(userChoise - 1);
		}
	}

	@Override
	@Transactional
	public int size(int projectId) {

		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Reward.class);
		criteria.add(Restrictions.eq("projectId", projectId));
		criteria.setProjection(Projections.rowCount());

		int size = (int) criteria.uniqueResult();

		return size;
	}

	@Override
	@Transactional
	public Reward getReward(int rewardId) {

		Session session = sessionFactory.getCurrentSession();

		Reward reward = session.get(Reward.class, rewardId);

		return reward;
	}

}
