package ua.com.goit.gojava.alejnikovi.medsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MedicalSystem {

    public static void main(String[] args){
        
        List<Doctor> doctors = new ArrayList<Doctor>();
        List<String> specs = new ArrayList<String>();
        specs.add("Терапевт");
        specs.add("Хирург");
        specs.add("Уростоматолог");
        
        int userSelection = 0;
        String specSelection;
        
        while (userSelection != 3) try {
            System.out.println();
            userSelection = Integer.parseInt(input("Для создания нового врача введите '1'" + "\n" +
                                            "Для просмотра списка врачей введите '2'" + "\n" +
                                            "Для выхода введите '3'"));
            System.out.println();
            if (userSelection == 1){
                doctors.add(createDoctor(specs));
            } else if (userSelection == 2){
                specSelection = selectSpec(specs);
                if (isHaveSpec(doctors, specSelection)){
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
        return (new Scanner(System.in)).nextLine();
    }
 
    private static Doctor createDoctor(List<String> specs){
        String name = input("Введите имя врача");
        String surname = input("Введите фамилию врача");
        String spec = selectSpec(specs); 
        System.out.println("Добавлен новый врач - " + name + " " + surname + ", " + spec);
        return new Doctor(name, surname, spec);
     }
    
    private static String selectSpec(List<String> specs){
        System.out.println('\n' + "Введите номер специализации врача, которую вы хотите выбрать:");
        for (int i = 0; i < specs.size(); i++){
            System.out.println((i + 1) + ". " + specs.get(i));
        }
        int specIndex = Integer.parseInt(input("")) - 1;
        return specs.get(specIndex);
        
    }    
    
    private static boolean isHaveSpec(List<Doctor> doctors, String spec){
        for(Doctor doc: doctors){
            if(doc.getSpecialization().equals(spec)) return true;
        }
		return false;
	}

}
