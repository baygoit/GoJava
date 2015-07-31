package ua.goit.kyrychok.kickstarter.dao.memory;

import ua.goit.kyrychok.kickstarter.dao.RewardDao;
import ua.goit.kyrychok.kickstarter.model.Reward;

import java.util.List;

public class MemoryRewardDao implements RewardDao {
    private MemoryStorage storage;

    public MemoryRewardDao(MemoryStorage storage) {
        this.storage = storage;
    }

    @Override
    public List<Reward> fetch(int projectId) {
        return storage.getProject(projectId).getRewards();
    }

    @Override
    public Reward load(int id) {
        return storage.getReward(id);
    }
}
