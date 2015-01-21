package ua.com.goit.gojava.alejnikovi.medsystem;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestDoctor {

	@Test
	public void testSmoke() {
		
		assertNotNull(new Doctor("test", "test", "test"));

	}

}
