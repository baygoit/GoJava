package ua.com.goit.gojava.myshko;

import java.io.Serializable;

class BusinessTransaction implements Serializable {
	
	private static final long serialVersionUID = 2628805920953022724L;

	private static final int COLUMN_LENGTH = 20;
	
	private String projectName;
	private String costItem;
	private long sum;
	
	public BusinessTransaction(String projectName, String costItem, long sum) {

		this.projectName = projectName;
		this.costItem = costItem;
		this.sum = sum;
	}
	
	public static void showTitle() {
		
		String formatString = "%-" + (COLUMN_LENGTH) + "s"; 
		System.out.format(formatString,"Project name");
		System.out.format(formatString,"Cost item name");
		System.out.format(formatString,"Sum");
		
		System.out.println("");
		for (int i = 0; i < COLUMN_LENGTH *3; i++) {
			System.out.print("-");
		}
		System.out.println("");
		
	}
	
	public void show() {
		
		String formatString = "%-" + (COLUMN_LENGTH) + "s"; 
		System.out.format(formatString,"" + projectName);
		System.out.format(formatString,"" + costItem);
		
		formatString = "%" + (COLUMN_LENGTH) + "s"; 
		System.out.format(formatString,"" + sum);
		
		System.out.println("");
		
	}
	
}
