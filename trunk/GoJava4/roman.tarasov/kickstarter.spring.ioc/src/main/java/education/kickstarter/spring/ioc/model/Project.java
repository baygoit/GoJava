package education.kickstarter.spring.ioc.model;


public class Project  {
	private String name;
	private String description;
	private String shortDescription;
	private String history;
	private int ID;
	private int goal;
	private double pledged;
	private int daysToGo;
	private String linkToVideo;
	private int categoryID;
	private String[] investmentOptions;
	private Double[] amount;
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

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getGoal() {
		return goal;
	}

	public void setGoal(int goal) {
		this.goal = goal;
	}

	public double getPledged() {
		return pledged;
	}

	public void setPledged(double pledged) {
		this.pledged = pledged;
	}

	public int getDaysToGo() {
		return daysToGo;
	}

	public void setDaysToGo(int daysToGo) {
		this.daysToGo = daysToGo;
	}

	public String getLinkToVideo() {
		return linkToVideo;
	}

	public void setLinkToVideo(String linkToVideo) {
		this.linkToVideo = linkToVideo;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public String[] getInvestmentOptions() {
		return investmentOptions;
	}

	public void setInvestmentOptions(String[] investmentOptions) {
		this.investmentOptions = investmentOptions;
	}

	public Double[] getAmount() {
		return amount;
	}

	public void setAmount(Double[] amount) {
		this.amount = amount;
	}
}
