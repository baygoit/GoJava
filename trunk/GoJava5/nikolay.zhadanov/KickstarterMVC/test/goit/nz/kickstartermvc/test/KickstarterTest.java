package goit.nz.kickstartermvc.test;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import goit.nz.kickstartermvc.Dispatcher;
import goit.nz.kickstartermvc.Kickstarter;
import goit.nz.kickstartermvc.input.Input;
import goit.nz.kickstartermvc.output.Output;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class KickstarterTest {
	@Mock
	Output output;
	@Mock
	Input input;
	@Mock
	Dispatcher dispatcher;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void whenRunThenInputListens() {
		MockStorage storage = new MockStorage();
		storage.initStorage();
		
		Kickstarter test = new Kickstarter(storage, output, input);
		test.run();
		verify(input, times(1)).listenInput();
	}

}
