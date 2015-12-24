package ua.com.goit.gojava7.kickstarter.models;

public class Project {
	private int id;
	private String name;
	private String description;
	private Integer goal;
	private Integer pledged;
	private Integer daysToGo;
	private String history;
	private String link;
	private int categoryId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "id: " + id + ", name: " + name + ", pledged: " + pledged + ", categoryId: " + categoryId;
	}
}