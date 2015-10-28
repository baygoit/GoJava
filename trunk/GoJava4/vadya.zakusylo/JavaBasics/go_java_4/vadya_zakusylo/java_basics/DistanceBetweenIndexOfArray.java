package go_java_4.vadya_zakusylo.java_basics;

/*
 * This code initializes array of unique integer numbers and counts distances between indexes
 * of the minimum numbers.
 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class DistanceBetweenIndexOfArray {
	static LinkedHashSet<Integer> linkedHashSetValues;
	static ArrayList<Integer> arrayListValues;

	public static void main(String[] args) {
		try {
			initArray();
		} catch (InputMismatchException e) {
			// NOP
		}
		try {
			showDistance();
		} catch (ShortArrayException e) {
			System.out.println("You have entered only one correct value. Try again!");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("You don't enter any integer values. Try again.");
		}

	}

	static void initArray() throws ShortArrayException {
		System.out.print("Enter integer values into array. ");
		System.out.println("Enter any incorrect value to exit.");
		try (Scanner inputValue = new Scanner(System.in)) {
			do {
				linkedHashSetValues.add(inputValue.nextInt());
			} while (inputValue.hasNext());
		}
	}

	private static void showDistance() {
		Integer[] values = convertArrayLinkedHashSetToArray();
		int firstMinValue = arrayListValues.indexOf(values[0]);
		int secondMinValue = arrayListValues.indexOf(values[1]);
		System.out.println("\nArray of unique integer values:");
		System.out.println(linkedHashSetValues);
		System.out.print("Distance between unique values - ");
		System.out.println(Math.abs(firstMinValue - secondMinValue));
	}

	private static Integer[] convertArrayLinkedHashSetToArray() {
		arrayListValues.addAll(linkedHashSetValues);
		Integer[] values = linkedHashSetValues.toArray(new Integer[arrayListValues.size()]);
		values = sortBubble(values);
		if (values.length == 1) {
			throw new ShortArrayException();
		}
		return values;
	}

	private static Integer[] sortBubble(Integer[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					swap(array, j);
				}
			}
		}
		return array;
	}

	private static void swap(Integer[] array, int i) {
		int k = array[i];
		array[i] = array[i + 1];
		array[i + 1] = k;
	}

	private static class ShortArrayException extends ArrayIndexOutOfBoundsException {
		private static final long serialVersionUID = 1L;
		// NOP
	}
}
