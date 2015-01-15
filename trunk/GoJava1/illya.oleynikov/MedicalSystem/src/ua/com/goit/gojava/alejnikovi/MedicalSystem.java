package ua.com.goit.gojava.alejnikovi;

import java.util.*;

public class MedicalSystem {
		
		public static void main(String[] args) {
 
        ArrayList<Doctor> doctors = new ArrayList<Doctor>();
        int choose = 0;
 
        while (choose != 3) try {
            System.out.println();
            choose = Integer.parseInt(input("Для создания нового врача введите '1'" + "\n" +
                                            "Для просмотра списка врачей введите '2'" + "\n" +
                                            "Для выхода введите '3'"));
            System.out.println();
            if (choose == 1){
                doctors.add(createDoctor());
            } else if (choose == 2){
                System.out.println("Количество записй в базе - " + doctors.size());
            }
        } catch (NumberFormatException e){
            System.err.println("Вы должны внести цифру 1, 2 или 3");
        }
 
        for (int i = 0; i < doctors.size(); i++){	//TODO: move to method
            System.out.println(((Doctor) doctors.get(i)).getSpec());
        }
 
    }
 
    public static String input(String prompt){
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        return sc.nextLine();
    }
 
    private static Doctor createDoctor(){
        String name = input("Введите имя врача");
        String surname = input("Введите фамилию врача");
        String spec = input("Введите специализацию врача");
 
        return new Doctor(name, surname, spec);
 
    }
	
}
