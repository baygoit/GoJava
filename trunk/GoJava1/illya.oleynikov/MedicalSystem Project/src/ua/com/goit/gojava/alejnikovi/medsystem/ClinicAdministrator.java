package ua.com.goit.gojava.alejnikovi.medsystem;

class ClinicAdministrator extends User {
	
    static Doctor createDoctor(String firstName, String secondName, int specializationId){
        // System.out.println("Добавлен новый врач - " + name + " " + surname + ", " + specialization.getName());
         return new Doctor(firstName, secondName, MedicalSystem.getSpecializations().get(specializationId));
      }

}
