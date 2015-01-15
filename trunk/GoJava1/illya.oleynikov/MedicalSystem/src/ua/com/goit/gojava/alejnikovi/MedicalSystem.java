package ua.com.goit.gojava.alejnikovi;

import java.util.*;

public class MedicalSystem {
		
	public static void main(String[] args) {
		
		ArrayList<Object> doctors = new ArrayList<Object>();
		int choose = 0;
		
		while (choose != 3) try {
			System.out.println("Хотите создать врача (1) или просмотреть список(2). 3 - для выхода");
			choose = Integer.parseInt(Doctor.input());
			if (choose == 1){
				doctors.add(new Doctor());
			} else if (choose == 2){
				System.out.println("Количество записй в базе - " + doctors.size());
			} 
		} catch (NumberFormatException e){
			System.err.println("Вы должны внести цыфру 1, 2 или 3");
		}
		
		for (int i = 0; i < doctors.size(); i++){						//TODO: вынести в метод
			System.out.println(((Doctor) doctors.get(i)).getSpec());
		}
				 						
	}
	
}
