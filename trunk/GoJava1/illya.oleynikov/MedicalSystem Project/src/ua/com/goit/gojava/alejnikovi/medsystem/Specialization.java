package ua.com.goit.gojava.alejnikovi.medsystem;

import java.util.ArrayList;
import java.util.List;

public class Specialization {
	
	private String name;
		
	public Specialization (String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	List<Doctor> getDoctors (){
		List<Doctor> doctorsWithSpec = new ArrayList<Doctor>();
		for(Doctor doctor: MedicalSystem.getDoctors()){
			if(doctor.getSpecialization().equals(this)){
				doctorsWithSpec.add(doctor);
			}
		}
		return doctorsWithSpec;
	}
	

}
