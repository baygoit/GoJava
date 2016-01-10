package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.models.Reward;

@Repository
public class RewardDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	private static final Logger log = LoggerFactory.getLogger(RewardDao.class);

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Reward get(Long rewardId) {
		log.info("<Reward> get({})...", rewardId);
		Session session = sessionFactory.openSession();

		Reward reward = (Reward) session.createCriteria(Reward.class)
				.add(Restrictions.eq("rewardId", rewardId))
				.uniqueResult();

		session.close();
		log.debug("<Reward> get({}) returned reward: {}", rewardId, reward);
		return reward;
	}
	
	@SuppressWarnings("unchecked")
	public List<Reward> getByProject(Long projectId) {
		log.info("<rewards> getByProject({})...", projectId);	
		Session session = sessionFactory.openSession();

		List<Reward> rewards = session.createCriteria(Reward.class)
				.add(Restrictions.eq("project.id", projectId))
				.list();

		session.close();

		if (rewards.isEmpty())
			return null;

		return rewards;
	}
}
