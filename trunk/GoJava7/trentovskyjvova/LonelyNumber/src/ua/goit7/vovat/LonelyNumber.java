package ua.goit7.vovat;

import java.util.Scanner;

public class LonelyNumber {

	public static void main(String[] args) {
		
		Integer[] numbers = null;
		
		if (args.length != 0) {
			numbers = convertStringArrayToIntegerArray(args);
		} else {
			numbers = convertStringArrayToIntegerArray(scanUserInput());
		}
		
		//Integer[] numbers = {1, 2, 3, 6, 2, 3, 4, 4, 5, 6, -3, -3, 0, 0};
		System.out.println("Number = " + findLonelyNumber(numbers));
		
	}
	
	private static int findLonelyNumber(Integer[] numbers){
		
		for (int i = 0; i < numbers.length; i++) {
			int countCopies = 0;
			for (int j = 0; j < numbers.length; j++) {
				if((numbers[i] == numbers[j])){
					countCopies++;
					if(countCopies == 3){
						return numbers[i];
					}
				}
			}
		}		
		return 0;
	}
	
	private static String[] scanUserInput() {
		
		System.out.println("Enter array of integer");
		Scanner scanner = new Scanner(System.in);
		
		String arrayOfNumbers = "";	
		if(scanner.hasNextLine()){	
			arrayOfNumbers = scanner.nextLine();
		}
		scanner.close();
		
		return arrayOfNumbers.split(" ");
	}

	private static Integer[] convertStringArrayToIntegerArray(String[] args) {
		
		Integer[] numbers = new Integer[args.length];
	
		for (int i = 0; i < args.length; i++) {
			numbers[i] = Integer.parseInt(args[i]);
		}
		return numbers;
	}
}
