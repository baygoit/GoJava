package ua.com.goit.gojava.alejnikovi.medsystem;

import java.util.ArrayList;
import java.util.List;

public class MedicalSystem {
	
    static List<Specialization> specializations = new ArrayList<Specialization>();
	private static List<Doctor> doctors = new ArrayList<Doctor>();
    
    //public static List<Clinic> clinics = new ArrayList<Clinic>(); //next user scenario


	public static void addDoctors(Doctor doctor) {
		doctors.add(doctor);
	}

	public static void main(String[] args){
		
		
 
    }
	
    static List<Specialization> getSpecializations() {
		return specializations;
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
