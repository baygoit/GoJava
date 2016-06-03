package ua.nenya.dao;

import ua.nenya.domain.Project;
import ua.nenya.domain.Reward;

public interface RewardDao {
	Reward getRewardByRewardId(Long projectId);

	Project getProjectByRewardId(Long rewardId);

	boolean isRewardExist(Long rewardId);
}
