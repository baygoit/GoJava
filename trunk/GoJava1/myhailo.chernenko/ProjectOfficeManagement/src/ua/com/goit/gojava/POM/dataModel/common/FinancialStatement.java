package ua.com.goit.gojava.POM.dataModel.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ua.com.goit.gojava.POM.persistence.*;

public abstract class FinancialStatement<T extends FinancialEntry> implements Serializable {
	
	private Class<T> classT;
	private static final long serialVersionUID = 1799899656753465204L;
	//private long id = 0;
	private List<T> financialEntries = new ArrayList<T>();
	
	public FinancialStatement(Class<T> classT) {
	
		this.classT = classT;
		
	}
	
	public abstract FinancialStatement<T> getNewInstanse();
	
	public T getNewEntryInstance() {
		
		T entry = null;
		try {
			entry = classT.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			//e.printStackTrace();
		}
		
		return entry;
	}

	/*
	public long getId() {
		
		return id;
		
	}
	
	public void setId(long id) {
		
		this.id = id;
		
	}
	*/
	
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
	
	public void deleteDocEntries(FinancialDocument doc) {
		
		for (int i = financialEntries.size() - 1; i >= 0 ; i--) {
			if (financialEntries.get(i).getDoc() == doc) {
				financialEntries.remove(i);
			}
		}
		
	}
	
	public Money getTotal(FinancialCharacteristic characteristic, Currency currency) {

		Money result = new Money(0.0, currency);
		
		for (FinancialEntry entry:getEntries()) {
			
			if( (entry.getCharacteristic() == characteristic) || (characteristic == null)) {
				
				Money currentSum = entry.getSum();
				
				ExchangeRate currentRate = (new ExchangeRateDAO(LazyDataManager.getInstance()).getLastOnDate(
						entry.getDate(), currentSum.getCurrency(), currency));
				
				result.add(currentSum, currentRate);
				
			}
			
		}
		
		return result;
		
	}
	
	public FinancialStatement<T> getRolledUp(int roundindMode) {
		
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
				newEntry.setSum(new Money(0.0, currentSum.getCurrency()));
				financialEntriesMap.put(roundedDate, newEntry);
				
			}
			
			newEntry.setDate(roundedDate);
			newEntry.setCharacteristic(entry.getCharacteristic());
			Money entriesSum = newEntry.getSum();
			
			ExchangeRate currentRate = (new ExchangeRateDAO(LazyDataManager.getInstance()).getLastOnDate(
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

	public FinancialStatement<T> getDifference(FinancialStatement<T> financialStatement, int roundindMode) {
		
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

}