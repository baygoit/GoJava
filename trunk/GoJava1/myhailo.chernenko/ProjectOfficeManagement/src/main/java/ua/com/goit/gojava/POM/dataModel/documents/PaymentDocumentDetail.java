package ua.com.goit.gojava.POM.dataModel.documents;

import java.util.Currency;

import ua.com.goit.gojava.POM.dataModel.POMDataModelException;
import ua.com.goit.gojava.POM.dataModel.common.Money;
import ua.com.goit.gojava.POM.dataModel.profitcost.CostItem;
import ua.com.goit.gojava.POM.dataModel.profitcost.Project;
import ua.com.goit.gojava.POM.dataModel.profitcost.ProjectStage;

public class PaymentDocumentDetail {

	private long id;
	private Project project;
	private ProjectStage projectStage;
	private CostItem costItem;
	private Money sum;
	private PaymentDocument doc;
	private boolean markedForDelete = false;
	private long rowNumber; 
	
	public long getId() {		
		return id;	
	}
	
	public void setId(long id) {		
		this.id = id;	
	}
	
	public CostItem getCostItem() {	
		return costItem;	
	}
	
	public void setCostItem(CostItem costItem) {	
		this.costItem = costItem;	
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
		return (sum == null)? null : new Money(sum);
	}
	
	public void setSum(Money sum) throws POMDataModelException {
		
		if (this.sum == null) {
			
			this.sum = new Money(sum);
			
			if(doc != null) {
				doc.addDocSum(sum);
			}
			
		} else {
		
			Money diffForDocSum = new Money(this.sum);
			
			this.sum.add(sum, null);	
			
			diffForDocSum.multiply(-1L);
			diffForDocSum.add(sum);

			if(doc != null) {
				doc.addDocSum(sum);
			}
		}
		
	}

	public PaymentDocument getDoc() {
		return doc;
	}
	
	public void setDoc(PaymentDocument doc) {
		this.doc = doc;
	}
	
	public Currency getCurrency() {
		return (sum == null)? null : sum.getCurrency();
	}

	public boolean isMarkedForDelete() {	
		return markedForDelete;
	}
	
	public void setMarkedForDelete(boolean markedForDelete) {
		this.markedForDelete = markedForDelete;
	}

	public long getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(long rowNumber) {
		this.rowNumber = rowNumber;
	}

}
