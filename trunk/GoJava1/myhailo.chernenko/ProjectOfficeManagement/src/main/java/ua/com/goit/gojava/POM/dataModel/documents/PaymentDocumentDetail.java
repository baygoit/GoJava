package ua.com.goit.gojava.POM.dataModel.documents;

import java.util.Currency;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import ua.com.goit.gojava.POM.dataModel.POMDataModelException;
import ua.com.goit.gojava.POM.dataModel.common.Money;
import ua.com.goit.gojava.POM.dataModel.profitcost.CostItem;
import ua.com.goit.gojava.POM.dataModel.profitcost.Project;
import ua.com.goit.gojava.POM.dataModel.profitcost.ProjectStage;

@Entity
@Table(name = "payment_document_details")
public class PaymentDocumentDetail {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "project_id")
	private Project project;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "project_stage_id")
	private ProjectStage projectStage;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cost_item_id")
	private CostItem costItem;
	
	@Embedded
	@AttributeOverrides( {
	        @AttributeOverride(name="value", column = @Column(name="sum") ),
	        @AttributeOverride(name="currency", column = @Column(name="currency") )
	    })
    private Money sum;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "doc_id")
	private PaymentDocument doc;
	
	@Transient
	private boolean markedForDelete = false;
	
	@Column
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
