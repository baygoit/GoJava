package com.anmertrix.module1.annagama;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class IOTest {
	@Test
	public void testReadConsole(){
		IO io = mock(IO.class);
		when(io.readConsole()).thenReturn("test");
		assertEquals("test", io.readConsole());
	}
	
	@Test
	public void consoleIOTestPrint(){
		IO io = mock(ConsoleIO.class);
		io.print("TEST");
		verify(io).print("TEST");
	}
}
