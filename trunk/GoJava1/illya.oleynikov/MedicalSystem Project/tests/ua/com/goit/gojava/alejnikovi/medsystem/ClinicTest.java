package ua.com.goit.gojava.alejnikovi.medsystem;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class ClinicTest {
	
	static List<Doctor> testDocList = MedicalSystem.getDoctors();
	static List<Clinic> testClinics = MedicalSystem.getClinics();
	
	@BeforeClass
	public static void setLists(){
		
		testClinics.add(new Clinic("Клиника 1", "ул. 1"));
		testClinics.add(new Clinic("Клиника 2", "ул. 2"));
		testDocList.add(new Doctor("Док1", "ДокФам1", null, testClinics.get(0)));
		testDocList.add(new Doctor("Док2", "ДокФам2", null, testClinics.get(1)));
		testDocList.add(new Doctor("Док3", "ДокФам3", null, testClinics.get(0)));
		
	}

	@Test
	public void smokeTest() {
		assertNotNull(new Clinic(null, null));;
	}

	@Test
	public void testCreateDoctor() {
		Clinic clinic = new Clinic("Лечебница", "ул. Медицинская");
		Doctor doctor = clinic.createDoctor("Пример", "Примерный", null);
		assertEquals(doctor.getClinic(), clinic);
	}
	
	@Test
	public void testGetDoctorsByClinic() {
		List<Doctor> docsWithSpec = testClinics.get(0).getDoctors();
		String docNames = docsWithSpec.get(0).getFirstName() + ", " + docsWithSpec.get(1).getFirstName();
		assertEquals("Док1, Док3", docNames);
	}

}
