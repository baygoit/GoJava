package ua.com.goit.gojava.POM.dataModel.profitCostSubsystem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
//import ua.com.goit.gojava.POM.persistence.DataManager;









import ua.com.goit.gojava.POM.dataModel.common.FinancialDocument;
import ua.com.goit.gojava.POM.persistence.abstraction.DataObject;

public class CostItem implements DataObject , Serializable {
	
	private static final long serialVersionUID = -6737879737443630451L;
	private long id = 0;
	private String name = "";
	private ProfitLostsType type = ProfitLostsType.LOSTS;
	private CostItem parent;
	private List<CostItemTransaction> transactions = new ArrayList<CostItemTransaction>();
	
	public long getId() {
		
		return id;
		
	}
	
	public void setId(long id) {
		
		this.id = id;
		
	}
	
	public String getName() {
		
		return name;
		
	}
	
	public void setName(String name) {
		
		this.name = name;
		
	}
	
	public ProfitLostsType getType() {
		
		return type;
		
	}
	
	public void setType(ProfitLostsType type) {
		
		this.type = type;
		
	}
	
	public CostItem getParent() {
		
		return parent;
		
	}
	
	public void setParent(CostItem parent) {
		
		this.parent = parent;
		
	}
	
	public List<CostItemTransaction> getTransactions() {
		
		return transactions;
		
	}
	
	public CostItemTransaction addTransaction() {
		
		CostItemTransaction transaction = new CostItemTransaction();
		transactions.add(transaction);
		return transaction;
		
	}
	
	public void deleteDocTransaction(FinancialDocument doc) {
		
		for (int i = transactions.size() - 1; i >= 0 ; i--) {
			if (transactions.get(i).getDoc() == doc) {
				transactions.remove(i);
			}
		}
		
	}
	
	public long getProfit() {

		long result = 0;
		for (CostItemTransaction transaction:getTransactions()) {
			
			result += transaction.getSum();
			
		}
		
		return result;
		
	}

}