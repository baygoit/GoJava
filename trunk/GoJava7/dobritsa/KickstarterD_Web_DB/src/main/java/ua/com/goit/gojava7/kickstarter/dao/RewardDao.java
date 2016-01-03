package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ua.com.goit.gojava7.kickstarter.hibernate.HibernateUtil;
import ua.com.goit.gojava7.kickstarter.models.Project;
import ua.com.goit.gojava7.kickstarter.models.Reward;

@Repository
public class RewardDao {

	private static final Logger log = LoggerFactory.getLogger(RewardDao.class);

	public Reward get(Long rewardId) {
		log.info("<Reward> get({})...", rewardId);
		Session session = HibernateUtil.getSessionFactory().openSession();

		Reward reward = (Reward) session.createCriteria(Reward.class)
				.add(Restrictions.eq("rewardId", rewardId))
				.uniqueResult();

		session.close();
		log.debug("<Reward> get({}) returned reward: {}", rewardId, reward);
		return reward;
	}
	
	@SuppressWarnings("unchecked")
	public List<Reward> getByProject(Project project) {
		log.info("<rewards> getByProject({})...", project);
	
		Session session = HibernateUtil.getSessionFactory().openSession();

		List<Reward> rewards = session.createCriteria(Reward.class)
				.add(Restrictions.eq("Project", project))
				.list();

		session.close();
		log.debug("<rewards> getByProject({}) returned rewards: {}", project, rewards);
		return rewards;
	}	
}
