package ua.com.goit.gojava.alejnikovi.medsystem;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class MedicalSystemTest {
	
	List<Doctor> testDocList = MedicalSystem.getDoctors();
	

	
	@Test
	public void testAddSpecialisation() {
		MedicalSystem.addSpecialisation("Аллерголог");
		int lastIndex = MedicalSystem.specializations.size()-1;
		assertEquals("Аллерголог", MedicalSystem.specializations.get(lastIndex).getName());
	}
	
	@Test
	public void testAddDoubledSpecialisation() {
		MedicalSystem.addSpecialisation("Терапевт");
		int size = MedicalSystem.specializations.size();
		MedicalSystem.addSpecialisation("Терапевт");
		assertEquals(size, MedicalSystem.specializations.size());
	}
	
	@Test
	public void testIsSpecialisationUnique() {
		boolean result = MedicalSystem.isSpecialisationUnique("Хирург");
		assertEquals(true, result);
	}
	
	@Test
	public void testIsSpecialisationNotUnique() {
		MedicalSystem.addSpecialisation("Стоматолог");
		boolean result = MedicalSystem.isSpecialisationUnique("Стоматолог");
		assertEquals(false, result);
	}
	
	@Test
	public void testAddDoctor() {
		Doctor doctor = new Doctor(null, null, null);
		MedicalSystem.addDoctor(doctor);
		assertEquals(1, MedicalSystem.doctors.size());
	}

}
