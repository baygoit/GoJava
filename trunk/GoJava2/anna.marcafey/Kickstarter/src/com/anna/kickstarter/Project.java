package com.anna.kickstarter;

public class Project {

	 private String name;
	 private String description;
	 private int funded;
	 private int pledged;
	 private int daysToGo;
	 private String longDescription;
	 private String history;
	 private String linkToVideo;
	 private String faq;
	    
	 public Project(String name, String description, int funded, int pledged, int daysToGo) {
		 this.name = name;
	     this.description = description;
	     this.funded = funded;
	     this.pledged = pledged;
	     this.daysToGo = daysToGo;
	 }
}
