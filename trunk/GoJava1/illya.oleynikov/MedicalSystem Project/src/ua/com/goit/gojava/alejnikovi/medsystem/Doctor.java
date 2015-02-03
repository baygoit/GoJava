package ua.com.goit.gojava.alejnikovi.medsystem;

class Doctor {

	private String firstName;
	private String secondName;
	private Specialization specialization;
	private Clinic clinic;

	Doctor (String firstName, String secondName, Specialization specialization, Clinic clinic){
		this.firstName = firstName;
		this.secondName = secondName;
		this.specialization = specialization;
		this.clinic = clinic;
	}  
  
	Specialization getSpecialization() {
		return specialization;
	}
	
	String getFirstName() {
		return firstName;
	}
	
	/*String getSecondName() {
		return secondName;
	}*/
	
	public String allToString() {
		return firstName + " " + secondName + ", " + specialization.getName();
	}

	public Clinic getClinic() {
		return clinic;
	}

}
