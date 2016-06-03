package ua.nenya.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.nenya.service.RewardService;

@Service
public class RewardServiceImpl implements RewardService {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly = true)
	public boolean isRewardExist(Long rewardId) {
		Query query = em.createNamedQuery("Reward.Count");
		query.setParameter("rewardId", rewardId);
		long count = (long) query.getSingleResult();
		return count == 1L;
	}

}
