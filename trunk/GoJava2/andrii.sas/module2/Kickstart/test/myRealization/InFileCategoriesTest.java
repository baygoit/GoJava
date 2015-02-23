package myRealization;

import java.io.File;

import myRealization.Categories;
import myRealization.InFileCategories;

import org.junit.After;

public class InFileCategoriesTest extends CategoriesTest{

	@Override
	Categories getList() {
		return new InFileCategories("categories-test.txt");
	}
		
	@After
	public void cleanFile(){
		new File("categories-test.txt").delete();
	}
		
}
