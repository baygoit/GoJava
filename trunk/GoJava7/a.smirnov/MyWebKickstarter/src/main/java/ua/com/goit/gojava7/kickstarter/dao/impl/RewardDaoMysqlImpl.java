package ua.com.goit.gojava7.kickstarter.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.beans.Reward;
import ua.com.goit.gojava7.kickstarter.dao.AbstractJdbcTemplate;
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;
import ua.com.goit.gojava7.kickstarter.dao.hibernate.HibernateUtil;

@Repository
public class RewardDaoMysqlImpl extends AbstractJdbcTemplate implements RewardDao {

	public void add(Reward reward) {
		// TODO
	}

	public void remove(Reward reward) {
		// TODO
	}

	@SuppressWarnings("unchecked")
	public List<Reward> getProjectsRewards(int projectId) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Criteria criteria = session.createCriteria(Reward.class);
		criteria.add(Restrictions.eq("project.id", projectId));
		List<Reward> rewards = criteria.list();

		session.close();
		return rewards;
	}
}
