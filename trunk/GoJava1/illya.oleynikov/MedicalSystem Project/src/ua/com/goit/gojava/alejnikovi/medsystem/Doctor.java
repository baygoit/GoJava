package ua.com.goit.gojava.alejnikovi.medsystem;

class Doctor {

	private String firstName;
	private String secondName;
	private Specialization specialization;

	Doctor (String firstName, String secondName, Specialization specialization){
		this.firstName = firstName;
		this.secondName = secondName;
		this.specialization = specialization;
	}  
  
	Specialization getSpecialization() {
		return specialization;
	}
	
	String getFirstName() {
		return firstName;
	}
	
	String getSecondName() {
		return secondName;
	}
	
	@Override
	public String toString() {
		return this.firstName + " " + this.secondName + ", " + this.specialization.toString();
	}

}
