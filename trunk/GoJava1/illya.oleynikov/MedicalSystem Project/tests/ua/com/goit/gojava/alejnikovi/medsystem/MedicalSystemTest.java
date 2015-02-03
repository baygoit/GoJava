package ua.com.goit.gojava.alejnikovi.medsystem;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class MedicalSystemTest {
	
	List<Doctor> testDocList = MedicalSystem.getDoctors();
	
	@BeforeClass
	public static void setList(){
		MedicalSystem.specializations.add(new Specialization("Шаман"));
	}		
	
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
	public void testCreateDoctor() {
		Specialization specialization = MedicalSystem.getSpecializationByIndex(0);
		Clinic clinic = new Clinic("Тесовая Клиника", "Тестовый адресс");
		MedicalSystem.createDoctor("Тест", "Тестов", specialization, clinic);
		assertEquals(1, MedicalSystem.doctors.size());
	}
	
	@Test
	public void testCreateClinic() {
		MedicalSystem.createClinic("Тест", "ул. Тестовая");
		assertEquals(1, MedicalSystem.clinics.size());
	}
	
	
	

}
