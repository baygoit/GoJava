package ua.com.goit.gojava7.kickstarter.models;

public class Project {
	private Long projectId;
	private String name;
	private String description;
	private Long goal;
	private Long pledged;
	private Long daysToGo;
	private String history;
	private String link;
	private Category category = new Category();	

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
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

	public Long getGoal() {
		return goal;
	}

	public void setGoal(Long goal) {
		this.goal = goal;
	}

	public Long getPledged() {
		return pledged;
	}

	public void setPledged(Long pledged) {
		this.pledged = pledged;
	}

	public Long getDaysToGo() {
		return daysToGo;
	}

	public void setDaysToGo(Long daysToGo) {
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Long getCategoryId() {
		return category.getCategoryId();
	}
	
	public void setCategoryId(Long categoryId) {
		category.setCategoryId(categoryId);;
	}
	
	@Override
	public String toString() {
		return "id: " + projectId + "; name: " + name + "; description: " + description + "; goal: " + goal + "; pledged: "
				+ pledged + "; daysToGo: " + daysToGo + "; history: " + history + "; link: " + link + "; categoryId: " + getCategoryId();
	}
}