package goit.nz.kickstartermvc.test;

import static org.junit.Assert.*;
import goit.nz.kickstartermvc.Dispatcher;
import goit.nz.kickstartermvc.DispatcherListener;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class DispatcherTest {
	@Mock
	DispatcherListener listener;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void whenRegisterListenerThenListenerRegistered() {

		Dispatcher dispatcher = new Dispatcher();
		dispatcher.registerListener(listener);

		int expected = 1;
		int actual = dispatcher.getControllerListenersCount();
		assertEquals(expected, actual);
	}

	@Test
	public void whenOnInputThenChangeCurrentListener() {
		when(listener.onInput(anyString())).thenReturn(1);

		Dispatcher dispatcher = new Dispatcher();
		dispatcher.registerListener(listener);
		dispatcher.registerListener(listener);

		int actual = dispatcher.onInput("any correct input except zero");
		int expected = 1;
		assertEquals(expected, actual);
		
		when(listener.onInput(anyString())).thenReturn(-1);
		actual = dispatcher.onInput("zero");
		expected = 0;
		assertEquals(expected, actual);
	}
	
	@Test
	public void whenOnInputThenExit() {
		when(listener.onInput(anyString())).thenReturn(-1);

		Dispatcher dispatcher = new Dispatcher();
		dispatcher.registerListener(listener);

		int actual = dispatcher.onInput("zero was entered");
		int expected = -1;
		assertEquals(expected, actual);
		verify(listener, times(0)).onTakeControl();
	}

}
