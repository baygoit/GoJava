package ua.goit.kyrychok.kickstarter.mvc.model;

import ua.goit.kyrychok.kickstarter.model.Reward;

import java.util.List;

public class DonatePageModel extends BaseModel {
    private List<Reward> rewards;

    public List<Reward> getRewards() {
        return rewards;
    }

    public int getCount() {
        return rewards.size();
    }

    public Reward getReward(int index) {
        return rewards.get(index);
    }

    public void update(int categoryIndex, int projectIndex) {
        rewards = getDataProvider().getRewards(categoryIndex, projectIndex);
    }

    public boolean isRewardsExists() {
        return (rewards != null && rewards.size() > 0);
    }

}
