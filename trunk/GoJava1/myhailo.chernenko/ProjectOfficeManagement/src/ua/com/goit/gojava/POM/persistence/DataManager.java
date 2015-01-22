package ua.com.goit.gojava.POM.persistence;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import ua.com.goit.gojava.POM.dataModel.*;

public class DataManager implements Serializable {

	private static final long serialVersionUID = 5073603663447554094L;

	private static final String DATA_FILE = "C:\\workspace\\ProjectOfficeManagement.dat";
	
	private Map<String, Project> projectList; 
	private Map<String, CostItem> costItemList; 
	private TransactionsStore transactionsData;
	
	public DataManager() {
		
		this.projectList = new HashMap<String, Project>();
		this.costItemList = new HashMap<String, CostItem>();
		this.transactionsData = new TransactionsStore();
		
		readData();
		
	}
	
	public Map<String, Project>  getProjectMap() {
		
		return projectList;
		
	}
	
	public Project getProject(String projectID) {
		
		Project findedProject = projectList.get(projectID);
		if (findedProject == null) {
			
			findedProject = new Project(projectID);
			projectList.put(projectID, findedProject);
			
		}
		
		return findedProject;
		
	}

	public Map<String, CostItem> getCostItemMap() {
		
		return costItemList;
		
	}
	
	public CostItem getCostItem(String costItemID) {
		
		CostItem findedCostItem = costItemList.get(costItemID);
		if (findedCostItem == null) {
			
			findedCostItem = new CostItem(costItemID);
			costItemList.put(costItemID, findedCostItem);
			
		}
		
		return findedCostItem;
	}

	public TransactionsStore getTransactionsStore() {
		
		return transactionsData;
		
	}

	public void readData() {
		
		FileInputStream fis;
		ObjectInputStream ois;
		try {
			
			fis = new FileInputStream(DATA_FILE);
			ois = new ObjectInputStream(fis);
			Object obj = ois.readObject();
					
			if(obj instanceof DataManager ) {
				
				DataManager restoredDataManager = (DataManager) obj;
				
				this.costItemList = restoredDataManager.getCostItemMap();
				this.projectList = restoredDataManager.getProjectMap();
				this.transactionsData = restoredDataManager.getTransactionsStore();
				
			}
		
			ois.close();
			fis.close();
			
		} catch (IOException | ClassNotFoundException e) {
			
			Logger.getLogger("DataManager.class").log(Level.SEVERE , "Cannot read program data!");
		
		}
		
	}
	
	public void saveData() {
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			
			fos = new FileOutputStream(DATA_FILE);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(this);
			oos.close();
			fos.close();
				
		} catch (IOException e) {
			
			Logger.getLogger("DataManager.class").log(Level.SEVERE , "Cannot save TransactionsStore!");
			e.printStackTrace();
			
		}
		
	}
	
}
