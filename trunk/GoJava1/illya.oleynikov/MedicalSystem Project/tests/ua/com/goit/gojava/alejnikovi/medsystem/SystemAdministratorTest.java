package ua.com.goit.gojava.alejnikovi.medsystem;

import static org.junit.Assert.*;
import org.junit.Test;

public class SystemAdministratorTest {
	
	SystemAdministrator sysAd = new SystemAdministrator();
	
	@Test
	public void smokeTest() {
		assertNotNull(sysAd);
	}

	@Test
	public void testAddSpecialisation() {
		sysAd.addSpecialisation("Hirurg");
		assertSame(MedicalSystem.specializations.get(0).getName(), "Hirurg");
		System.out.println(MedicalSystem.specializations);
	}


}
