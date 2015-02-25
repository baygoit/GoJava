package ua.com.sas.model;

public class InMemoryCategoryTest extends CategoriesTest{

	@Override
	Categories getList() {
		return new InnerMemoryCategories();
	}
	
}
