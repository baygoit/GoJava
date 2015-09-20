package ua.com.goit.gojava.alejnikovi.medsystem;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class SpecializationTest {
	
	static List<Doctor> testDocList = MedicalSystem.getDoctors();
	static List<Specialization> testSpecs;

	@BeforeClass
	public static void setDocList() throws IOException, MedicalSystemException{
		testSpecs = MedicalSystem.getSpecializations();
		testDocList.clear();
		testDocList.add(new Doctor("Иван", "Иванов", testSpecs.get(0), null));
		testDocList.add(new Doctor("Петр", "Петров",testSpecs.get(0), null));
		testDocList.add(new Doctor("Спиридон", "Спиридонов", testSpecs.get(1), null));
	}
	
	
	@Test
	public void smokeTest() {
		Specialization spec = new Specialization(null);
		assertNotNull(spec);
	}
	
	@Test
	public void testGetDoctorsBySpec() {
		List<Doctor> docsWithSpec = testSpecs.get(0).getDoctors();
		String docNames = docsWithSpec.get(0).getFirstName() + ", " + docsWithSpec.get(1).getFirstName();
		assertEquals("Иван, Петр", docNames);
		System.out.println();
	}
	
	/*@Test
	public void testMarkupForFile() {
		Specialization specialization = new Specialization("Test");
		
		assertEquals("Иван, Петр", docNames);
	}*/



}
