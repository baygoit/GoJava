package com.anmertrix.dao.sql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.anmertrix.dao.RewardDao;
import com.anmertrix.domain.Reward;

@Repository
public class RewardDaoSql implements RewardDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Reward> getRewards(long projectId) {
		return em.createNamedQuery("Reward.getRewards", Reward.class)
				.setParameter("projectId", projectId).getResultList();
	}

}
