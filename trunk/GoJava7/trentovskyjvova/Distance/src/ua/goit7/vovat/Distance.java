package ua.goit7.vovat;

import java.util.Scanner;

/*
 * Takes as input an array of numbers and output the distance between the two lowest
 * For example, given a series of numbers: "23 45 34 12 45 4 38 56 2 49 100". 
 * The smallest number in it 2 and 4. The distance between them is -3.
 */
public class Distance {

	public static void main(String[] args) {
		
		Integer[] numbers = null;
		
		if (args.length != 0) {
			numbers = convertStringArrayToIntegerArray(args);
		} else {
			numbers = convertStringArrayToIntegerArray(scanUserInput());
		}
		
		int[] litlest = findTwoLowestNumbers(numbers);
			
		System.out.print("Distances: " + findDistances(numbers, litlest));
		
	}

	private static String findDistances(Integer[] numbers, int[] litlest) {
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numbers.length; i++) {
			if(numbers[i] == litlest[0]){
				for (int j = 0; j < numbers.length; j++) {
					if(numbers[j] == litlest[1] && j != i){
						sb.append(j - i).append(", ");
					}
				}	
			}
		}
		sb.setLength(sb.length() - 2);
		return sb.toString();
	}

	private static int[] findTwoLowestNumbers(Integer[] numbers) {
		
		int[] litlest = {Integer.MAX_VALUE, Integer.MAX_VALUE};
		
		for (int i = 0; i < numbers.length; i++) {
			if(numbers[i] < litlest[0]){
				litlest[1] = litlest[0];
				litlest[0] = numbers[i];
			}else if (numbers[i]<litlest[1]){
				litlest[1] = numbers[i];
			}
		}
		return litlest;
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
