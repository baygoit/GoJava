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

	@SuppressWarnings("unchecked")
	public List<Reward> getByProject(Long projectId) {
		log.info("<rewards> getByProject({})...", projectId);
		Project project = new Project();
		project.setProjectId(projectId);
		Session session = HibernateUtil.getSessionFactory().openSession();

		List<Reward> rewards = session.createCriteria(Reward.class)
				.add(Restrictions.eq("Project", project))
				.list();

		session.close();
		log.debug("getByProject({})...", projectId, rewards);
		return rewards;
	}

	public Reward get(Long index) {
		log.info("<Reward> get({})...", index);
		Session session = HibernateUtil.getSessionFactory().openSession();

		Reward reward = (Reward) session.createCriteria(Reward.class)
				.add(Restrictions.eq("rewardId", index))
				.uniqueResult();

		session.close();
		log.debug("get() returned reward: {}", reward);
		return reward;
	}
}
