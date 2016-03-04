package com.anmertrix.module1.annagama;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;


public class ConsoleIOTest {
	
	@Test
	public void testReadConsole(){
		ConsoleIO io = mock(ConsoleIO.class);
		when(io.readConsole()).thenReturn("test");
		assertEquals("test", io.readConsole());
	}
	
	@Test
	public void consoleIOTestPrint(){
		ConsoleIO io = mock(ConsoleIO.class);
		io.print("TEST");
		verify(io).print("TEST");
	}
	
	
}
