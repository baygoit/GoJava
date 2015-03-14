package ua.com.goit.gojava2.vova.kickstarter.model;


public class Category{
	
	private int IdCategory;
	private String nameCategory;
	
	public Category(int IdCategory, String nameCategory) {
		this.IdCategory = IdCategory;
		this.nameCategory = nameCategory;
	}
	
	@Override
	public String toString() {
		return String.format("%s - %s", IdCategory, nameCategory);
	}

	public int getCategoryID() {
		return IdCategory;
	}

	public void setIdCategory(int IdCategory) {
		this.IdCategory = IdCategory;
	}

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}
}
