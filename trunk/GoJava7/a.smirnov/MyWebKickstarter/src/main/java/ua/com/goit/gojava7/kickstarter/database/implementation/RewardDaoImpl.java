package ua.com.goit.gojava7.kickstarter.database.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ua.com.goit.gojava7.kickstarter.beans.Reward;
import ua.com.goit.gojava7.kickstarter.database.contract.RewardDao;

@Repository
public class RewardDaoImpl implements RewardDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	@SuppressWarnings("unchecked")
	public List<Reward> getProjectsRewards(int projectId) {
		return entityManager.createNamedQuery("Reward.findProjectRewards").setParameter("id", projectId).getResultList();
	}

	@Override
	@Transactional
	public void add(Reward reward) {
		entityManager.persist(reward);
	}

	@Override
	@Transactional
	public void remove(Reward reward) {
		entityManager.remove(reward);
	}
}
