package ua.com.goit.gojava7.kickstarter.models;

public class Category {

	private Long categoryId;
	private String name;		
	
	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "categoryId: " + categoryId + ", name: " + name;
	}
}