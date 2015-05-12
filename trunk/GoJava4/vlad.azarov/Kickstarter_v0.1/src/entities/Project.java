package entities;

public class Project {

	private String name;
	private String brief;
	private int goal;
	private int pledged;
	private int daysToGo;
	private String description;
	private String link;
	private String FAQ;

	public Project(String name, String brief, int goal, int pledged,
			int daysToGo, String description, String link, String FAQ) {
		this.name = name;
		this.brief = brief;
		this.goal = goal;
		this.pledged = pledged;
		this.daysToGo = daysToGo;
		this.description = description;
		this.link = link;
		this.FAQ = FAQ;
	}

	public String getName() {
		return name;
	}

	public String getBrief() {
		return brief;
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

	public String getDescription() {
		return description;
	}

	public String getLink() {
		return link;
	}

	public String getFAQ() {
		return FAQ;
	}

}
