package ua.com.goit.gojava.alejnikovi.medsystem;

import java.util.ArrayList;
import java.util.List;

public class MedicalSystem {
	
	static List<Specialization> specializations = new ArrayList<Specialization>();
	static List<Doctor> doctors = new ArrayList<Doctor>();
	static List<Clinic> clinics = new ArrayList<Clinic>();
	
	static List<Specialization> getSpecializations() {
		return specializations;
	}
	
	static List<Doctor> getDoctors() {
		return doctors;
	}

	static void addDoctor(Doctor doctor) {
		doctors.add(doctor);
	}
		
    static Specialization getSpecializationByIndex(int specIndex) {
		return specializations.get(specIndex);
	}

    static boolean isSpecialisationUnique(String specializationName) throws MedicalSystemException{
		for (Specialization spec: specializations){
			if (spec.getName().equals(specializationName)){
				throw new MedicalSystemException("Specialisation not unique");		
			} 
		}
		return true;
	}
   
    static void addSpecialisation (String specializationName) throws MedicalSystemException {
    	if (isSpecialisationUnique(specializationName)){
			specializations.add(new Specialization(specializationName));
    	}
    }

	static void createDoctor(String firstName, String secondName, Specialization spec, Clinic clinic){
		Doctor doctor = new Doctor(firstName, secondName, spec, clinic);
	    addDoctor(doctor);
	}

	static void createClinic(String name, String address) {
		Clinic clinic = new Clinic(name, address);
		addClinic(clinic);		
	}

	static void addClinic(Clinic clinic) {
		clinics.add(clinic);		
	}

	static List<Clinic> getClinics() {
		return clinics;
	}
    

}
