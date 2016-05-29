package ua.nenya.dao.db;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.nenya.dao.RewardDao;
import ua.nenya.domain.Project;
import ua.nenya.domain.Reward;

@Transactional(readOnly = true)
@Repository
public class RewardDaoImpl implements RewardDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Reward getRewardByRewardId(Long rewardId) {
		
		Query query = em.createNamedQuery("Reward.getById");
		query.setParameter("rewardId", rewardId);
		
		return (Reward) query.getSingleResult();
	}

	@Override
	public Project getProjectByRewardId(Long rewardId) {
		Query query = em.createNamedQuery("Reward.getProjectByRewardId");
		query.setParameter("rewardId", rewardId);
		
		return (Project) query.getSingleResult();
	}

	@Override
	public boolean isRewardExist(Long rewardId) {
		Query query = em.createNamedQuery("Reward.Count");
		query.setParameter("rewardId", rewardId);
		long count = (long) query.getSingleResult();
		return count == 1L;
	}

}
