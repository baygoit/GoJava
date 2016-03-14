package ua.nenya.util;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ua.nenya.util.ConsoleIOImpl;
import ua.nenya.util.IO;


public class ConsoleIOImplTest {
	
	private IO reader = new ConsoleIOImpl();
	private static InputStream realIn;

	@Test
	public void readConsoleTest() throws IOException {
		InputStream in = new ByteArrayInputStream("testString".getBytes());
		System.setIn(in);

		assertEquals("testString", reader.readConsole());
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
