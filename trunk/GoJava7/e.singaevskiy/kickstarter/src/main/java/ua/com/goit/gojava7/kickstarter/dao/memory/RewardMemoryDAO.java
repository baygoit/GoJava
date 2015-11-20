package ua.com.goit.gojava7.kickstarter.dao.memory;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.beans.Reward;
import ua.com.goit.gojava7.kickstarter.dao.RewardStorage;

public class RewardMemoryDAO extends MemoryDAO<Reward> implements RewardStorage{

    public RewardMemoryDAO(List<Reward> dataSource) {
        super(dataSource);
    }

}
