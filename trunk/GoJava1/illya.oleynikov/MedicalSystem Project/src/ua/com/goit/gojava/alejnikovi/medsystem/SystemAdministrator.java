package ua.com.goit.gojava.alejnikovi.medsystem;

import java.util.List;

class SystemAdministrator extends User {
	
	static List<Specialization> addSpec (List<Specialization> specializations, Specialization specialization){
		specializations.add(specialization);
		return specializations;
	}
	
}
