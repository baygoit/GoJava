package ua.com.goit.gojava.POM.dataModel.profitcost;

public class Project {
	
	private long id = 0;
	private String name = "";
	private String description = "";
	private ProjectType type = ProjectType.OUTER;
	private boolean active = true;
	private String pm = "";
	
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
	
	public ProjectType getType() {
		
		return type;
		
	}
	
	public void setType(ProjectType type) {
		
		this.type = type;
		
	}
	
	public boolean isActive() {
		
		return active;
		
	}
	
	public void setActive(boolean active) {
		
		this.active = active;
		
	}
	
	public String getPm() {
		
		return pm;
		
	}
	
	public void setPm(String pm) {
		
		this.pm = pm;
		
	}
	
}