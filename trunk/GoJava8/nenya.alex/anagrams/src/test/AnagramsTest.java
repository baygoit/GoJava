package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.*;

import anagrams.Anagrams;
import anagrams.IO;
import anagrams.IOImpl;
import anagrams.ReverseWords;

public class AnagramsTest {

	private IOImpl reader = new IOImpl();
	private static InputStream realIn;
	private ReverseWords rw = new ReverseWords();

	@Test
	public void testReadConsole() throws IOException {
		InputStream in = new ByteArrayInputStream("testString".getBytes());
		System.setIn(in);

		assertEquals("testString", reader.read());
	}

	@Test(expected = IOException.class)
	public void testReadConsoleException() throws IOException {
		InputStream in = new InputStream() {

			@Override
			public int read() throws IOException {
				throw new IOException();
			}
		};
		System.setIn(in);

		reader.read();

	}

	@Test
	public void testReverseWordsEmpty() {
		String str = "";
		assertEquals("", rw.reverseWords(str));
	}
	
	@Test
	public void testReverseWordsNotEmpty() {
		String str = "abc sdf";
		assertEquals("cba fds", rw.reverseWords(str));
	}
	
	@Test(expected = NullPointerException.class)
	public void testReverseWordsNull() {
		String str = null;
		rw.reverseWords(str);
	}
	
	//not working in a proper way
	@Test
	public void testAnagrams() throws IOException{
		IO io = mock(IO.class); 
		String[] arr = {"A"};
		InputStream in = new ByteArrayInputStream("Test String".getBytes());
		System.setIn(in);
		
		Anagrams.main(arr);
		
		
		//InOrder order = inOrder(io);
	      //order.verify(io).write("Enter the words");
	      //order.verify(io).write("Test String");
	      //order.verify(io).write("Result:	tseT gnirtS");
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
