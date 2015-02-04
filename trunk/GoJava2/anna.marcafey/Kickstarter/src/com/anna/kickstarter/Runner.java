package com.anna.kickstarter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		List<String> qoutes = new ArrayList<String>();
		qoutes.add("here will be nice words...");
		qoutes.add("will");
		qoutes.add("be");
		qoutes.add("nice");
		qoutes.add("words");
		
		int random = (int) (Math.random()*qoutes.size());
		System.out.println(qoutes.get(random));
		
		System.out.println("Thanks for using my program!");

//		System.out.println("1) " + Category.DESIGN);
//		System.out.println("2) " + Category.MUSIC);
//		System.out.println("3) " + Category.SPORT);
//		
//		StringBuilder text = new StringBuilder(); 
//		Scanner sc = new Scanner(System.in);
//		String temp;
//		while ((temp = sc.nextLine()).length() > 0){
//		    text.append(temp);
//		}

	}

}
