package ua.com.goit.gojava.POM.persistence.fileDB;


public class LazyDataManager {

	private static DAOFactory dataManager;
	
	private LazyDataManager(){

	}

	public static DAOFactory getInstance(){
		
	    if (dataManager == null) {
	    	
	    	dataManager = new DataManager();
	    	
	    }
	    
		return dataManager;
	      
	}

}
