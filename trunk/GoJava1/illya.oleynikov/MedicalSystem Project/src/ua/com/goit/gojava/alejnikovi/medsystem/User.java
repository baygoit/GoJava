package ua.com.goit.gojava.alejnikovi.medsystem;

import java.util.ArrayList;
import java.util.List;

class User {
	private String login;
	private String password;
	
	List<Doctor> getDoctorsBySpec (Specialization specialization){
		List<Doctor> doctorsWithSpec = new ArrayList<Doctor>();
		for(Doctor doctor: MedicalSystem.getDoctors()){
			if(doctor.getSpecialization().equals(specialization)){
				doctorsWithSpec.add(doctor);
			}
		}
		return doctorsWithSpec;
	}
}
