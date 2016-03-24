package ua.dborisenko.kickstarter.view;

import ua.dborisenko.kickstarter.domain.Project;
import ua.dborisenko.kickstarter.domain.Reward;

public class RewardsView extends View {

    public RewardsView(Project project) {
        addContentString(HEADER_BLOCK);
        addContentString("Project " + project.getName());
        addContentString("Money left to collect: " + (project.getRequiredSum() - project.getCollectedSum()));
        addContentString("Rewards: ");
        addContentString(SOLID_LINE);
        Reward reward;
        for (int i = 0; i < project.getRewards().size(); i++) {
            reward = project.getRewardByIndex(i);
            addContentString((i + 1) + ": $" + reward.getAmount() + " - " + reward.getDescription());
        }
        addContentString("0: custom value");
        addContentString(SOLID_LINE);
        addContentString("Select the amount according to reward list: ");
    }
}
