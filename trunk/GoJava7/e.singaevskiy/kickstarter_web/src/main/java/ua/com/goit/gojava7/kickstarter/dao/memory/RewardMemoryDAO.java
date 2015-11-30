package ua.com.goit.gojava7.kickstarter.dao.memory;

import java.util.List;
import java.util.stream.Collectors;

import ua.com.goit.gojava7.kickstarter.dao.RewardDAO;
import ua.com.goit.gojava7.kickstarter.dao.memory.util.MemoryDAO;
import ua.com.goit.gojava7.kickstarter.domain.Reward;

public class RewardMemoryDAO extends MemoryDAO<Reward> implements RewardDAO{

    public RewardMemoryDAO(List<Reward> dataSource) {
        super(dataSource);
    }

    @Override
    public List<Reward> getByProject(int projectId) {
        return getAll().stream()
                .filter(reward -> reward.getProjectId() == projectId)
                .collect(Collectors.toList());
    }
  
}
