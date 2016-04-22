package ua.nenya.dao;

import java.util.List;

import ua.nenya.domain.Reward;

public interface RewardDao {
	List<Reward> getRewards(int id);
}
