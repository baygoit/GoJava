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
	
	public void showShortProjectMenu() {
		System.out.println(name);
		System.out.println(brief);
	}
	
}