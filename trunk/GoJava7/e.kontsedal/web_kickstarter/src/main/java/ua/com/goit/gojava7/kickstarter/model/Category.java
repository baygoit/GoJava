package ua.com.goit.gojava7.kickstarter.model;

public class Category {
	private String categoryName;
	private int idCategory;

	public Category() {}

	public String getCategoryName() {
		return this.categoryName;
	}

	public int getIdCategory() {
		return this.idCategory;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

}
