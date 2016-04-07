package ua.goit.roman;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RomanNumberConverterTest {

	private RomanNumberConverter rn = new RomanNumberConverter();

	@Test
	public void test1() {
		assertThat(rn.convert(1), is("I"));
	}

	@Test
	public void test2() {
		assertThat(rn.convert(2), is("II"));
	}

	@Test
	public void test1650() {
		assertThat(rn.convert(1650), is("MDCL"));
	}

	@Test
	public void test4() {
		assertThat(rn.convert(4), is("IV"));
	}

	@Test
	public void test9() {
		assertThat(rn.convert(9), is("IX"));
	}
}
