package mainkick;

public class Category{
	public int categoryID;
	public String categoryName;
	public int[] projectsThatContain;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}
