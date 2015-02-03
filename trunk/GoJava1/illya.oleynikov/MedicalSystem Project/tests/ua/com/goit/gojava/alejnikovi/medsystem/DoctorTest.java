package ua.com.goit.gojava.alejnikovi.medsystem;

import static org.junit.Assert.*;

import org.junit.Test;

public class DoctorTest {

	@Test
	public void smokeTest() {
		assertNotNull(new Doctor(null, null, null, null));
	}
	
	@Test
	public void testAllToString() {
		Specialization specialization = new Specialization("знахарь");
		Doctor doctor = new Doctor("Примерный", "Пример", specialization, new Clinic (null, null));
		assertEquals("Примерный Пример, знахарь", doctor.allToString());
	}

}
