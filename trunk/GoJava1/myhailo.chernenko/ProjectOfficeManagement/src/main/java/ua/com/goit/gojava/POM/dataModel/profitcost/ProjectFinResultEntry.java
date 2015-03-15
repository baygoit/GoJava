package ua.com.goit.gojava.POM.dataModel.profitcost;

import java.util.Currency;
import java.util.Date;

import ua.com.goit.gojava.POM.dataModel.common.Money;
//import ua.com.goit.gojava.POM.dataModel.common.FinancialDocument;

public class ProjectFinResultEntry {
	
	private long id;
	private Date date;
	private ProfitLostsType type;
	private CostItem costItem;
	private Project project;
	private ProjectStage projectStage;
	//private String description;
	private Money sum;
	//private FinancialDocument doc;
	
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
	/*public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	/*public FinancialDocument getDoc() {
		return doc;
	}
	public void setDoc(FinancialDocument doc) {
		this.doc = doc;
	}*/
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
	public ProfitLostsType getType() {
		return type;
	}
	public void setType(ProfitLostsType type) {
		this.type = type;
	}
	
	public Currency getCurrency() {
		
		Currency currency = null;
		if(sum != null) {
			currency = sum.getCurrency();
		}
		return currency;
		
	}
}
