package kickstarter.entities;

import java.io.Serializable;

public class Project implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 266139065309641330L;
	/**
	 * 
	 */
	
	public String name = "null";
	public String description = "null";
	public String shortDescription = "null";
	public String history = "null";
	public int ID;
	public int goal;
	public int pledged;
	public int daysToGo;
	public String linkToVideo = "null";
	public int categoryID;
	public String[] investmentOptions;
	public double [] amount ;

	public Project(String name, int categoryID) {
		this.name = name;
		this.categoryID = categoryID;
	}
}
