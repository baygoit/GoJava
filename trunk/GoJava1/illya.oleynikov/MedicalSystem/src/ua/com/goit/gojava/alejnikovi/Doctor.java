package ua.com.goit.gojava.alejnikovi;

import java.util.*;

public class Doctor {
	
	String name;
	String surname;
	String specialization;

	Doctor (String name, String surname, String specialisation){
		this.name = name;
		this.surname = surname;
		this.specialization = specialization;
	}  
  
	public String getSpec(){
		return this.specialization;
	}

}
