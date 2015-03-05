package ua.com.goit.gojava.POM.dataModel.temporaryUnusedClases;

//import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import ua.com.goit.gojava.POM.dataModel.cash.BankAccount;
//import ua.com.goit.gojava.POM.dataModel.common.FinancialDocument;
import ua.com.goit.gojava.POM.dataModel.profitcost.CostItem;
import ua.com.goit.gojava.POM.dataModel.profitcost.CostItemTransaction;
import ua.com.goit.gojava.POM.dataModel.profitcost.Project;
import ua.com.goit.gojava.POM.dataModel.profitcost.ProjectFinResultTransaction;
import ua.com.goit.gojava.POM.dataModel.profitcost.ProjectStage;

public class PaymentDocument {// implements FinancialDocument, Serializable {

	//private static final long serialVersionUID = 2985654176742038375L;
	private long id = 0;
	private String number = "";
	private Date date = Calendar.getInstance().getTime();
	private Project project;
	private ProjectStage projectStage;
	private CostItem costItem;
	private BankAccount bankAccount;
	private long sum = 0;
	
	public long getId() {
		
		return id;
		
	}
	
	public void setId(long id) {
		
		this.id = id;
		
	}
	
	public String getNumber() {
		
		return number;
		
	}
	
	public void setNumber(String number) {
		
		this.number = number;
		
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
	
	public long getSum() {
		
		return sum;
		
	}
	
	public void setSum(long sum) {
		
		this.sum = sum;
		
	}
	
	public void generateTransactions() {
		
		deleteTransactions();
		
		if ((project != null)&&(projectStage != null)) {
			
			ProjectFinResultTransaction newTransaction = project.addTransaction(projectStage);
			newTransaction.setDate(date);
			newTransaction.setCostItem(costItem);
			//newTransaction.setDoc(this);
			newTransaction.setSum(sum);
			
		}
		
		if (costItem != null) {
			
			CostItemTransaction newTransaction = costItem.addTransaction();
			newTransaction.setDate(date);
			//newTransaction.setDoc(this);
			newTransaction.setSum(sum);
			
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
}
