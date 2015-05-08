package kickstarter;

public class Project {
	String name = "null";
	String description = "null";
	String history = "null";
	int id;
	int goal;
	int pledged;
	int expireDate;
	Category category;

	public Project(String name, Category category) {
		this.name = name;
		this.category = category;
	}
}
