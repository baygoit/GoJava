package ua.com.goit.gojava7.kickstarter.model;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;

public class Project {
	private String projectName;
	private String projectDescription;
	private double moneyPledged;
	private double moneyNeeded;

	public double getMoneyNeeded() {
		return moneyNeeded;
	}

	public void setMoneyNeeded(double moneyNeeded) {
		this.moneyNeeded = moneyNeeded;
	}

	private Category projectCategory;
	private HashMap<User, Double> backers = new HashMap<>();
	private LocalDateTime enddate;

	public Project() {
		// TODO Auto-generated constructor stub
	}

	public Project(String projectName, String projectDescription, Category projectCategory, LocalDateTime enddate) {
		super();
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.projectCategory = projectCategory;
		this.enddate = enddate;
	}

	public String getProjectEndTime() {
		ZoneId zoneId = ZoneId.systemDefault();
		long epoch = getEnddate().atZone(zoneId).toEpochSecond();
		long time = epoch - System.currentTimeMillis() / 1000;
		String msg = +time + " секунд до окончания";
		if (time >= 86400) {
			msg = (time / 86400) + " дней до окончания";
		} else if ((time >= 3600) && ((time % 3600) == 0)) {
			msg = (time / 60 / 60) + " часов до окончания";

		} else if (time >= 60) {
			msg = (time / 60) + " минут до окончания";
		}
		return msg;
	}

	public void addBacker(User u, Double money) {
		backers.put(u, money);
	}

	public String getFundedPercentage() {
		String percentage = (float) ((getMoneyPledged() * 100) / getMoneyNeeded()) + "%";
		return percentage;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public double getMoneyPledged() {
		return moneyPledged;
	}

	public void setMoneyPledged(double moneyPledged) {
		this.moneyPledged = moneyPledged;
	}

	public Category getProjectCategory() {
		return projectCategory;
	}

	public void setProjectCategory(Category projectCategory) {
		this.projectCategory = projectCategory;
	}

	public HashMap<User, Double> getBackers() {
		return backers;
	}

	public void setBackers(HashMap<User, Double> backers) {
		this.backers = backers;
	}

	public LocalDateTime getEnddate() {
		return enddate;
	}

	public void setEnddate(LocalDateTime enddate) {
		this.enddate = enddate;
	}

}
