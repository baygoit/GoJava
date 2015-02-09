package ua.com.goit.gojava.alejnikovi.medsystem;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class SpecializationTest {
	
	static List<Doctor> testDocList = MedicalSystem.getDoctors();
	static List<Specialization> testSpecs = MedicalSystem.getSpecializations();

	@BeforeClass
	public static void setDocList(){
		testSpecs.add(new Specialization("Знахарь"));
		testSpecs.add(new Specialization("Стоматолог"));
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


}
