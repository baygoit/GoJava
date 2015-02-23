package myRealization;

import myRealization.Categories;
import myRealization.InnerMemoryCategories;

public class InMemoryCategoryTest extends CategoriesTest{

	@Override
	Categories getList() {
		return new InnerMemoryCategories();
	}
	
}
