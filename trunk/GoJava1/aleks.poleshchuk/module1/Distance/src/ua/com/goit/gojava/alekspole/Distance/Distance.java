package ua.com.goit.gojava.alekspole.Distance;

import java.util.Scanner;
import java.util.Arrays;

public class Distance {
	public static void main (String[] args){
		Scanner scan = new Scanner (System.in);
		System.out.println("Input array length:");		
		int arrayLength = scan.nextInt();
		int[] array = getArray(arrayLength);
		calcArray (array);
		scan.close();
		
	}

	public static int[] getArray(int arrayLength){
			Scanner scan = new Scanner (System.in);
			int [] array = new int [arrayLength];
			
			System.out.print("Input array elements:");
			
			for (int i = 0; i < array.length; i++){
				array[i] = scan.nextInt();
			}
			
			for (int i = 0; i < array.length-1; i++) {
				System.out.print (array[i] + ", ");
				}
			for (int i = array.length-1; i <= array.length-1; i++) {
				System.out.print (array[i]);
				}
			System.out.println();	
			scan.close();
	return array;	
	}	
	
	public static void calcArray (int[] array){
			int[] temp = array.clone();
			
			Arrays.sort(array);
			
			int firstMin = temp[0];
			int secondMin = temp[1];
			int min1Pos = 0;
			int min2Pos = 0;
			for (int i = 0; i<array.length; i++){
				if (array[i] == firstMin){
				min1Pos = i;	
				}
				if (array[i] == secondMin){
					min2Pos = i;	
				}
			}
			System.out.println(firstMin + " Min1");
			System.out.println(secondMin + " Min2");
			System.out.println(Math.abs(min1Pos-min2Pos) + " Distance between Min1 & Min2"); 
	}

}
