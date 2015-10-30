package com.gmail.grezin.v;
/*
 * Task 5:
 * Given an array of integers where all numbers except lonely repeal less then 3 times
 * find this lonely number
 */
import java.util.Arrays;
import java.util.Scanner;

public class LonleyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers;
		String text;
		Scanner scan = new Scanner(System.in);

		System.out.println("Could you please enter array that contain Lonely number");
		text = scan.nextLine();
		scan.close();
		numbers = getArray(text);
		Arrays.sort(numbers);
		for (int i = 0; i < numbers.length; i++)
			if ((numbers[i] == numbers[i + 1]) && (numbers[i] == numbers[i + 2])) {
				System.out.println("Lonley number is " + numbers[i]);
				break;
			}
	}

	public static int[] getArray(String text) {
		String[] textArray = { "" };
		int[] numbers;
		int position;
		
		position = text.indexOf(" ");
		if (position != -1) {
			textArray = text.split("[ ]");
		}
		position = text.indexOf(",");
		if (position != -1) {
			textArray = text.split("[,]");
		}
		position = text.indexOf(";");
		if (position != -1) {
			textArray = text.split("[;]");
		}
		numbers = new int[textArray.length];
		for (int i = 0; i < textArray.length; i++) {
			numbers[i] = Integer.parseInt(textArray[i]);
			System.out.print(numbers[i] + " ");
		}
		System.out.println();
		return numbers;
	}

}
