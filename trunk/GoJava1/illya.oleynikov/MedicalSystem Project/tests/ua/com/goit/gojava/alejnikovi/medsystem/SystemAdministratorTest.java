package ua.com.goit.gojava.alejnikovi.medsystem;

import static org.junit.Assert.*;
import org.junit.Test;

public class SystemAdministratorTest {
	
	SystemAdministrator sysAd = new SystemAdministrator();

	@Test
	public void testAddSpec() {
		Specialization specialization = new Specialization("hir");
		sysAd.addSpec(MedicalSystem.specializations, specialization);
		assertSame(MedicalSystem.specializations.get(0), specialization);
	}


}
