package ua.com.goit.gojava7.kickstarter.dao.memory;

import java.util.List;
import java.util.stream.Collectors;

import ua.com.goit.gojava7.kickstarter.dao.MemoryDao;
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;
import ua.com.goit.gojava7.kickstarter.domain.Reward;

public class RewardMemoryDao extends MemoryDao<Reward> implements RewardDao {

	public RewardMemoryDao(List<Reward> data) {
		super(data);
	}

	@Override
	public List<Reward> getByProject(String projectName) {
		return this.getAll().stream().filter(reward -> reward.getProjectName().equals(projectName))
				.collect(Collectors.toList());
	}
}
