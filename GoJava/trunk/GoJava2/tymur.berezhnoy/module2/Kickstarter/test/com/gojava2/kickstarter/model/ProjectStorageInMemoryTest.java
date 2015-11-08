package com.gojava2.kickstarter.model;

public class ProjectStorageInMemoryTest extends ProjectStorageTest {

	@Override
	ProjectStorage getStorage() {
		return new ProjectStorageInMemory();
	}
}