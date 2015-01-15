package ua.com.goit.gojava.alejnikovi;

import java.util.*;

public class Doctor {
	
	String name;
	String surname;
	String specialization;

	Doctor (){
		System.out.println("Внесите имя нового доктора");
		name = input();
		System.out.println("Внесите фамилию нового доктора");
		surname = input();
		System.out.println("Внесите специализацию нового доктора");
		specialization = input();
		System.out.println("Спасибо! Добавлен новый доктор: " + name + " " + surname + " " + specialization);
		System.out.println();
	}
	
	public static String input(){
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}
	
	public String getSpec(){
		return this.specialization;
	}

}
