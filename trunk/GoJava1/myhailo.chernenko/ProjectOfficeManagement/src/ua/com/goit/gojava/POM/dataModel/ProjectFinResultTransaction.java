package ua.com.goit.gojava.POM.dataModel;

import java.util.Date;
import java.io.Serializable;

public class ProjectFinResultTransaction implements Serializable {
	
	private static final long serialVersionUID = 2510846589492989967L;
	private long id;
	private Date date;
	private CostItem costItem;
	private String description;
	private long sum;
	private FinanceDocument doc;
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getSum() {
		return sum;
	}
	public void setSum(long sum) {
		this.sum = sum;
	}
	public FinanceDocument getDoc() {
		return doc;
	}
	public void setDoc(FinanceDocument doc) {
		this.doc = doc;
	}
	
}
