package kickstarter.engine;

import static org.junit.Assert.*;

import org.junit.Test;

public class DataTest {

	@Test
	public void shouldZeroId_whenExit() {
		assertEquals(0, Data.Defaults.EXIT.getId());
	}

}
