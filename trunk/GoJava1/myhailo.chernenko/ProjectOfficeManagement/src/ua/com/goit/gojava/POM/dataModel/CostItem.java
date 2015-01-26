package ua.com.goit.gojava.POM.dataModel;

import java.io.Serializable;
import java.util.List;
//import ua.com.goit.gojava.POM.persistence.DataManager;

import ua.com.goit.gojava.POM.persistence.DataObject;

public class CostItem implements DataObject , Serializable {
	
	private static final long serialVersionUID = -6737879737443630451L;
	private long id;
	private String name;
	private ProfitLostsType type;
	private CostItem parent;
	private List<CostItemTransaction> transactions;
	
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
	
	public void addTransaction() {
		
		CostItemTransaction transaction = new CostItemTransaction();
		transactions.add(transaction );
		
	}
	
	public long getProfit() {

		long result = 0;
		for (CostItemTransaction transaction:getTransactions()) {
			
			result += transaction.getSum();
			
		}
		
		return result;
		
	}

}