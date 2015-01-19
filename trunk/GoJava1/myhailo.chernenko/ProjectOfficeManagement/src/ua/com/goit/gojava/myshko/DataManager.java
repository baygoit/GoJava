package ua.com.goit.gojava.myshko;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

class DataManager {

	private static final String DATA_FILE = "C:\\workspace\\ProjectOfficeManagement.dat";
	
	public void saveTransactionsStore(TransactionsStore transactionsData) {
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			
			fos = new FileOutputStream(DATA_FILE);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(transactionsData);
			oos.close();
			fos.close();
				
		} catch (IOException e) {
			
			Logger.getLogger("DataManager.class").log(Level.SEVERE , "Cannot save TransactionsStore!");
		
		}
		
	}
	
	public TransactionsStore readTransactionsStore() {
		
		TransactionsStore transactionsData = new TransactionsStore();
		
		FileInputStream fis;
		ObjectInputStream ois;
		try {
			
			fis = new FileInputStream(DATA_FILE);
			ois = new ObjectInputStream(fis);
			Object obj = ois.readObject();
					
			if(obj instanceof TransactionsStore ) {
				transactionsData = (TransactionsStore) obj;
			}
		
			ois.close();
			fis.close();
			
		} catch (IOException | ClassNotFoundException e) {
			
			Logger.getLogger("DataManager.class").log(Level.SEVERE , "Cannot read TransactionsStore!");
		
		}
		
		return transactionsData;
		
	}
	
}
