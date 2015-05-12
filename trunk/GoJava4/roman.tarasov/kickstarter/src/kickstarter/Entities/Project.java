package kickstarter.Entities;


public class Project {
	public String name = "null";
	public String description = "null";
	public String history = "null";
	public int id;
	public int goal;
	public int pledged;
	public int expireDate;
	public Category category;

	public Project(String name, Category category) {
		this.name = name;
		this.category = category;
	}
}
