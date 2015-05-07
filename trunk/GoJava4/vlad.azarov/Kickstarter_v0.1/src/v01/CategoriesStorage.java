package v01;

public class CategoriesStorage implements CategoriesInterface{
	
	private Category[] categories;
	private int totalNumberOfCategories;
	
	
	@Override
	public void add(String categoryName) {
		categories[totalNumberOfCategories] = new Category(categoryName);
		totalNumberOfCategories++;
		
	}
	@Override
	public void add(Category category) {
		categories[totalNumberOfCategories] = category;
		
	}
}
