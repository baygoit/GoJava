package ua.com.goit.gojava.alejnikovi.medsystem;

class ClinicAdministrator extends User {
	
    static void createDoctor(String firstName, String secondName, Specialization spec){
    	Doctor doctor = new Doctor(firstName, secondName, spec);
        MedicalSystem.addDoctor(doctor);
    }
    
    

}
