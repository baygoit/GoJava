package kickstarter.entities;

public class Project {
	public String name = "null";
	public String description = "null";
	public String shortDescription = "null";
	public String history = "null";
	public int ID;
	public int goal;
	public int pledged;
	public int daysToGo;
	public String linkToVideo = "null";
	public int categoryID;

	public Project(String name, Category category) {
		this.name = name;
		this.categoryID = category.ID;
	}
}
