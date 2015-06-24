package com.ua.goit.belskii.artem;

import java.util.Scanner;

public class Input {
	Scanner consoleIn = new Scanner(System.in);
	private String input="";
	
	public void setString(){
		System.out.println("Please, enter text");
		input=consoleIn.nextLine();
	}
	public String getString(){
		return input;
	}
	
	
}
