package myRealization;

import java.io.File;

import org.junit.After;

public class InMemoryCategoryTest extends CategoriesTest{

	@Override
	Categories getList() {
		return new InFileCategories("categories.txt");
	}
	
	@After
	public void cleanFile(){
		new File("categories.txt").delete();
	}
	
}
