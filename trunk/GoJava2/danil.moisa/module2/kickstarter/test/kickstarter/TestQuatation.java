package kickstarter;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestQuatation {

	@Test
	public void shouldShowQuote() {
		Quatation q = new Quatation();
		assertEquals("Говорят, что: Все успехи начинаются с самодисциплины. Все начинается с тебя. © Дуэйн Джонсон", q);
	}

}
