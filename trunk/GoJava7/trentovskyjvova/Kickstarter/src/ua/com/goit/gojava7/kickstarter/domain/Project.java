package ua.com.goit.gojava7.kickstarter.domain;

public class Project {
	private String name;
	private final int id;
	private int categoryId;
	private int daysToGo;
	private String description;
	private String owner;
	private int goal;
	private String linkVideo;

	public Project(String name, int id) {
		setName(name);
		this.id = id;
		setCategoryId(0);
		setDaysToGo(40);
		setDescription("");
		setOwner("");
		setGoal(0);
		setLinkVideo("");
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDaysToGo() {
		return daysToGo;
	}

	public void setDaysToGo(int daysToGo) {
		this.daysToGo = daysToGo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getGoal() {
		return goal;
	}

	public void setGoal(int goal) {
		this.goal = goal;
	}

	public String getLinkVideo() {
		return linkVideo;
	}

	public void setLinkVideo(String linkVideo) {
		this.linkVideo = linkVideo;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getFunded(int pledged) {
		int goal = getGoal();
		return goal == 0 ? 0 : pledged * 100 / goal;
	}
}
