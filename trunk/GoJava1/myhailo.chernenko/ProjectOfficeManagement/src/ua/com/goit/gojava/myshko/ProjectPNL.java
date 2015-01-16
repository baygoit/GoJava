package ua.com.goit.gojava.myshko;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

class ProjectPNL {

	private static final String DATA_FILE = "C:\\workspace\\ProjectOfficeManagement.dat";
	private List<BusinessTransaction> transactionList = new ArrayList<BusinessTransaction>();
	
	public ProjectPNL() {

		try {
			readTransactionList();
		} catch (Throwable e) {
			
			//Logger.getLogger("ProjectOfficeManagement.class").log(Level.SEVERE , "Cannot read ProjectPNL!");
			//e.printStackTrace();
			Logger.getLogger("ProjectPNL.class").log(Level.SEVERE , "Cannot read Data File! File will be created or overriden");	
		}
		
	}

	private void saveTransactionList() throws IOException {
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			
			fos = new FileOutputStream(DATA_FILE);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(transactionList);
			oos.close();
			fos.close();
				
		} catch (IOException e) {
			
			Logger.getLogger("ProjectPNL.class").log(Level.SEVERE , "Cannot save ProjectPNL!");
			//e.printStackTrace();
			throw e;
		}
		
	}
	
	private void readTransactionList() throws Throwable {
		
		FileInputStream fis;
		ObjectInputStream ois;
		try {
			
			fis = new FileInputStream(DATA_FILE);
			ois = new ObjectInputStream(fis);
			Object obj = ois.readObject();
					
			if(obj instanceof ArrayList<?> ) {
				transactionList = (ArrayList <BusinessTransaction>) obj;
			}
		
			ois.close();
			fis.close();
			
		} catch (IOException | ClassNotFoundException e) {
			
			throw e;
		}
		
	}

	public void show() {
		
		BusinessTransaction.showTitle();
		
		for (int i = 0; i < transactionList.size(); i++) {
		
			transactionList.get(i).show();
			
		}
		
	}
	
	public void update() {
		
		System.out.println("Input Project, Cost item and Sum, separated by '; ' and press Enter or press Enter for exit");
		
		Scanner sc = new Scanner(System.in); 
		while (sc.hasNextLine()) {
			
			String enteredString = sc.nextLine();
			
			if (enteredString.isEmpty()) {
				break;
			}
			
			String[] enteredStringArray = enteredString.split("; ");
			
			if (enteredStringArray.length != 3) {
				System.out.println("You can input 3 value, separated by '; ': Project, Cost item and Sum !");
			} else {
				
				long sum = 0;
				
				try {
					sum =  Integer.parseInt(enteredStringArray[2]);
				} catch (NumberFormatException e) {		

					Logger.getLogger("Division.class").log(Level.SEVERE , "Cannot convert entered sum to int!");
					continue;
				}
				
				transactionList.add( new BusinessTransaction(enteredStringArray[0], enteredStringArray[1], sum));
				
			}
		
		};
		
		sc.close();
		
		try {
			saveTransactionList();
		} catch (IOException e) {
			
		} 
		
	}

}
