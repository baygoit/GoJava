package ua.com.goit.gojava.POM.persistence;

public interface DAOFactory {
	
	public void saveObject(DataObject obj, String key);
	public void deleteObject(DataObject obj, String key);
	public Object getObjectList(String key);
	
}
