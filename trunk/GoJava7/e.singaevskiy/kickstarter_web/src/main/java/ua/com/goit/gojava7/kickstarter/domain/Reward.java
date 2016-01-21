package ua.com.goit.gojava7.kickstarter.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="Reward.getAll", query="select entity from Reward as entity"),
	@NamedQuery(name="Reward.getByProject", query="select entity from Reward as entity where project_id = :project_id"),
	@NamedQuery(name="Reward.removeAll", query="delete from Reward")
	})
public class Reward {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
    private long pledgeSum;
    private String description;
    @ManyToOne(cascade={CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name="project_id", foreignKey=@ForeignKey(name="Reward_Project"))
    private Project project;

    public Reward() {
        // default bean constructor
    }
    
    public Reward(Project project, String description, long pledgeSum) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
