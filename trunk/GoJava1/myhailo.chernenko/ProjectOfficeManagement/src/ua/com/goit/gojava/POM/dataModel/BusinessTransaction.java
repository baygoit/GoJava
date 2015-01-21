package ua.com.goit.gojava.POM.dataModel;

import java.io.Serializable;

class BusinessTransaction implements Serializable {
	
	private static final long serialVersionUID = -2555250596540838902L;
	private static final int NUMBER_OF_FIELDS = 3;
	private static final int COLUMN_LENGTH = 20;
	
	private Project project;
	private CostItem costItem;
	private long sum;
	
	public BusinessTransaction(String projectName, String costItem, long sum) {

		this.project = new Project(projectName);
		this.costItem = new CostItem(costItem);
		this.sum = sum;
	}
	
	public static String getTitle() {
		
		String formatString = "%-" + (COLUMN_LENGTH) + "s"; 
		String resultString = "";
		
		resultString = resultString.concat(String.format(formatString, "Project name"));
		resultString = resultString.concat(String.format(formatString, "Cost item name"));
		resultString = resultString.concat(String.format(formatString, "Sum"));

		resultString = resultString.concat("\r\n");
		for (int i = 0; i < COLUMN_LENGTH * NUMBER_OF_FIELDS; i++) {
			resultString = resultString.concat("-");
		}
		
		return resultString;
		
	}
	
	public String toString() {
		
		String formatString = "%-" + (COLUMN_LENGTH) + "s"; 
		String resultString = "";
		
		resultString = resultString.concat(String.format(formatString, "" + project.toString()));
		resultString = resultString.concat(String.format(formatString, "" + costItem.toString()));
		
		formatString = "%" + (COLUMN_LENGTH) + "s"; 
		resultString = resultString.concat(String.format(formatString, "" + sum));
		
		return resultString;
	}
	
}
