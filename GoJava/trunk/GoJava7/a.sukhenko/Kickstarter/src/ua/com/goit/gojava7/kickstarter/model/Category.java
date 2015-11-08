package ua.com.goit.gojava7.kickstarter.model;

/**
 * @author Devian
 * @category Model
 */
public class Category {public Category() {
	// TODO Auto-generated constructor stub
}
	
	public Category(String categoryName, int categoryId) {
	super();
	this.categoryName = categoryName;
	this.categoryId = categoryId;
}

	private String categoryName;
	private int categoryId;
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
