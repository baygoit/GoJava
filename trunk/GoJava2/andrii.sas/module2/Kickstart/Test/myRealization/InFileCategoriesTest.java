package myRealization;

public class InFileCategoriesTest extends CategoriesTest{

	@Override
	Categories getList() {
		return new InnerMemoryCategories();
	}
		
}
