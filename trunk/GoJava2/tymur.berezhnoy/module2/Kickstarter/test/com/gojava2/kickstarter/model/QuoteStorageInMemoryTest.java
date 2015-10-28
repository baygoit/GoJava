package com.gojava2.kickstarter.model;


public class QuoteStorageInMemoryTest extends QuoteStorageTest {

	@Override
	QuoteStorage getStorage() {
		return new QuoteStorageInMemory(new FakeRandom(0, 1));
	}
}