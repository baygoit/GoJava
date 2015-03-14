package edu.sergii.tishenko.task3;

import java.util.Scanner;

public class Annagram {

	public static void main(String[] args) {

		String strInputLine;
		Scanner in = new Scanner(System.in);

		System.out.println("Enter string:");
		strInputLine = in.nextLine();
		strInputLine = strInputLine.trim();
		in.close();

		String[] strArr = strInputLine.split(" ");
		
		for (int i = 0; i < strArr.length; i++) {
			System.out.print(new StringBuilder(strArr[i]).reverse().toString() + " ");
		}
	}

}
