package com.gojava2.kickstarter.model;

import java.io.File;

import org.junit.AfterClass;

public class QuoteStorageInFileTest extends QuoteStorageTest {
	
	private static File file = new File("test/TempQuotes.json");
	
	@Override
	QuoteStorage getStorage() {
		return new QuoteStorageInFile(new FakeRandom(0, 1), file.getAbsolutePath());
	}
	
	@AfterClass
	public static void tearDown() {
		file.delete();
	}
}