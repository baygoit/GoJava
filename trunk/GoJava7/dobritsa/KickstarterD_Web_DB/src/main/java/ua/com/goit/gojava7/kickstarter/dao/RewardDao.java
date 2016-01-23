package ua.com.goit.gojava7.kickstarter.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.goit.gojava7.kickstarter.model.Reward;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class RewardDao {

	private static final Logger log = LoggerFactory.getLogger(RewardDao.class);

	@PersistenceContext
	private EntityManager em;

	public Reward get(Long rewardId) {
		log.info("<Reward> get(rewardId = {})...", rewardId);
		return em.find(Reward.class, rewardId);
	}
}
