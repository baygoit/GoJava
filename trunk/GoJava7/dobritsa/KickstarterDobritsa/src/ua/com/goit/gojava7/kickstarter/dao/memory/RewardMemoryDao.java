package ua.com.goit.gojava7.kickstarter.dao.memory;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.RewardStorage;
import ua.com.goit.gojava7.kickstarter.domain.Reward;

public class RewardMemoryDao extends RewardStorage {

	public RewardMemoryDao(List<Reward> dataSource) {
		super();
	}
}
