package com.anitsai.anatolii.Anagram;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReaderTest {

	private Reader reader = new Reader();
	private static InputStream realIn;

	@Test
	public void testReadConsoleString() throws IOException {
		InputStream in = new ByteArrayInputStream("testString".getBytes());
		System.setIn(in);

		assertThat(reader.readConsoleString(), is("testString"));
	}

	@Test(expected = IOException.class)
	public void testReadConsoleStringException() throws IOException {
		InputStream in = new InputStream() {

			@Override
			public int read() throws IOException {
				throw new IOException();
			}
		};
		System.setIn(in);

		reader.readConsoleString();

	}


	@BeforeClass
	public static void saveRealIn() {
		realIn = System.in;
	}

	@AfterClass
	public static void restoreRealIn() {
		System.setIn(realIn);
	}

}
