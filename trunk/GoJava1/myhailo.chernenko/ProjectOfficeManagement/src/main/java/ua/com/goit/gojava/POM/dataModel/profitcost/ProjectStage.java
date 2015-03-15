package ua.com.goit.gojava.POM.dataModel.profitcost;

public class ProjectStage  {

	private long id = 0;
	private String name = "";
	private String description = "";
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
