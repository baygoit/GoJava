package ua.com.goit.gojava.POM.dataModel.temporaryUnusedClases;

/*import java.io.Serializable;
import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Currency;
//import java.util.Date;
//import java.util.HashMap;
import java.util.List;
//import java.util.Map;






//import ua.com.goit.gojava.POM.dataModel.POMDataModelException;
import ua.com.goit.gojava.POM.dataModel.POMDataModelRuntimeException;
//import ua.com.goit.gojava.POM.persistence.abstraction.*;
import ua.com.goit.gojava.POM.persistence.fileDB.DAOFactory;
import ua.com.goit.gojava.POM.persistence.fileDB.LazyDataManager;
//import ua.com.goit.gojava.POM.persistence.postgresDB.ExchangeRateDAO;
*/
public abstract class FinancialStatement {//<T extends FinancialEntry> implements Serializable {
	
	/*private Class<T> classT;
	private static final long serialVersionUID = 1799899656753465204L;
	private List<T> financialEntries = new ArrayList<T>();
	
	public FinancialStatement(Class<T> classT) {
	
		this.classT = classT;
		
	}
	
	public abstract FinancialStatement<T> getNewInstanse();
	
	public DAOFactory getDataManager() {
		
		return LazyDataManager.getInstance();
	}
	
	public T getNewEntryInstance() {
		
		T entry = null;
		try {
			entry = classT.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			
			throw new POMDataModelRuntimeException("Can't create new financial entry from financial statement", e);
		}
		
		return entry;
	}

	public List<T> getEntries() {
		
		return financialEntries;
		
	}
	
	public T addEntry() {
		
		T entry = getNewEntryInstance();
		
		List<T> objectsList = getEntries();
		long newID = 1;
		if(objectsList.size() != 0) {
			T lastElement = objectsList.get(objectsList.size()-1);
			newID = (lastElement == null) ? 1 : lastElement.getId()+1;
		}
		entry.setId(newID);
		
		financialEntries.add(entry);
		return entry;
		
	}
	
	/*public void deleteDocEntries(FinancialDocument doc) {
		
		for (int i = financialEntries.size() - 1; i >= 0 ; i--) {
			if (financialEntries.get(i).getDoc() == doc) {
				financialEntries.remove(i);
			}
		}
		
	}
	
	public void deleteEntryById(long id) {
		
		for (int i = financialEntries.size() - 1; i >= 0 ; i--) {
			if (financialEntries.get(i).getId() == id) {
				financialEntries.remove(i);
			}
		}
		
	}
	
	/*public Money getTotal(FinancialCharacteristic characteristic, Currency currency) throws POMDataModelException {

		Money result = new Money(currency);
		
		for (FinancialEntry entry:getEntries()) {
			
			if( (entry.getCharacteristic() == characteristic) || (characteristic == null)) {
				
				Money currentSum = entry.getSum();
				
				ExchangeRate currentRate = null;
						// TODO rewrite
						//= (new ExchangeRateDAO(getDataManager()).getLastOnDate(
						//entry.getDate(), currentSum.getCurrency(), currency));
				
				result.add(currentSum, currentRate);
				
			}
			
		}
		
		return result;
		
	}*/
	
	// TODO think about this methods.. 
	/*
	public FinancialStatement<T> getRolledUp(int roundindMode) throws POMDataModelException {
		
		FinancialStatement<T> result = getNewInstanse();
		
		Map<Date, T> financialEntriesMap = new HashMap<Date,T>();
		
		for(FinancialEntry entry: getEntries()) {
		
			Money currentSum = entry.getSum();
			Date roundedDate = DateConvertor.roundDate(entry.getDate(), roundindMode);
			T newEntry;
			
			if(financialEntriesMap.containsKey(roundedDate)) {
				
				newEntry = financialEntriesMap.get(roundedDate);
				
			} else {
				
				newEntry = getNewEntryInstance();
				newEntry.setSum(new Money(currentSum.getCurrency()));
				financialEntriesMap.put(roundedDate, newEntry);
				
			}
			
			newEntry.setDate(roundedDate);
			newEntry.setCharacteristic(entry.getCharacteristic());
			Money entriesSum = newEntry.getSum();
			
			ExchangeRate currentRate = (new ExchangeRateDAO(getDataManager()).getLastOnDate(
					entry.getDate(), currentSum.getCurrency(), entriesSum.getCurrency()));
			
			entriesSum.add(currentSum, currentRate);
		
		}
		
		for(FinancialEntry entry: financialEntriesMap.values()){
			
			FinancialEntry newEntry = result.addEntry();
			newEntry.setDate(entry.getDate());
			newEntry.setCharacteristic(entry.getCharacteristic());
			newEntry.setSum(entry.getSum());
			
		}
		
		return result;
		
	}

	public FinancialStatement<T> getDifference(FinancialStatement<T> financialStatement, int roundindMode) throws POMDataModelException {
		
		FinancialStatement<T> result = getNewInstanse();
		
		for(FinancialEntry entry: getEntries()) {
		
			FinancialEntry newEntry = result.addEntry();
			newEntry.setDate(entry.getDate());
			newEntry.setCharacteristic(entry.getCharacteristic());
			newEntry.setSum(entry.getSum());
			
		}
		
		for(FinancialEntry entry: financialStatement.getEntries()) {
			
			FinancialEntry newEntry = result.addEntry();
			newEntry.setDate(entry.getDate());
			newEntry.setCharacteristic(entry.getCharacteristic());
			newEntry.setSum(entry.getSum());
			
			newEntry.getSum().multiply(-1L);
			
		}
		
		return result.getRolledUp(roundindMode);
		
	}
	
	*/

}