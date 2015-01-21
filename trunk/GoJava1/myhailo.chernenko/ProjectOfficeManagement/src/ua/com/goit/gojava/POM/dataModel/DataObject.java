package ua.com.goit.gojava.POM.dataModel;

public interface DataObject {

	public String getFieldsForUpdatePresentation();
	public String update(String [] fieldsArray);
	
}
