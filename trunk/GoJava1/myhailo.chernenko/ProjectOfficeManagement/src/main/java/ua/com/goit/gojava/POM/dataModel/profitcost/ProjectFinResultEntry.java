package ua.com.goit.gojava.POM.dataModel.profitcost;

import java.util.Currency;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.MetaValue;

import ua.com.goit.gojava.POM.dataModel.common.FinancialDocument;
import ua.com.goit.gojava.POM.dataModel.common.Money;
import ua.com.goit.gojava.POM.dataModel.documents.PaymentDocument;

@Entity
@Table(name = "project_fin_result")
public class ProjectFinResultEntry {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
    private Date date;
	
	@Column(name = "profit_type")
	@Enumerated(EnumType.STRING)
	private ProfitLostsType type;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cost_item_id")
	private CostItem costItem;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "project_id")
	private Project project;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "project_stage_id")
	private ProjectStage projectStage;
	
	@Embedded
	@AttributeOverrides( {
	        @AttributeOverride(name="value", column = @Column(name="sum") ),
	        @AttributeOverride(name="currency", column = @Column(name="currency") )
	    })
    private Money sum;
	
	@Any(metaColumn = @Column(name = "doc_type"))
    @AnyMetaDef(idType = "long", metaType = "string", 
            metaValues = { 
            @MetaValue(targetEntity = PaymentDocument.class, value = "PaymentDocument"),
       })
	@JoinColumn(name="doc_id")
    private FinancialDocument doc;
	
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
	public FinancialDocument getDoc() {
		return doc;
	}
	public void setDoc(FinancialDocument doc) {
		this.doc = doc;
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
		return new Money(sum);
	}
	public void setSum(Money sum) {
		this.sum = new Money(sum);
	}
	public ProfitLostsType getType() {
		return type;
	}
	public void setType(ProfitLostsType type) {
		this.type = type;
	}
	
	public Currency getCurrency() {	
		return (sum == null) ? null : sum.getCurrency();
	}
}
