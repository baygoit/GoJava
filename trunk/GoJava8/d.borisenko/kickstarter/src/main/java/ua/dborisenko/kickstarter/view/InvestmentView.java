package ua.dborisenko.kickstarter.view;

import ua.dborisenko.kickstarter.domain.Project;

public class InvestmentView extends View {

    public InvestmentView(Project project) {
        addContentString(HEADER_BLOCK);
        addContentString("Project " + project.getName());
        addContentString("Money left to collect: " + (project.getRequiredSum() - project.getCollectedSum()));
        addContentString("Reward information:");
        addContentString(SOLID_LINE);
        addContentString(project.getRewardInfo());
        addContentString(SOLID_LINE);
        addContentString("Enter your name: ");
    }
}
