package ua.com.goit.gojava.alejnikovi.medsystem;

import static org.junit.Assert.*;

import org.junit.Test;

public class DoctorTest {

	@Test
	public void smokeTest() {
		assertNotNull(new Doctor(null, null, null));
	}
	
	@Test
	public void testToString() {
		Specialization specialization = new Specialization("знахарь");
		Doctor doctor = new Doctor("Примерный", "Пример", specialization);
		assertEquals("Примерный Пример, знахарь", doctor.toString());
	}

}
