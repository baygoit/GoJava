package ua.com.goit.gojava7.kickstarter.database.contract;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.beans.Reward;

public interface RewardDao {
		
	public void add(Reward reward);

	public void remove(Reward reward);
	
	public List<Reward> getProjectsRewards(int projectId);
}
