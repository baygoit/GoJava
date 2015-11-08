package ua.com.goit.gojava.alejnikovi.medsystem;

import java.util.Date;
import java.util.List;


class Doctor {

	private String firstName;
	private String secondName;
	private Specialization specialization;
	private Clinic clinic;
	private List<WorkDay> schedule;

	Doctor (String firstName, String secondName, Specialization specialization, Clinic clinic){
		this.firstName = firstName;
		this.secondName = secondName;
		this.specialization = specialization;
		this.clinic = clinic;
	}  
	
	void addWorkDay(Date startHour, Date endHour){
		schedule.add(new WorkDay(startHour, endHour));
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
