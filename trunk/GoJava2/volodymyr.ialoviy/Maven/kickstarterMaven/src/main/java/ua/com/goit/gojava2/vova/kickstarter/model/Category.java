package ua.com.goit.gojava2.vova.kickstarter.model;


public class Category{
	
	private int categoryID;
	private String categoryName;
	
	public Category(int categoryID, String categoryName) {
		this.categoryID = categoryID;
		this.categoryName = categoryName;
	}
	
	@Override
	public String toString() {
		return String.format("%s - %s", categoryID, categoryName);
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
