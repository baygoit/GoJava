package com.anna.kickstarter;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		System.out.println("here will be nice words...");
		
		System.out.println("1) " + Category.DESIGN);
		System.out.println("2) " + Category.MUSIC);
		System.out.println("3) " + Category.SPORT);
		
		StringBuilder text = new StringBuilder(); 
		Scanner sc = new Scanner(System.in);
		String temp;
		while ((temp = sc.nextLine()).length() > 0){
		    text.append(temp);
		}

	}

}
