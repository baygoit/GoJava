package ua.com.goit.gojava.alejnikovi.medsystem;

import java.util.ArrayList;
import java.util.List;

public class MedicalSystem {
	
	static List<Specialization> specializations = new ArrayList<Specialization>();
	static List<Doctor> doctors = new ArrayList<Doctor>();
	
	private MedicalSystem() {}	
	    
    static List<Doctor> getDoctors() {
		return doctors;
	}

	static void addDoctor(Doctor doctor) {
		doctors.add(doctor);
	}
		
    static Specialization getSpecializationByIndex(int specIndex) {
		return specializations.get(specIndex);
	}

    static boolean isSpecialisationUnique(String specializationName){
		for (Specialization spec: specializations){
			if (spec.getName().equals(specializationName)){
				return false;		
			}			
		}
		return true;
	}
    
    static void addSpecialisation (String specializationName){
    	if (isSpecialisationUnique(specializationName)){
    		specializations.add(new Specialization(specializationName));
    	} 
    }
    

}
