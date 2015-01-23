package ua.com.goit.gojava.alejnikovi.medsystem;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestMedicalSystem {
	
	List<Specialization> specializations = new ArrayList<Specialization>();
	
	@Test
	public void testNewDocInList() {
	    specializations.add(new Specialization("Хирург"));
	    assertEquals(1, specializations.size());
	}

	@Test
	public void testSelectSpecialization() {
	    specializations.add(new Specialization("Хирург"));
	    specializations.add(new Specialization("Уростоматолог"));
	    
	    //Specialization specialization = selectSpecialization(specializations);
		//assertEquals(2, specializations.size());
	}
	
	

}
