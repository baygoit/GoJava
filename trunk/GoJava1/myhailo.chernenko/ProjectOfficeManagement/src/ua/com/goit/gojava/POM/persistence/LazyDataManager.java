package ua.com.goit.gojava.POM.persistence;

public class LazyDataManager {

	private static DataManager dataManager;
	
	private LazyDataManager(){

	}

	public static DataManager getInstance(){
		
	    if (dataManager == null) {
	    	
	    	dataManager = new DataManager();
	    	
	    }
	    
		return dataManager;
	      
	}

}
