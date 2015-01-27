package ua.com.goit.gojava.POM.dataModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava.POM.persistence.DataObject;

public class ProjectStage  implements DataObject , Serializable {

	private static final long serialVersionUID = 1143600705771401105L;
	private long id = 0;
	private String name = "";
	private String description = "";
	private List<ProjectFinResultTransaction> transactions = new ArrayList<ProjectFinResultTransaction>();
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ProjectFinResultTransaction> getTransactions() {
		return transactions;
	}
	
	public ProjectFinResultTransaction addTransaction() {

		ProjectFinResultTransaction transaction = new ProjectFinResultTransaction();
		transactions.add(transaction);
		return transaction;
		
	}

	public long getProfit() {

		long result = 0;
		for (ProjectFinResultTransaction transaction:getTransactions()) {
			
			result += transaction.getSum();
			
		}
		
		return result;
	}

}
