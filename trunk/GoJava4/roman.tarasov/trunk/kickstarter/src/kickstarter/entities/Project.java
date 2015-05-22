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
	public String[] investmentOptions;
	public double [] amount ;

	public Project(String name, int categoryID) {
		this.name = name;
		this.categoryID = categoryID;
	}
}
