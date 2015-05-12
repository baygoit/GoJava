package entities;

public class Project {
	
	private String name;
	private int projectID;
	private String brief;
	private int pledged;
	private int daysToGo;
	private String description;
	private String link;
	private String FAQ;
	
	public Project() {
	}
	
	public Project(String name) {
		this.name = name;
	}
	
	public Project(String name, int projectID, String brief, int pledged,
			int daysToGo, String description, String link, String FAQ) {
		this.name = name;
		this.projectID = projectID;
		this.brief = brief;
		this.pledged = pledged;
		this.daysToGo = daysToGo;
		this.description = description;
		this.link = link;
		this.FAQ = FAQ;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String newName) {
		this.name = name;
	}

	public int getProjectID() {
		return projectID;
	}

	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}
	
	public int getPledged() {
		return pledged;
	}

	public void setPledged(int pledged) {
		this.pledged = pledged;
	}

	public int getDaysToGo() {
		return daysToGo;
	}

	public void setDaysToGo(int daysToGo) {
		this.daysToGo = daysToGo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getFAQ() {
		return FAQ;
	}

	public void setFAQ(String fAQ) {
		FAQ = fAQ;
	}

}








