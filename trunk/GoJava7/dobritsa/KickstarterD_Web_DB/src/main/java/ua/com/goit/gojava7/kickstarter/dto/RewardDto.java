package ua.com.goit.gojava7.kickstarter.dto;

public class RewardDto {

    private Long rewardId;
    private Long amount;
    private String reward;
    private ProjectDto projectDto = new ProjectDto();

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

    public ProjectDto getProjectDto() {
        return projectDto;
    }

    public void setProjectDto(ProjectDto projectDto) {
        this.projectDto = projectDto;
    }

    public Long getProjectDtoId() {
        return projectDto.getProjectId();
    }

    @Override
    public String toString() {
        return "RewardDto [rewardId=" + rewardId + ", amount=" + amount
                + ", reward=" + reward + ", projectDtoId=" + projectDto.getProjectId() + "]";
    }
}
