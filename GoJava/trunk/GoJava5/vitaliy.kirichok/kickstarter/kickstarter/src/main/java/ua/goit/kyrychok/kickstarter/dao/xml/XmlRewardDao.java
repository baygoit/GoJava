package ua.goit.kyrychok.kickstarter.dao.xml;

import ua.goit.kyrychok.kickstarter.dao.RewardDao;
import ua.goit.kyrychok.kickstarter.model.Reward;

import java.util.List;

public class XmlRewardDao implements RewardDao {
    private XmlStorage storage;

    public XmlRewardDao(XmlStorage storage) {
        this.storage = storage;
    }

    @Override
    public List<Reward> fetch(int projectId) {
        return storage.getRewards(projectId);
    }

    @Override
    public Reward load(int id) {
        return storage.getReward(id);
    }
}
