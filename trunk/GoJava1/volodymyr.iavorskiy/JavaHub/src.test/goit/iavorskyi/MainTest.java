package goit.iavorskyi;

import static org.junit.Assert.*;

import org.junit.Test;

public class MainTest {

	@Test
	public void testAdd() {
		Main test = new Main();
		int result = test.add(1, 3);
		assertEquals(4, result);
		
	}

}
