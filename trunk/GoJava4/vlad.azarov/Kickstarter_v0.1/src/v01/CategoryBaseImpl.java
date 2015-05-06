package v01;

public class CategoryBaseImpl implements CategoryBase {

	private Category[] allCategories;
			
	public CategoryBaseImpl(Category[] allCategories) {
		super();
		this.allCategories = allCategories;
	}

	@Override
	public Category[] getAllCategories() {
		return allCategories;
	}


	
}
