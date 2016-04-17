package ua.nenya.domain;


public class Project {
	private int id;
	private int categoryId;
	private String name;
	private String description;
	private int neededAmount;
	private int daysRemain;
	private String history;
	private String video;
	
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getNeededAmount() {
		return neededAmount;
	}

	public int getDaysRemain() {
		return daysRemain;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public void setNeededAmount(int allAmount) {
		this.neededAmount = allAmount;
	}


	public void setDaysRemain(int daysRemain) {
		this.daysRemain = daysRemain;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	
}
