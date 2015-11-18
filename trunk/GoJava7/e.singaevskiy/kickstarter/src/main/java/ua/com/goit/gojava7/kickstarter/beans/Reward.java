package ua.com.goit.gojava7.kickstarter.beans;

public class Reward {
    
    private long pledgeSum;
    private String description;
    private Project project;

    public Reward() {
        // default bean constructor
    }
    
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + (int) (pledgeSum ^ (pledgeSum >>> 32));
        result = prime * result + ((project == null) ? 0 : project.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Reward other = (Reward) obj;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (pledgeSum != other.pledgeSum)
            return false;
        if (project == null) {
            if (other.project != null)
                return false;
        } else if (!project.equals(other.project))
            return false;
        return true;
    }
}
