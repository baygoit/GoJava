package goit.nz.kickstarter.domain;

public class ProjectEvent {
	private String description;
	private String date;
	
	public ProjectEvent(String description, String date) {
		this.description = description;
		this.date = date;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getDate() {
		return date;
	}
}
