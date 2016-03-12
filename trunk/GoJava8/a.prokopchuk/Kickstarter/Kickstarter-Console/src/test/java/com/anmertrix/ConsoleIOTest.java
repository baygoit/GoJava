package com.anmertrix;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
