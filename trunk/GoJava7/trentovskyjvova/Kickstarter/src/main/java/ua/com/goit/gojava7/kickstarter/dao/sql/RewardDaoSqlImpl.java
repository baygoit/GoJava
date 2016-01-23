package ua.com.goit.gojava7.kickstarter.dao.sql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;

import ua.com.goit.gojava7.kickstarter.domain.Reward;

@Repository
@Transactional
public class RewardDaoSqlImpl implements RewardDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Reward> getRewards(int projectId) {

		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

		CriteriaQuery<Reward> criteriaQuery = criteriaBuilder.createQuery(Reward.class);
		Root<Reward> entityRoot = criteriaQuery.from(Reward.class);
		criteriaQuery.select(entityRoot);
		criteriaQuery.where(criteriaBuilder.equal(entityRoot.get("projectId"), projectId));
		TypedQuery<Reward> query = em.createQuery(criteriaQuery);

		return query.getResultList();
	}

	@Override
	public Reward getReward(int rewardId) {

		return em.find(Reward.class, rewardId);
	}

}
