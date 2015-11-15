package ua.com.goit.gojava7.kickstarter.beans;

public class Reward {
    private long pledgeSum;
    private String description;
    private Project project;

    public Reward(Project project, String description, Long pledgeSum) {
        this.project = project;
        this.description = description;
        this.pledgeSum = pledgeSum;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Long getPledgeSum() {
        return pledgeSum;
    }

    public void setPledgeSum(Long pledgeSum) {
        this.pledgeSum = pledgeSum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
