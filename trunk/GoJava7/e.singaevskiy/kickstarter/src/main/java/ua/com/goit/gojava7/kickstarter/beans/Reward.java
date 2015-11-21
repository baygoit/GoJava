package ua.com.goit.gojava7.kickstarter.beans;

public class Reward {
    
    private long pledgeSum;
    private String description;
    private Project project;
    private int id;

    public Reward() {
        // default bean constructor
    }
    
    public Reward(int id, Project project, String description, Long pledgeSum) {
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Reward [id=" + id + ", project=" + project.getId() + ", description=" + description + ", pledgeSum=" + pledgeSum
                + "]";
    }
}
