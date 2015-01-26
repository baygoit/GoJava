package ua.com.goit.gojava.POM.dataModel;

import java.io.Serializable;
import java.util.Date;

public class CostItemTransaction implements Serializable {

	private static final long serialVersionUID = -916804494020185343L;
	private long id;
	private Date date;
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
