package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;
import ua.com.goit.gojava7.kickstarter.models.Reward;

@Repository
@Transactional
public class RewardDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	private static final Logger log = LoggerFactory.getLogger(RewardDao.class);

	public Reward get(Long rewardId) {
		log.info("<Reward> get({})...", rewardId);
		Session session = sessionFactory.getCurrentSession();

		return (Reward) session.createCriteria(Reward.class)
				.add(Restrictions.eq("rewardId", rewardId))
				.uniqueResult();
	}

	public List<Reward> getByProject(Long projectId) {
		log.info("<rewards> getByProject({})...", projectId);
		Session session = sessionFactory.getCurrentSession();

		return session.createCriteria(Reward.class)
				.add(Restrictions.eq("project.id", projectId))
				.list();
	}
}
