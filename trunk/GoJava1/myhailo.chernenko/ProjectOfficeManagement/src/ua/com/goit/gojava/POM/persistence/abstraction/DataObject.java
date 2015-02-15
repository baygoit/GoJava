package ua.com.goit.gojava.POM.persistence.abstraction;

//import ua.com.goit.gojava.POM.persistence.DataManager;

public interface DataObject {

	//public String getFieldsForUpdatePresentation();
	//public String update(String [] fieldsArray, DataManager dataManager);
	public long getId();
	public void setId(long id);
	public String getName();
	public void setName(String name);
	
}
