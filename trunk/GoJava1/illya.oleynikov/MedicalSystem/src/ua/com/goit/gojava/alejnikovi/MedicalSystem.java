package ua.com.goit.gojava.alejnikovi;

import java.util.*;

public class MedicalSystem {
	
	public static void main(String[] args) {
		
        ArrayList<Doctor> doctors = new ArrayList<Doctor>();
        ArrayList<String> specs = new ArrayList<String>();
        int userSelection = 0;
 
        while (userSelection != 3) try {
            System.out.println();
            userSelection = Integer.parseInt(input("Для создания нового врача введите '1'" + "\n" +
                                            "Для просмотра списка врачей введите '2'" + "\n" +
                                            "Для выхода введите '3'"));
            System.out.println();
            if (userSelection == 1){
                doctors.add(createDoctor());
                //System.out.println(specs);
            	if(specs.isEmpty()){
                    specs.add(doctors.get(doctors.size() - 1).specialization);
            	}

                for (String s: specs){
                	if(s.equals(doctors.get(doctors.size() - 1).specialization)){
                		System.out.println("Спец уже встреч ");
                       // specs.add(doctors.get(doctors.size() - 1).specialization);
                	}

                }
                
                
            } else if (userSelection == 2){
            	System.out.println("Выберите специализацию врача:");
            	for (Doctor doc: doctors){      
                    System.out.println(doc.specialization);
                }
            	
            }
        } catch (NumberFormatException e){
            System.err.println("Вы должны внести цифру 1, 2 или 3");
        }        
 
    }
 
    public static String input(String prompt){
    	System.out.println(prompt);     	
        return (new Scanner(System.in)).nextLine();
    }
 
    private static Doctor createDoctor(){
        String name = input("Введите имя врача");
        String surname = input("Введите фамилию врача");
        String spec = input("Введите специализацию врача"); 
        return new Doctor(name, surname, spec);
     }
	
}
