package ua.com.sas.model;

import org.junit.After;

public class CategoriesDAOTest extends CategoriesTest{

	@Override
	Categories getList() {
		return new CategoriesDAO("kickstarter_db_test");
	}
		
	@After
	public void cleanFile(){
		new CategoriesDAO("kickstarter_db_test").deleteData();
	}
	
}
