package ua.com.goit.gojava7.kikstarter.dao;

import java.util.List;

import ua.com.goit.gojava7.kikstarter.domain.Reward;

public interface RewardDao {

	void add(Reward reward);

	void remove(Reward reward);

	List<Reward> getProjectRewards(int projectId);

}
