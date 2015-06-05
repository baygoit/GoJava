package kickstarter.entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
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

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	@XmlElement
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getHistory() {
		return history;
	}

	@XmlElement
	public void setHistory(String history) {
		this.history = history;
	}

	public int getID() {
		return ID;
	}

	@XmlAttribute
	public void setID(int iD) {
		ID = iD;
	}

	public int getGoal() {
		return goal;
	}

	@XmlAttribute
	public void setGoal(int goal) {
		this.goal = goal;
	}

	public double getPledged() {
		return pledged;
	}

	@XmlAttribute
	public void setPledged(double pledged) {
		this.pledged = pledged;
	}

	public int getDaysToGo() {
		return daysToGo;
	}

	@XmlAttribute
	public void setDaysToGo(int daysToGo) {
		this.daysToGo = daysToGo;
	}

	public String getLinkToVideo() {
		return linkToVideo;
	}

	@XmlElement
	public void setLinkToVideo(String linkToVideo) {
		this.linkToVideo = linkToVideo;
	}

	public int getCategoryID() {
		return categoryID;
	}

	@XmlAttribute
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public String[] getInvestmentOptions() {
		return investmentOptions;
	}

	@XmlElement
	public void setInvestmentOptions(String[] investmentOptions) {
		this.investmentOptions = investmentOptions;
	}

	public Double[] getAmount() {
		return amount;
	}

	@XmlAttribute
	public void setAmount(Double[] amount) {
		this.amount = amount;
	}
}
