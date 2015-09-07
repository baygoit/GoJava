package belskii.artem.kickstarter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DispatcherControllerTest {
	private DispatcherController dispatcher = new DispatcherController();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testStart() {
		assertNotNull(dispatcher);
	}

}
