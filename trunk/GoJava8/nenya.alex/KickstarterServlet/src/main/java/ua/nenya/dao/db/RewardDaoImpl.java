package ua.nenya.dao.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.nenya.dao.RewardDao;
import ua.nenya.domain.Reward;

@Repository
public class RewardDaoImpl implements RewardDao {

	@PersistenceContext
	private EntityManager em;

	@Transactional(readOnly = true)
	@Override
	public List<Reward> getRewards(Long projectId) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Reward> criteriaQuery = criteriaBuilder.createQuery(Reward.class);
		Root<Reward> root = criteriaQuery.from(Reward.class);
		criteriaQuery.select(root);
		Predicate criteria = criteriaBuilder.equal(root.get("project").get("id"), projectId);
		criteriaQuery.where(criteria);
		criteriaQuery.orderBy(criteriaBuilder.asc(root.get("id")));
		TypedQuery<Reward> typedQuery = em.createQuery(criteriaQuery);
		return typedQuery.getResultList();
	}

}
