package ua.com.goit.gojava.POM.dataModel.profitcost;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "project_stages")
public class ProjectStage  {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id = 0;
	
	@Column
	private String name = "";
	
	@Column
	private String description = "";
	
	@ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="parent")
    private Project parent;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Project getParent() {
		return parent;
	}

	public void setParent(Project parent) {
		this.parent = parent;
	}
	
}
