package go_java_4.vladyslav_averyanov.kickstarter;

public class Category {

	private String name;
	private String shortDescripotion;
	private Project[] projects;

	public Category(String name, String shortDescripotion) {
		this.name = name;
		this.shortDescripotion = shortDescripotion;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortDescripotion() {
		return shortDescripotion;
	}

	public void setShortDescripotion(String shortDescripotion) {
		this.shortDescripotion = shortDescripotion;
	}

	public Project[] getProjects() {
		return projects;
	}

	public void setProjects(Project[] projects) {
		this.projects = projects;
	}

}
