package ua.com.goit.gojava7.kickstarter.domain;

public class Reward {
    
    private long pledgeSum;
    private String description;
    private int projectId;
    private int id;

    public Reward() {
        // default bean constructor
    }
    
    public Reward(int id, int projectId, String description, long pledgeSum) {
        this.id = id;
        this.projectId = projectId;
        this.description = description;
        this.pledgeSum = pledgeSum;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public long getPledgeSum() {
        return pledgeSum;
    }

    public void setPledgeSum(long pledgeSum) {
        this.pledgeSum = pledgeSum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
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
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Reward [id=" + id + ", projectId=" + projectId + ", description=" + description + ", pledgeSum="
                + pledgeSum + "]";
    }
}
