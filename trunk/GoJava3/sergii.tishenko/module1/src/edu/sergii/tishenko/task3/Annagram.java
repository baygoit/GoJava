package edu.sergii.tishenko.task3;

import java.util.Scanner;

public class Annagram {

	public static void main(String[] args) {

		String strInputLine;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter string:");
		strInputLine = in.nextLine();
		strInputLine = strInputLine.trim();
		int pos = 0 ,startPos =0;
		in.close();

		StringBuilder strResult = new StringBuilder();
		
		// 1: Solution without additional String[] 

		for (int i = 0; i < strInputLine.length() ; i++) {
			if(strInputLine.charAt(i) == ' '  || i == strInputLine.length() - 1){
				
				if(i == strInputLine.length() - 1) startPos = i;
				else startPos = i - 1;
					
				for(int k =startPos; k >= pos; k--){
					strResult.append(strInputLine.charAt(k));
				}
				strResult.append(' ');
				pos = i + 1;
			}
		}
		System.out.println("1:" + strResult);

		
		// 2: Solution with additional String[] 
		String[] strArr = strInputLine.split(" ");
		System.out.print("2:");
		for (int i = 0; i < strArr.length; i++) {
			System.out.print(new StringBuilder(strArr[i]).reverse().toString() + " ");
		}
	}

}
