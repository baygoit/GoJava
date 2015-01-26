package ua.com.scread.kickstarter;

public class Model {
	private Categories categories;
	
	public Model() {
		categories = new Categories();
	}
	
	public void init() {
		Category category1 = new Category("Sport");
		Category category2 = new Category("Science");
		Category category3 = new Category("Virtual reality");
		
		
		categories.add(category1);
		categories.add(category2);
		categories.add(category3);
	}

	public String[] getStringCatigories() {
		return categories.getStringCategories();
	}
	
	public Categories getCategories() {
		return categories;
	}
	
}
