package ua.com.goit.gojava7.kickstarter.dao.sql;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.dao.RewardDao;
import ua.com.goit.gojava7.kickstarter.domain.Quote;
import ua.com.goit.gojava7.kickstarter.domain.Reward;
import ua.com.goit.gojava7.kickstarter.hibernate.HibernateUtil;

@Repository
public class RewardDaoSqlImpl implements RewardDao {
	/*@Autowired
	private JdbcTemplate jdbcTemplate;*/

	@Override
	public List<Reward> getRewards(int projectId) {

/*		String sql = "SELECT id, projectId, pledge, benefit FROM reward WHERE projectId = ?";
		return jdbcTemplate.query(sql, new Integer[] { projectId }, new BeanPropertyRowMapper<Reward>(Reward.class));
*/	
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Criteria criteria = session.createCriteria(Reward.class);	
		criteria.add(Restrictions.eq("projectId", projectId));
		List<Reward> rewards = criteria.list();
		
		session.close();

		return rewards;
	}

	@Override
	public Reward getReward(int userChoise, int projectId) {
		if (userChoise == 0) {
			return null;
		} else {
			List<Reward> reward = getRewards(projectId);
			return reward.get(userChoise - 1);
		}
	}

	@Override
	public int size(int projectId) {

/*		String sql = "SELECT COUNT(*) size FROM reward WHERE projectId = ?";
		return jdbcTemplate.queryForObject(sql, new Integer[] { projectId }, Integer.class);*/

		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Criteria criteria = session.createCriteria(Reward.class);		
		criteria.add(Restrictions.eq("projectId", projectId));
		criteria.setProjection(Projections.rowCount());

		int size = (int) criteria.uniqueResult();

		session.close();

		return size;
	}

	@Override
	public Reward getReward(int rewardId) {

/*		String sql = "SELECT id, projectId, pledge, benefit FROM reward WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new Integer[] { rewardId },
				new BeanPropertyRowMapper<Reward>(Reward.class));*/

		Session session = HibernateUtil.getSessionFactory().openSession();

		Reward reward = session.get(Reward.class, rewardId);

		session.close();

		return reward;
	}

}
