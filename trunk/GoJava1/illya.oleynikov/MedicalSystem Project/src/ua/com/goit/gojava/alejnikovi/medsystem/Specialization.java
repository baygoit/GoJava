package ua.com.goit.gojava.alejnikovi.medsystem;

import java.util.ArrayList;
import java.util.List;

public class Specialization implements FIleWorkable{
	
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
	
	@Override
	public String markupForFile() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Specialization createObjFromFile() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
