package ua.com.goit.gojava.alejnikovi.medsystem;

class Doctor {

	private String firstName;
	private String secondName;
	private String specialization;

	Doctor (String firstName, String secondName, String specialization){
		this.firstName = firstName;
		this.secondName = secondName;
		this.specialization = specialization;
	}  
  
	String getSpecialization() {
		return specialization;
	}
	
	String getFirstName() {
		return firstName;
	}
	
	String getSecondName() {
		return secondName;
	}

}
