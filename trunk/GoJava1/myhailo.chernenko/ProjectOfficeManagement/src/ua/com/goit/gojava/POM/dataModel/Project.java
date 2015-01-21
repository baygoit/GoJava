package ua.com.goit.gojava.POM.dataModel;

import java.io.Serializable;

public class Project implements Serializable {
	
	private static final long serialVersionUID = 9089675474277705813L;
	private String shortName;

	public Project(String shortName) {
		
		setShortName(shortName);
		
	}

	private void setShortName(String shortName) {
		
		this.shortName = shortName;
		
	}
	
	public String getShortName() {
		
		return shortName;
		
	}
	
	public String toString() {
	
		return getShortName();
		
	}

}