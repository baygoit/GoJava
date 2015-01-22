package ua.com.goit.gojava.POM.dataModel;

import java.io.Serializable;

import ua.com.goit.gojava.POM.persistence.DataManager;

public class CostItem implements DataObject, Serializable {
	
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
	
	@Override
	public String toString() {
		
		return getShortName();
		
	}

	@Override
	public String getFieldsForUpdatePresentation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(String[] fieldsArray, DataManager dataManager) {
		// TODO Auto-generated method stub
		return null;
	}

}