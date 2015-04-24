package am.java;

// import java.util.Arrays;
import java.util.Scanner;

public class Distance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner (System.in);
		
		System.out.println ("Hello! Please, enter 5 values");
		System.out.println ("for example: 45 5 21");
		
		int[] ArrayOfValues = new int[5];
		
		for (int i=0; i<ArrayOfValues.length; i++) {
			int value = in.nextInt();
			ArrayOfValues[i] = value;
		}
		in.close();
		
		int minOne = ArrayOfValues[0];
		int numberMinOne = 0;
		int minTwo = ArrayOfValues[0];
		int numberMinTwo = 0;
		for (int i=0; i<(ArrayOfValues.length - 1); i++) {
			if (minOne >= ArrayOfValues[i+1]) {
				minTwo = minOne;
				numberMinTwo = numberMinOne;
				minOne = ArrayOfValues[i+1];
				numberMinOne = i+1;
				}
		}
		
		int distanceBetweenMinimums = Math.abs(numberMinOne - numberMinTwo);
		
		System.out.println ("minOne = " + minOne);
		System.out.println ("minTwo = " + minTwo);
		System.out.println ("The distance between two minimum values of  " + distanceBetweenMinimums);
		
	}

}
