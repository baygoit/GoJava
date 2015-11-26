package ua.com.goit.gojava7.kickstarter.dao.memory;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.RewardDao;
import ua.com.goit.gojava7.kickstarter.domain.Reward;

public class RewardDaoMemoryImpl implements RewardDao {
	private List<Reward> rewards;
	
	@Override
	public List<Reward> getRewards(int projectId) {
		rewards = new ArrayList<>();
		
		Reward reward1 = new Reward(1, 1);
		reward1.setPledge(1);
		reward1.setBenefit("a little one");	
		if(projectId == reward1.getProjectId()){
			rewards.add(reward1);
		}
		
		Reward reward2 = new Reward(2, 1);
		reward2.setPledge(10);
		reward2.setBenefit("a middle one");
		if(projectId == reward2.getProjectId()){
			rewards.add(reward2);
		}
		
		Reward reward3 = new Reward(3, 1);
		reward3.setPledge(40);
		reward3.setBenefit("a big one");
		if(projectId == reward2.getProjectId()){
			rewards.add(reward3);	
		}
		
		return rewards;
	}

	@Override
	public int size() {
		cacheRewards(1);
		
		return rewards.size();
	}

	@Override
	public Reward getReward(int id) {	
		return rewards.get(id);
	}
	
	public void cacheRewards(int projectId){
		if(rewards == null){
			getRewards(projectId);
		}
	}
}
