package ua.com.goit.gojava.alekspole.Distance;

import java.util.Scanner;
import java.util.Arrays;

public class Distance {
	
	public static void main (String[] args){
		Scanner scan = new Scanner (System.in);
		
		System.out.println("Input array elements with spaces:");	
		
		String arrayString = scan.nextLine();
		
		int [] arrayInt = stringToIntConv (arrayString);
		
		findMinElements (arrayInt);
		
		scan.close();
		
	}

	
	public static int[] stringToIntConv (String arrayString){
		
		String [] arrayStr = arrayString.split("\\s+");	
		
		int[] arrayInt = new int [arrayStr.length];
		
		for (int i = 0; i < arrayInt.length; i++){
			try {
				arrayInt[i] = Integer.parseInt(arrayStr[i]);
			} catch (NumberFormatException nfe) {
				System.out.println("Incorrect values!");
				break;
			  }
			
		}
		
		return arrayInt;
	}
	
	public static void findMinElements (int[] arrayInt){
			int[] temp = arrayInt.clone();
			
			Arrays.sort(arrayInt);
			
			for (int i = 0; i < temp.length; i++){
				System.out.print(temp[i] + " ");
			}
			System.out.println();
			
			int firstMin = arrayInt[0];
			int secondMin = arrayInt[1];
			int min1Pos = 0;
			int min2Pos = 0;
			
			for (int i = 0; i<arrayInt.length; i++){
				if (temp[i] == firstMin){
				min1Pos = i;	
				}
				if (temp[i] == secondMin){
					min2Pos = i;	
				}
			}
			System.out.println(firstMin + " Min1");
			System.out.println(secondMin + " Min2");
			System.out.println(Math.abs(min1Pos-min2Pos) + " Distance between Min1 & Min2"); 
	}

}
