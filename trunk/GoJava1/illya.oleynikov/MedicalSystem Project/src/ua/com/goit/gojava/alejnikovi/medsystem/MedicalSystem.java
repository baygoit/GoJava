package ua.com.goit.gojava.alejnikovi.medsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MedicalSystem {

    public static void main(String[] args){
        
        List<Doctor> doctors = new ArrayList<Doctor>();
        List<Specialization> specializations = new ArrayList<Specialization>();
        specializations.add(new Specialization("Терапевт"));
        specializations.add(new Specialization("Хирург"));
        specializations.add(new Specialization("Уростоматолог"));
        
        int userSelection = 0;
        Specialization specSelection;
        
        while (userSelection != 3) try {
            System.out.println();
            userSelection = Integer.parseInt(input("1"));/*Для создания нового врача введите '1'" + "\n" +
                                            "Для просмотра списка врачей введите '2'" + "\n" +
                                            "Для выхода введите '3'"));*/
            System.out.println();
            if (userSelection == 1){
                doctors.add(createDoctor(specializations));
            } else if (userSelection == 2){
                specSelection = selectSpecialization(specializations);
                if (isHaveSpecialisation(doctors, specSelection)){
                    System.out.println("Список врачей по выбранной Вами специализации:");
                    for (Doctor doc: doctors){
                        if (doc.getSpecialization().equals(specSelection)){
                            System.out.println(doc.getFirstName() + " " + doc.getSecondName());
                        }
                    }
                } else {
                    System.out.println("Врачей по выбранной Вами специализации не найдено");
                }                
            }
        } catch (NumberFormatException e){
            System.err.println("Вы должны внести цифру 1, 2 или 3");
        } catch (IndexOutOfBoundsException x){
            System.err.println("Вы должны внести цифру 1, 2 или 3");
        }
 
    }

	public static String input(String prompt){
        System.out.println(prompt);         
        return prompt;//(new Scanner(System.in)).nextLine();
    }
	
	public static String mockInput(String result){
        return result;
    }
 
    private static Doctor createDoctor(List<Specialization> specializations){
        String name = input("Введите имя врача");
        String surname = input("Введите фамилию врача");
        Specialization specialization = selectSpecialization(specializations); 
        System.out.println("Добавлен новый врач - " + name + " " + surname + ", " + specialization.getName());
        return new Doctor(name, surname, specialization);
     }
    
    public static Specialization selectSpecialization(List<Specialization> specializations){
        System.out.println('\n' + "Введите номер специализации врача, которую вы хотите выбрать:");
        for (int i = 0; i < specializations.size(); i++){
            System.out.println((i + 1) + ". " + specializations.get(i).getName());
        }
        int specIndex = Integer.parseInt(input("2")) - 1;
        return specializations.get(specIndex);
        
    }    
    
    private static boolean isHaveSpecialisation(List<Doctor> doctors, Specialization specSelection){
        for(Doctor doc: doctors){
            if(doc.getSpecialization().equals(specSelection)) return true;
        }
		return false;
	}

}
