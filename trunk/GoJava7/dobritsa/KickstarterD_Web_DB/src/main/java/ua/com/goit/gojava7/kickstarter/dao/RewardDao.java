package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.goit.gojava7.kickstarter.models.Reward;

@Component
public class RewardDao {

	@Autowired
	private DbDao dbDao;

	private static final Logger log = LoggerFactory.getLogger(RewardDao.class);

	public RewardDao() {
		log.info("Constructor RewardDao()...");
	}

	public List<Reward> getByProject(int projectId) {
		log.info("<rewards> getByProject({})...", projectId);
		String query = "SELECT id, amount, reward, project_id FROM reward WHERE project_id = " + projectId;	
		return dbDao.getRewardsByProject(query);
	}

	public Reward get(int index) {
		log.info("<Reward> get({})...", index);
		String query = "select id, amount, reward, project_id from reward where id = " + index;
		return dbDao.getReward(query);
	}
}
