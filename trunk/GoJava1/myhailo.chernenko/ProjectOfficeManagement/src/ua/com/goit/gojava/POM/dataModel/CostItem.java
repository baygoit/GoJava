package ua.com.goit.gojava.POM.dataModel;

import java.io.Serializable;

public class CostItem implements Serializable {
	
	private static final long serialVersionUID = 7049033229302103132L;
	private String shortName;

	public CostItem(String shortName) {
	
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