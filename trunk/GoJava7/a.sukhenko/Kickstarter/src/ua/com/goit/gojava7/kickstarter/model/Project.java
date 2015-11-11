package ua.com.goit.gojava7.kickstarter.model;

import java.util.Calendar;
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
	private HashMap<User,Double> backers = new HashMap<>();
	private Calendar enddate;
	public Project() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Project(String projectName, String projectDescription, Category projectCategory, Calendar enddate) {
		super();
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.projectCategory = projectCategory;
		this.enddate = enddate;
	}

	public void addBacker(User u, Double money){
		backers.put(u, money);
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
	public Calendar getEnddate() {
		return enddate;
	}
	public void setEnddate(Calendar enddate) {
		this.enddate = enddate;
	}
	
	
}
