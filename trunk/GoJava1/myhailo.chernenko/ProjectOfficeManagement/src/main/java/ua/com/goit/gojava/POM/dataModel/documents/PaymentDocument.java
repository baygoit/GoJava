package ua.com.goit.gojava.POM.dataModel.documents;

import java.util.Date;
import ua.com.goit.gojava.POM.dataModel.cash.BankAccount;
import ua.com.goit.gojava.POM.dataModel.common.Money;
//import ua.com.goit.gojava.POM.dataModel.common.FinancialDocument;
import ua.com.goit.gojava.POM.dataModel.profitcost.CostItem;
import ua.com.goit.gojava.POM.dataModel.profitcost.Project;
//import ua.com.goit.gojava.POM.dataModel.profitcost.ProjectFinResultTransaction;
import ua.com.goit.gojava.POM.dataModel.profitcost.ProjectStage;

public class PaymentDocument {

	private long id;
	private Date date;
	private BankAccount bankAccount;
	private String description;
	private Project project;
	private ProjectStage projectStage;
	private CostItem costItem;
	private Money sum;
	
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
	
	public CostItem getCostItem() {
		
		return costItem;
		
	}
	
	public void setCostItem(CostItem costItem) {
		
		this.costItem = costItem;
		
	}
	
	public BankAccount getBankAccount() {
		
		return bankAccount;
		
	}
	
	public void setBankAccount(BankAccount bankAccount) {
		
		this.bankAccount = bankAccount;
		
	}
	
	public Project getProject() {
		
		return project;
		
	}
	
	public void setProject(Project project) {
		
		this.project = project;
		
	}
	
	public ProjectStage getProjectStage() {
		
		return projectStage;
		
	}
	
	public void setProjectStage(ProjectStage projectStage) {
		
		this.projectStage = projectStage;
		
	}
	
	public Money getSum() {
		
		return sum;
		
	}
	
	public void setSum(Money sum) {
		
		this.sum = sum;
		
	}
	
	public void generateTransactions() {
		
		deleteTransactions();
		
		if ((project != null)&&(projectStage != null)) {
			
			/*ProjectFinResultTransaction newTransaction = project.addTransaction(projectStage);
			newTransaction.setDate(date);
			newTransaction.setCostItem(costItem);
			//newTransaction.setDoc(this);
			newTransaction.setSum(sum);
			*/
		}
		
		if (costItem != null) {
			
			/*CostItemTransaction newTransaction = costItem.addTransaction();
			newTransaction.setDate(date);
			//newTransaction.setDoc(this);
			newTransaction.setSum(sum);
			*/
		}
		
		if (bankAccount != null) {
			
			/*CashFlowStatementEntry newTransaction = bankAccount.addTransaction();
			newTransaction.setDate(date);
			newTransaction.setDoc(this);
			newTransaction.setSum(sum);*/
			
		}
		
	}
	
	public void deleteTransactions() {
		
		if ((project != null)&&(projectStage != null)) {
			
			//projectStage.deleteTransactionByDoc(this);

		}
		
		if (costItem != null) {
			
			//costItem.deleteDocTransaction(this);

		}
		
		if (bankAccount != null) {
			
			//bankAccount.deleteDocTransaction(this);

		}
		
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}
