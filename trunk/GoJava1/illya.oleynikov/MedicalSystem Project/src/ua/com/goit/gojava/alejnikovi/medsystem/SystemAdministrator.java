package ua.com.goit.gojava.alejnikovi.medsystem;

class SystemAdministrator extends User {
	
	void addSpecialisation (String specializationName){
		MedicalSystem.addSpecialisation(specializationName);
	}
	
}
