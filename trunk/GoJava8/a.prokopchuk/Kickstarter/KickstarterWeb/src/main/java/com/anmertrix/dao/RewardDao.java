package com.anmertrix.dao;

import java.util.List;

import com.anmertrix.domain.Reward;

public interface RewardDao {
	
	List<Reward> getRewards(long projectId);

}
