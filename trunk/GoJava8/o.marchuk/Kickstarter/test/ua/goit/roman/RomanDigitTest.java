package ua.goit.roman;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RomanDigitTest {

	@Test
	public void testCreate() {
		RomanDigit rd = new RomanDigit(1, "I");
		assertThat(rd.getRoman(), is("I"));
		assertThat(rd.getArabic(), is(1));
	}

	@Test
	public void testStartWith5() {
		assertThat(new RomanDigit(5, null).canBeMinused(), is(false));

		assertThat(new RomanDigit(50, null).canBeMinused(), is(false));

		assertThat(new RomanDigit(500, null).canBeMinused(), is(false));
	}

	@Test
	public void testCanBeMinused() {
		assertThat(new RomanDigit(1, null).canBeMinused(), is(true));

		assertThat(new RomanDigit(10, null).canBeMinused(), is(true));

		assertThat(new RomanDigit(100, null).canBeMinused(), is(true));

		assertThat(new RomanDigit(1000, null).canBeMinused(), is(true));

	}
}
