package ua.com.goit.gojava.alejnikovi;

public class Doctor {
	
	String name;
	String surname;
	String specialization;

	Doctor (String name, String surname, String specialization){
		this.name = name;
		this.surname = surname;
		this.specialization = specialization;
	}  
  
	public String getSpec(){
		return this.specialization;
	}

}
