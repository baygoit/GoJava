package kickstarter.model;

public class Project {

	private static int count = 0;
	
	private int projectId;
	private String name;
	private String shortDescription;
	private int goal;
	private int pledged;
	private int daysToGo;
	private String fullDescription;
	private String link;
	private String questions;
	private Category category;

	public Project(String name, String shortDescription, int goal, int pledged,
			int daysToGo, String fullDescription, String link, String questions, Category category) {
		this.projectId = ++count;
		this.name = name;
		this.shortDescription = shortDescription;
		this.goal = goal;
		this.pledged = pledged;
		this.daysToGo = daysToGo;
		this.fullDescription = fullDescription;
		this.link = link;
		this.questions = questions;
		this.category = category;
	}

	public String getFullInfo() {
		return "Project number: " + projectId + "\n" + "Project name: " + name
				+ "\n" + "Short Description: " + shortDescription + "\n"
				+ "Total sum needed: " + goal + "$" + "\n" + "Pledged: "
				+ pledged + "$" + "\n" + "Days to go: " + daysToGo + "\n"
				+ "History: " + fullDescription + "\n" + "Videolink: " + link
				+ "\n" + "Answers and questions: " + questions;
	}
	
	@Override
	public String toString() {
		return "Project number: " + projectId + "\n" + "Project name: " + name
				+ "\n" + "Short Description: " + shortDescription + "\n"
				+ "Total sum needed: " + goal + "$" + "\n" + "Pledged: "
				+ pledged + "$" + "\n" + "Days to go: " + daysToGo + "\n";
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
