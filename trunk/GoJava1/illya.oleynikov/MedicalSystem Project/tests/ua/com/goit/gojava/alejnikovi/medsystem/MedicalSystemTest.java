package ua.com.goit.gojava.alejnikovi.medsystem;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MedicalSystemTest {
	
	@Test
	public void testAddSpecialisation() {
		String name = "Hirurg";
		MedicalSystem.addSpecialisation(name);
		assertEquals("Hirurg", MedicalSystem.specializations.get(0).getName());
		System.out.println(MedicalSystem.specializations);

	}

}
