package com.gojava2.kickstarter.model;

import java.io.File;

public class ProjectStorageInFileTest extends ProjectStorageTest {

	private File file = new File("Data/TempProjects.json");
	
	@Override
	ProjectStorage getStorage() {
		return new ProjectStorageInFile(file.getAbsolutePath());
	}
}