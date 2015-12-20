package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.goit.gojava7.kickstarter.models.Reward;

@Component
public class RewardDbDao {

	@Autowired
	private DbManager dbManager;

	private static final Logger log = LoggerFactory.getLogger(RewardDbDao.class);

	public RewardDbDao() {
		log.info("Constructor RewardDbDao()...");
	}

	public List<Reward> getByProject(int projectId) {
		log.info("<rewards> getByProject({})...", projectId);
		String query = "SELECT id, amount, reward, project_id FROM reward WHERE project_id = " + projectId;	
		return dbManager.getRewardsByProject(query);
	}

	public Reward get(int index) {
		log.info("<Reward> get({})...", index);
		String query = "select id, amount, reward, project_id from reward where id = " + index;
		return dbManager.getReward(query);
	}
}
