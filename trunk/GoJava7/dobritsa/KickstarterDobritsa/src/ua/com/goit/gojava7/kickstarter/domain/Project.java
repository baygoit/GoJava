package ua.com.goit.gojava7.kickstarter.domain;

public class Project {
	private String name;
	private String description;
	private Integer goal;
	private Integer pledged;
	private Integer daysToGo;
	private String history;
	private String link;
	private String categoryName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getGoal() {
		return goal;
	}

	public void setGoal(Integer goal) {
		this.goal = goal;
	}

	public Integer getPledged() {
		return pledged;
	}

	public void setPledged(Integer pledged) {
		this.pledged = pledged;
	}

	public Integer getDaysToGo() {
		return daysToGo;
	}

	public void setDaysToGo(Integer daysToGo) {
		this.daysToGo = daysToGo;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public void updatePledged(int amount) {
		this.pledged += amount;
	}
}