package ua.dborisenko.kickstarter.view;

import ua.dborisenko.kickstarter.domain.Project;
import ua.dborisenko.kickstarter.domain.Reward;

public class RewardsView extends View {

    public static final String INPUT_TO_CUSTOM_AMOUNT = "0";

    public void showContent(Project project) {
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
        addContentString(INPUT_TO_CUSTOM_AMOUNT + ": custom value");
        addContentString(SOLID_LINE);
        addContentString("Select the amount according to reward list: ");
        ioHandler.writeMessage(content.toString());
    }

    public void showMsgEnterAmount() {
        showMessage("Enter the investment amount:");
    }

    public void showMsgEnterName() {
        showMessage("Enter the investor's name:");
    }

    public void showMsgEnterCardNumber() {
        showMessage("Enter your card number:");
    }
}
