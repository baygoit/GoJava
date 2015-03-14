package ua.com.goit.gojava2.vova.kickstarter.model;


public class Category{
	
	private int idCategory;
	private String nameCategory;
	
	public Category(int IdCategory, String nameCategory) {
		this.idCategory = IdCategory;
		this.nameCategory = nameCategory;
	}
	
	@Override
	public String toString() {
		return String.format("%s - %s", idCategory, nameCategory);
	}

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int IdCategory) {
		this.idCategory = IdCategory;
	}

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}
}
