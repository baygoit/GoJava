package com.tyomsky;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Distance {
	public static final String delimiter = " +";
	public static BufferedReader consoleReader;

	public static void main(String[] args) throws IOException {
		consoleReader = new BufferedReader(new InputStreamReader(System.in));
		int[] inputArray;
		int distanceBetweenMins;
		boolean isFinished = false;
		while (!isFinished) {
			System.out.println("Enter values:");
			inputArray = getArrayOfIntegersFromConsole(consoleReader);
			if (inputArray != null) {
				distanceBetweenMins = getDistanceBetweenMins(inputArray);
				if (distanceBetweenMins == 0) {
					System.out.println("Enter more then one number.");
				} else {
					System.out.println("Distance between mins: " + distanceBetweenMins);
				}
			}
			System.out.println("Try again? (y/n)");
			if (!consoleReader.readLine().equals("y")) {
				isFinished = true;
			}
		}
	}

	public static int getDistanceBetweenMins(int[] inputArray) {
		int result = 0;
		if (inputArray != null && inputArray.length > 1) {
			int firstMinValueIndex = 0;
			int secondMinValueIndex = 1;
			for (int i = 0; i < inputArray.length; i++) {
				if (inputArray[firstMinValueIndex] > inputArray[i] && i != secondMinValueIndex) {
					if (inputArray[secondMinValueIndex] > inputArray[firstMinValueIndex]) {
						secondMinValueIndex = firstMinValueIndex;
					}
					firstMinValueIndex = i;
				} else if (inputArray[secondMinValueIndex] > inputArray[i] && i != firstMinValueIndex) {
					secondMinValueIndex = i;
				}
			}
			result = Math.abs(firstMinValueIndex - secondMinValueIndex);
		}
		return result;
	}

	public static int[] getArrayOfIntegersFromConsole(BufferedReader reader) {
		String[] inputStringArray;
		int[] result = null;
		try {
			inputStringArray = reader.readLine().split(delimiter);
			if (inputStringArray.length == 1 && inputStringArray[0].equals("")) {
				System.out.println("I cant read your mind. Enter smtn!");
				return null;
			}
			result = new int[inputStringArray.length];
			for (int i = 0; i < inputStringArray.length; i++) {
				result[i] = Integer.parseInt(inputStringArray[i]);
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

}
