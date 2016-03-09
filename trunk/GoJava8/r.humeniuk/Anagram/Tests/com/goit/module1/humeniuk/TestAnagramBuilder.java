package com.goit.module1.humeniuk;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.goit.module1.humeniuk.AnagramBuilder;

public class TestAnagramBuilder {
	
	@Test
	public void testBuildAnagramFullSentence(){
		String message = "mama mula ramu 12345";
		AnagramBuilder builder = new AnagramBuilder();
		assertEquals("amam alum umar 54321", builder.buildAnagram(message));
	}
	
	@Test
	public void testBuildAnagramOneSymbol(){
		String message = "0";
		AnagramBuilder builder = new AnagramBuilder();
		assertEquals("0", builder.buildAnagram(message));
	}
	
	@Test
	public void testBuildAnagramTwoSymbols(){
		String message = "12";
		AnagramBuilder builder = new AnagramBuilder();
		assertEquals("21", builder.buildAnagram(message));
	}
	
	@Test
	public void testBuildAnagramEmptyString(){
		String message = "";
		AnagramBuilder builder = new AnagramBuilder();
		assertEquals("", builder.buildAnagram(message));
	}
	
	@Test(expected = NullPointerException.class)
	public void testBuildAnagramException(){
		String message = null;
		AnagramBuilder builder = new AnagramBuilder();
		builder.buildAnagram(message);
	}
	
}
