package ua.com.goit.gojava.alejnikovi.medsystem;

import java.util.ArrayList;
import java.util.List;

class Clinic {
	private String name;
	private String address;
	
	Clinic (String name, String address){
		this.name = name;
		this.address = address;
	}
	
	Doctor createDoctor (String firstName, String secondName, Specialization spec){
		Doctor doctor = new Doctor(firstName, secondName, spec, this);
		return doctor;
	}

	List<Doctor> getDoctors() {
		List<Doctor> doctorsInClinic = new ArrayList<Doctor>();
		for(Doctor doctor: MedicalSystem.getDoctors()){
			if(doctor.getClinic().equals(this)){
				doctorsInClinic.add(doctor);
			}
		}
		return doctorsInClinic;
	}
	
	
	
}
