package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;
import java.util.stream.Collectors;

import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.beans.Reward;

public interface RewardStorage extends DataStorage<Reward>{
    
    default List<Reward> getByProject(Project project) {
        return getAll().stream()
                .filter(reward -> reward.getProject().equals(project))
                .collect(Collectors.toList());
    }

}
