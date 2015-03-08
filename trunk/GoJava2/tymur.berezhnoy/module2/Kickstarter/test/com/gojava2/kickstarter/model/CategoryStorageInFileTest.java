package com.gojava2.kickstarter.model;

import java.io.File;

import org.junit.After;

public class CategoryStorageInFileTest extends CategoryStorageTest {

	private File file = new File("test/TempCategories.json");
	
	@Override
	CategoryStorage getStorage() {
		return new CategoryStorageInFile(file.getAbsolutePath());
	}
	
	@After
	public void tearDown() {
		file.delete();	
	}
}