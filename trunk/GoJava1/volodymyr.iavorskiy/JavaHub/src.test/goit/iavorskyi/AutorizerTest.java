package goit.iavorskyi;

import static org.junit.Assert.*;
import goit.iavorskyi.tools.Autorizer;

import org.junit.Test;

public class AutorizerTest {

	@Test
	public void testLogin() {
		Autorizer autorizer = new Autorizer();
		assertTrue(autorizer.login("user", "pass"));
		assertFalse(autorizer.login("", ""));
		assertFalse(autorizer.login("asd", "pass"));
		assertFalse(autorizer.login("user", "spass"));
	}
	
	@Test
	public void testRegister() {
		Autorizer autorizer = new Autorizer();
		assertTrue(autorizer.register("user", "password", "password"));
		assertFalse(autorizer.register("user", "pass2word", "password"));
		assertFalse(autorizer.register("", "", ""));
		assertFalse(autorizer.register("", "password", "password"));
		assertFalse(autorizer.register("asd", "", ""));
		
	}

}
