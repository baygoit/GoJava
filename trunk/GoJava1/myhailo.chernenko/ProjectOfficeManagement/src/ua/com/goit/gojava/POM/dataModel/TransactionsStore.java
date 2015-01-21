package ua.com.goit.gojava.POM.dataModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import ua.com.goit.gojava.POM.presentation.UserScreen;

public class TransactionsStore implements DataObject, Serializable {

	private static final long serialVersionUID = 2466728848243498110L;
	
	private List<BusinessTransaction> transactionList = new ArrayList<BusinessTransaction>();
	
	public String toString() {
		
		String resultString = "";
		
		resultString = resultString.concat(BusinessTransaction.getTitle());
		
		for (BusinessTransaction transaction :transactionList) {
		
			resultString = resultString.concat("\r\n");
			resultString = resultString.concat(transaction.toString());
			
		}
		
		return resultString;
		
	}
	
	public void update(UserScreen userScreen) {
		
		userScreen.showString("Input Project, Cost item and Sum, separated by '; ' and press Enter or press Enter for exit");
		
		String enteredString = userScreen.getString();
		while (!enteredString.isEmpty()) {
			
			String[] enteredStringArray = enteredString.split("; ");
			
			if (enteredStringArray.length != 3) {
				
				userScreen.showString("You can input 3 value, separated by '; ': Project, Cost item and Sum !");
				
			} else {
				
				long sum = 0;
				boolean isDataCorrect = false; 
				
				try {
					sum =  Integer.parseInt(enteredStringArray[2]);
					isDataCorrect = true;
					
				} catch (NumberFormatException e) {		
					
					Logger.getLogger("TransactionsStore.class").log(Level.SEVERE , "Cannot convert entered sum to int!");
				
				}
				
				if(isDataCorrect) {
					transactionList.add( new BusinessTransaction(enteredStringArray[0], enteredStringArray[1], sum));
				}
				
			}
			
			enteredString = userScreen.getString();
		}
		
	}

}
