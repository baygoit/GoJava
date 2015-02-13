package ua.com.goit.gojava.POM.dataModel;

import java.io.Serializable;
import java.util.ArrayList;
//import java.util.Currency;
import java.util.List;
//import ua.com.goit.gojava.POM.persistence.DataManager;

public class CashFlowStatement implements Serializable {
	
	private static final long serialVersionUID = 1799899656753465204L;
	private long id = 0;
	private List<CashFlowStatementEntry> cashFlowStatementEntries = new ArrayList<CashFlowStatementEntry>();
	
	public long getId() {
		
		return id;
		
	}
	
	public void setId(long id) {
		
		this.id = id;
		
	}
	
	public List<CashFlowStatementEntry> getEntries() {
		
		return cashFlowStatementEntries;
		
	}
	
	public CashFlowStatementEntry addEntry() {
		
		CashFlowStatementEntry entry = new CashFlowStatementEntry();
		cashFlowStatementEntries.add(entry);
		return entry;
		
	}
	
	public void deleteDocEntries(FinanceDocument doc) {
		
		for (int i = cashFlowStatementEntries.size() - 1; i >= 0 ; i--) {
			if (cashFlowStatementEntries.get(i).getDoc() == doc) {
				cashFlowStatementEntries.remove(i);
			}
		}
		
	}
	
	public Money getTotal(BankAccount bankAccount) {

		Money result = new Money(0.0, bankAccount.getCurrency());
		
		for (CashFlowStatementEntry entry:getEntries()) {
			
			if(entry.getBankAccount() == bankAccount) {
				
				result.add(entry.getSum(), null);
				
			}
			
		}
		
		return result;
		
	}

}