package ua.com.goit.gojava.alejnikovi.medsystem;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MedicalSystemTest {
	
	//List<Specialization> specializations = new ArrayList<Specialization>();
	
	@Test
	public void addSpecialisationTest() {
		String name = "Hirurg";
		MedicalSystem.addSpecialisation(name);
		assertEquals("Hirurg", MedicalSystem.specializations.get(0).getName());

	}
	
	@Test
	public void addSpecTest() {
		String name = "Hirurg";
		MedicalSystem.addSpecialisation(name);
		assertEquals("Hirurg", MedicalSystem.specializations.get(0).getName());

	}

	/*@Test
	public void testSelectSpecialization() {
	    specializations.add(new Specialization("Хирург"));
	    specializations.add(new Specialization("Уростоматолог"));

	}*/
	
	

}
