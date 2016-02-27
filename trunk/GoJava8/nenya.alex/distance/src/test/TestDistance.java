package test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import distance.FindDistance;
import distance.ReadConsole;
import distance.ReadList;
import static org.mockito.Mockito.*;

public class TestDistance {
	private ReadConsole reader = new ReadConsole();
	private static InputStream realIn;
	
	@Test
	public void testReadConsole() throws IOException {
		InputStream in = new ByteArrayInputStream("testString".getBytes());
		System.setIn(in);

		assertEquals("testString", reader.read());
	}

	//not working in a proper way
	@Ignore
	@Test
	public void testReadList() throws IOException {
		List<Integer> listOut = new ArrayList<>();
		listOut.add(0);
		listOut.add(1);
		listOut.add(2);
		listOut.add(3);

		
		InputStream in = new ByteArrayInputStream("hjj".getBytes());
		System.setIn(in);
		
		
		//reader.read();
		List<Integer> listIn = new ReadList().readList(); 
		
//		when(readConsole.read()).thenReturn("0").thenReturn("1")
//				.thenReturn("2").thenReturn("3").thenReturn("");

//		List<Integer> listIn = new ReadList().readList();
//		System.out.println("listIn " + listIn);
		//assertEquals(listOut, listIn);
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
	public void testFindDistanceEmpty() {
		List<Integer> listIn = new ArrayList<>();
		
		List<Integer> returnList = new ArrayList<>();
		assertEquals(returnList, new FindDistance().findDistances(listIn));
		
	}
	
	@Test(expected = NullPointerException.class)
	public void testFindDistanceNull() {
		List<Integer> listIn = null;
		new FindDistance().findDistances(listIn);
		
	}
	
	@Test
	public void testFindDistanceOne() {
		List<Integer> listIn = new ArrayList<>();
		listIn.add(2);
		listIn.add(23);
		listIn.add(45);
		listIn.add(4);
		listIn.add(38);
		
		List<Integer> returnList = new ArrayList<>();
		returnList.add(3);
		assertEquals(returnList, new FindDistance().findDistances(listIn));
		
	}
	
	@Test
	public void testFindDistanceOneOne() {
		List<Integer> listIn = new ArrayList<>();
		listIn.add(4);
		listIn.add(23);
		listIn.add(45);
		listIn.add(2);
		listIn.add(38);
		
		List<Integer> returnList = new ArrayList<>();
		returnList.add(3);
		assertEquals(returnList, new FindDistance().findDistances(listIn));
		
	}
	
	@Test
	public void testFindDistanceMany() {
		List<Integer> listIn = new ArrayList<>();
		listIn.add(1);
		listIn.add(2);
		listIn.add(1);
		listIn.add(2);
		listIn.add(1);
		listIn.add(3);
		listIn.add(3);
		listIn.add(3);
		listIn.add(1);
		
		List<Integer> returnList = new ArrayList<>();
		returnList.add(2);
		returnList.add(4);
		returnList.add(8);
		returnList.add(2);
		returnList.add(6);
		returnList.add(4);
		assertEquals(returnList, new FindDistance().findDistances(listIn));
		
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
