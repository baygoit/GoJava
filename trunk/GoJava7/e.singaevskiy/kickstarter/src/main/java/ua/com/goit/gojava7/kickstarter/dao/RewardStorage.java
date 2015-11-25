package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;
import java.util.stream.Collectors;

import ua.com.goit.gojava7.kickstarter.beans.Reward;

public interface RewardStorage extends DataStorage<Reward>{
    
    default List<Reward> getByProject(int projectId) {
        return getAll().stream()
                .filter(reward -> reward.getProjectId() == projectId)
                .collect(Collectors.toList());
    }

}
