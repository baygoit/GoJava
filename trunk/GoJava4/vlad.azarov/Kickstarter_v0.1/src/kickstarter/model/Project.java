package kickstarter.model;

public class Project {

	private String name;
	private String shortDescription;
	private int goal;
	private int pledged;
	private int daysToGo;
	private String fullDescription;
	private String link;
	private Category category;

	public Project(String name, String shortDescription, int goal, int pledged,
			int daysToGo, String fullDescription, String link, Category category) {
		this.name = name;
		this.shortDescription = shortDescription;
		this.goal = goal;
		this.pledged = pledged;
		this.daysToGo = daysToGo;
		this.fullDescription = fullDescription;
		this.link = link;
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public int getGoal() {
		return goal;
	}

	public int getPledged() {
		return pledged;
	}

	public int getDaysToGo() {
		return daysToGo;
	}

	public String getFullDescription() {
		return fullDescription;
	}

	public String getLink() {
		return link;
	}

	public Category getCategory() {
	    return category;
	}
}
