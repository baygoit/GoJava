package ua.com.goit.gojava.POM.dataModel;

import ua.com.goit.gojava.POM.persistence.DataManager;

public interface DataObject {

	public String getFieldsForUpdatePresentation();
	public String update(String [] fieldsArray, DataManager dataManager);
	
}
