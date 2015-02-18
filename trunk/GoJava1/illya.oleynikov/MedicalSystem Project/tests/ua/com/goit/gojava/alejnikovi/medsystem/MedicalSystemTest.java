package ua.com.goit.gojava.alejnikovi.medsystem;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.rules.ExpectedException;

public class MedicalSystemTest {
	
	List<Doctor> testDocList = MedicalSystem.getDoctors();
	
	@BeforeClass
	public static void setList(){
		MedicalSystem.specializations.add(new Specialization("Шаман"));
	}		
	
	@Test
	public void testAddSpecialisation() throws MedicalSystemException {
		MedicalSystem.addSpecialisation("Аллерголог");
		int lastIndex = MedicalSystem.specializations.size()-1;
		assertEquals("Аллерголог", MedicalSystem.specializations.get(lastIndex).getName());
	}
	
	@Test (expected = MedicalSystemException.class)
	public void testAddDoubledSpecialisation() throws MedicalSystemException {
		MedicalSystem.addSpecialisation("Терапевт");
		int size = MedicalSystem.specializations.size();
		MedicalSystem.addSpecialisation("Терапевт");
		assertEquals(size, MedicalSystem.specializations.size());
	}
	
	@Test
	public void testIsSpecialisationUnique() {
		boolean result = false;
		try {
			result = MedicalSystem.isSpecialisationUnique("Хирург");
		} catch (MedicalSystemException e){
			
		}
		assertEquals(true, result);
	}
	
	@Test
	public void testWriteToFile() throws IOException {
		List<String> listFromFile = new ArrayList<String>();
		MedicalSystem.writeToFile("test.csv", "Новая");
		listFromFile = MedicalSystem.readFromFile("test.csv");

		assertEquals("Новая", listFromFile.get(listFromFile.size()-1));
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
