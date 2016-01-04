package ua.com.goit.gojava7.kickstarter.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.beans.Reward;
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;

@Repository
public class RewardDaoImpl implements RewardDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@SuppressWarnings("unchecked")
	public List<Reward> getProjectsRewards(int projectId) {
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Reward.class);
		criteria.add(Restrictions.eq("project.id", projectId));
		List<Reward> rewards = criteria.list();

		return rewards;
	}

	public void add(Reward reward) {
		// TODO
	}

	public void remove(Reward reward) {
		// TODO
	}
}
