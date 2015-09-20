package com.gojava2.kickstarter.model;

public class CategoryStorageInMemoryTest extends CategoryStorageTest {

	@Override
	CategoryStorage getStorage() {
		return new CategoryStorageInMemory();
	}
}