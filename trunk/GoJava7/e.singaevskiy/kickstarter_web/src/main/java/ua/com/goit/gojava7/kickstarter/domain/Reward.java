package ua.com.goit.gojava7.kickstarter.domain;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Reward {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
    private long pledgeSum;
    private String description;
    @ManyToOne
    @JoinColumn(name="project_id", foreignKey=@ForeignKey(name="Reward_Project"))
    private Project project;

    public Reward() {
        // default bean constructor
    }
    
    public Reward(int id, Project project, String description, long pledgeSum) {
        this.id = id;
        this.setProject(project);
        this.description = description;
        this.pledgeSum = pledgeSum;
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
        return "Reward [id=" + id + ", project=" + project + ", description=" + description + ", pledgeSum="
                + pledgeSum + "]";
    }

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
}
