package ua.com.goit.gojava.POM.dataModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;




import ua.com.goit.gojava.POM.persistence.DataManager;

public class TransactionsStore implements DataObject, Serializable {

	private static final int NUMER_OF_REQUIRED_PARAM = 3;

	private static final long serialVersionUID = 2466728848243498110L;
	
	private List<BusinessTransaction> transactionList = new ArrayList<BusinessTransaction>();

	private String checkData(String[] fieldsArray) {
		
		String checkResult = "";
		
		if (fieldsArray.length != NUMER_OF_REQUIRED_PARAM) {
			
			checkResult = "Wrong number of variables";
			
		} else {
			
			try {
				
				Long.parseLong(fieldsArray[2]);
				
			} catch (NumberFormatException e) {		
			
				//Logger.getLogger("TransactionsStore.class").log(Level.SEVERE , "Cannot convert entered sum to int!");
				checkResult = "Cannot convert entered sum to int!";
				
			}
			
		}
		
		return checkResult;
		
	}

	@Override
	public String toString() {
		
		String resultString = "";
		
		resultString = resultString.concat(BusinessTransaction.getTitle());
		
		for (BusinessTransaction transaction :transactionList) {
		
			resultString = resultString.concat("\r\n");
			resultString = resultString.concat(transaction.toString());
			
		}
		
		return resultString;
		
	}
	
	@Override
	public String getFieldsForUpdatePresentation() {
		
		return "Project, Cost item and Sum";

	}

	@Override
	public String update(String[] fieldsArray, DataManager dataManager) {

		String checkResult = checkData(fieldsArray);
		if (checkResult.isEmpty()) {
			
			long sum = 0;
			
			try {
				
				sum =  Long.parseLong(fieldsArray[2]);
				
			} catch (NumberFormatException e) {
				
			}
			
			transactionList.add( new BusinessTransaction(dataManager.getProject(fieldsArray[0]), 
                										dataManager.getCostItem(fieldsArray[1]),
                										sum));
		}
		
		return checkResult;
		
	}

}
