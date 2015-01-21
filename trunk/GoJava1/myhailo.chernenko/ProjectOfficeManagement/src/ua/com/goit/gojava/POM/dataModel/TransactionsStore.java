package ua.com.goit.gojava.POM.dataModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;

public class TransactionsStore implements DataObject, Serializable {

	private static final int NUMER_OF_REQUIRED_PARAM = 3;

	private static final long serialVersionUID = 2466728848243498110L;
	
	private List<BusinessTransaction> transactionList = new ArrayList<BusinessTransaction>();

	private String checkData(String[] fieldsArray) {
		
		String checkResult = "";
		
		if (fieldsArray.length != NUMER_OF_REQUIRED_PARAM) {
			
			checkResult = "Wrong number of variables";
			
		}
		
		return checkResult;
		
	}

	public String toString() {
		
		String resultString = "";
		
		resultString = resultString.concat(BusinessTransaction.getTitle());
		
		for (BusinessTransaction transaction :transactionList) {
		
			resultString = resultString.concat("\r\n");
			resultString = resultString.concat(transaction.toString());
			
		}
		
		return resultString;
		
	}
	
	public String getFieldsForUpdatePresentation() {
		
		return "Project, Cost item and Sum";

	}

	public String update(String[] fieldsArray) {

		String checkResult = checkData(fieldsArray);
		if (checkResult.isEmpty()) {
			
			long sum = 0;
			boolean isDataCorrect = false; 
			
			try {
				sum =  Integer.parseInt(fieldsArray[2]);
				isDataCorrect = true;
				
			} catch (NumberFormatException e) {		
				
				//Logger.getLogger("TransactionsStore.class").log(Level.SEVERE , "Cannot convert entered sum to int!");
				checkResult = "Cannot convert entered sum to int!";
				
			}
			
			if(isDataCorrect) {
				
                transactionList.add( new BusinessTransaction(fieldsArray[0], fieldsArray[1], sum));
			}

		}
		
		return checkResult;
		
	}

}
