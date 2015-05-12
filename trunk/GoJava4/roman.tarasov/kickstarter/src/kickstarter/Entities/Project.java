package kickstarter.Entities;


public class Project {
	public String name = "null";
	public String description = "null";
	public String shortDescription = "null";
	public String history = "null";
	public int id;
	public int goal;
	public int pledged;
	public int daysToGo;
	public Category category;
	public String linkToVideo="null";

	public Project(String name, Category category) {
		this.name = name;
		this.category = category;
	}
}
