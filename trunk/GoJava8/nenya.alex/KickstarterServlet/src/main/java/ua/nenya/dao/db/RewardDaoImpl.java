package ua.nenya.dao.db;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ua.nenya.dao.RewardDao;
import ua.nenya.domain.Reward;
import ua.nenya.util.HibernateUtil;

@Repository
public class RewardDaoImpl implements RewardDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Reward> getRewards(int projectId) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;
		List<Reward> rewards = null;
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Reward.class);
			criteria.add(Restrictions.eq("projectId", projectId));
			criteria.addOrder(Order.asc("id"));
			rewards = criteria.list();
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		}
		return rewards;
	}

}
