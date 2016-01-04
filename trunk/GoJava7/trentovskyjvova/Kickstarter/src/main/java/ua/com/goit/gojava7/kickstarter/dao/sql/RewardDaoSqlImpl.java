package ua.com.goit.gojava7.kickstarter.dao.sql;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.goit.gojava7.kickstarter.dao.RewardDao;
import ua.com.goit.gojava7.kickstarter.domain.Reward;

@Repository
@Transactional
public class RewardDaoSqlImpl implements RewardDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Reward> getRewards(int projectId) {

		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Reward.class);
		criteria.add(Restrictions.eq("projectId", projectId));
		
		return criteria.list();
	}

	@Override
	public Reward getReward(int rewardId) {

		Session session = sessionFactory.getCurrentSession();
		
		return session.get(Reward.class, rewardId);
	}

}
