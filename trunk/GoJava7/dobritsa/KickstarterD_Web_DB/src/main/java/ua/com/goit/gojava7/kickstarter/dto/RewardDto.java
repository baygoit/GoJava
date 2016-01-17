package ua.com.goit.gojava7.kickstarter.dto;

import ua.com.goit.gojava7.kickstarter.model.Project;

public class RewardDto {

    private Long rewardId;
    private Long amount;
    private String reward;
    private Project project = new Project();

    public Long getRewardId() {
        return rewardId;
    }

    public void setRewardId(Long rewardId) {
        this.rewardId = rewardId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Long getProjectId() {
        return project.getProjectId();
    }

    @Override
    public String toString() {
        return "RewardDto [rewardId=" + rewardId + ", amount=" + amount
                + ", reward=" + reward + ", projectId=" + project.getProjectId() + "]";
    }
}
