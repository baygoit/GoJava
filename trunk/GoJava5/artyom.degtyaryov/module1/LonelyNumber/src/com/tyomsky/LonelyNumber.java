package com.tyomsky;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LonelyNumber {

	public static final String delimiter = " +";
	public static BufferedReader reader; 
	public static void main(String[] args) throws IOException {
		reader = new BufferedReader(new InputStreamReader(System.in));
		boolean isFinished = false;
		while (!isFinished) {
			int[] numbers = getArrayOfIntegersFromConsole();
			if (numbers != null) {
				System.out.println(getLonelyNumberInArray(numbers));

			}
			System.out.println("Try again? (y/n)");
			if (!reader.readLine().equals("y")) {
				isFinished = true;
			}
		}
	}

	public static int[] getArrayOfIntegersFromConsole() {
		System.out.println("Enter numbers: ");
		int[] result;
		try {
			String[] inputArray = reader.readLine().split(delimiter);
			result = new int[inputArray.length];
			for (int i = 0; i < inputArray.length; i++) {
				result[i] = Integer.parseInt(inputArray[i]);
			}
		} catch (NumberFormatException e) {
			System.out.println("I work only with integers ):");
			result = null;
		} catch (IOException e) {
			System.out.println("Something wrong with IO! ):");
			result = null;
		} catch (Exception e) {
			System.out.println("Unexpected exception!");
			System.out.println(e.getStackTrace());
			result = null;
		}
		return result;
	}

	public static int getLonelyNumberInArray(int[] array) {
		final int INT_BIT_SIZE = 32;
		int result = 0;
		int currentBit, sum;
		for (int i = 0; i < INT_BIT_SIZE; i++) {
			sum = 0;
			currentBit = (1 << i);
			for (int j = 0; j < array.length; j++) {
				// (http://www.geeksforgeeks.org/find-the-element-that-appears-once/)
				if ((array[j] & currentBit) != 0)
					sum++;
			}
			if (sum % 3 != 0) {
				result |= currentBit;
			}
		}
		return result;
	}
}
