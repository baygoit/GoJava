package ua.com.goit.gojava.alejnikovi.medsystem;

import java.util.ArrayList;
import java.util.List;

class Specialization {
	
	private String name;
		
	Specialization (String name){
		this.name = name;
	}

	String getName() {
		return name;
	}

	List<Doctor> getDoctorsBySpec (){
		List<Doctor> doctorsWithSpec = new ArrayList<Doctor>();
		for(Doctor doctor: MedicalSystem.getDoctors()){
			if(doctor.getSpecialization().equals(this)){
				doctorsWithSpec.add(doctor);
			}
		}
		return doctorsWithSpec;
	}

}
