package ua.com.goit.gojava.POM.dataModel.documents;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ua.com.goit.gojava.POM.dataModel.common.FinancialDocument;
import ua.com.goit.gojava.POM.dataModel.profitCostSubsystem.ProjectFinResultTransaction;

public class FinancialProjectPlan  implements FinancialDocument, Serializable {

	private static final long serialVersionUID = 9135248402300294193L;
	private long id = 0;
	private Date date = Calendar.getInstance().getTime();
	private String description = "";
	private boolean active = true;
	private List<ProjectFinResultTransaction> plannedTransactions = new ArrayList<ProjectFinResultTransaction>();
	
	public long getId() {
		
		return id;
		
	}

	public void setId(long id) {
		
		this.id = id;
		
	}

	public Date getDate() {
		
		return date;
		
	}
	
	public void setDate(Date date) {
		
		this.date = date;
		
	}
	
	public String getDescription() {
		
		return description;
		
	}

	public void setDescription(String description) {
		
		this.description = description;
		
	}

	public boolean isActive() {
		
		return active;
		
	}
	
	public void setActive(boolean active) {
		
		this.active = active;
		
	}
	
	public List<ProjectFinResultTransaction> getPlannedTransactions() {
		
		return plannedTransactions;
		
	}
	
	public ProjectFinResultTransaction addPlannedTransaction() {

		ProjectFinResultTransaction transaction = new ProjectFinResultTransaction();
		plannedTransactions.add(transaction);
		return transaction;
		
	}

	public void deletePlannedTransactions() {
		
		plannedTransactions.clear();
		
	}
	
	public long getPlannedProfit() {

		long result = 0;
		for (ProjectFinResultTransaction planedTransaction:getPlannedTransactions()) {
			
			result += planedTransaction.getSum();
			
		}
		
		return result;
	}

}
