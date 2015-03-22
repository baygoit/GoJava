package ua.com.goit.gojava.POM.dataModel.profitcost;

import java.util.Currency;
import java.util.Date;

import ua.com.goit.gojava.POM.dataModel.common.FinancialDocument;
import ua.com.goit.gojava.POM.dataModel.common.Money;

public class ProjectFinResultEntry {
	
	private long id;
	private Date date;
	private ProfitLostsType type;
	private CostItem costItem;
	private Project project;
	private ProjectStage projectStage;
	private Money sum;
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
