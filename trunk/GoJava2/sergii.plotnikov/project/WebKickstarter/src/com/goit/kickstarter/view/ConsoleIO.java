package com.goit.kickstarter.view;

import java.util.Scanner;

public class ConsoleIO{
	
	public int input() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}
	
	public String stringInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
	
	public void out(String message){
		System.out.println(message);
	}
}
