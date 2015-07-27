package belskii.artem.kickstarter.dao;

public class Category {
	private int categoryId;
	private String categoryName;

	public Category(int id, String name) {
		this.categoryId = id;
		this.categoryName = name;
	}

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
