package kickstarter.engine;

import static org.junit.Assert.*;

import org.junit.Test;

public class DefaultsTest {

	@Test
	public void shouldZeroId_whenExit() {
		assertEquals(0, Defaults.EXIT.getId());
	}

	@Test
	public void shouldCountOfElements_whenCheckEnumSize() {
		assertEquals(1, Defaults.values().length);
	}

	@Test
	public void shouldExit_whenGetValurOf() {
		assertEquals(Defaults.EXIT, Defaults.valueOf("EXIT"));
	}

}
