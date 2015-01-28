package ua.com.goit.gojava.POM.persistence;

import java.util.List;

public interface DAOFactory {
	
	public void saveObject(DataObject obj, String key);
	public void deleteObject(DataObject obj, String key);
	public List<DataObject> getObjectList(String key);
	
}
