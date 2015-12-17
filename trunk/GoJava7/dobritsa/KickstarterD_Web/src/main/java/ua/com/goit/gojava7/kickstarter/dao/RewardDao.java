package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.models.Reward;

public interface RewardDao extends Dao<Reward> {

	public List<Reward> getByProject(int projectId);

}
