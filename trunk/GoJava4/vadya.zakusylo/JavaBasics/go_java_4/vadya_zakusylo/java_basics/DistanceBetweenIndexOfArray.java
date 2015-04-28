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
	static LinkedHashSet<Integer> arrayList = new LinkedHashSet<Integer>();

	public static void main(String[] args) {
		try {
			initArray();
		} catch (InputMismatchException e) {
			// NOP
		}
		System.out.println("\nArray of unique integer values:");
		System.out.println(arrayList);
		showDistance();

	}

	static void initArray() {
		System.out.print("Enter integer values into array. ");
		System.out.println("Enter any incorrect value to exit.");
		try (Scanner inputValue = new Scanner(System.in)) {
			do {
				arrayList.add(inputValue.nextInt());
			} while (inputValue.hasNext());
		}
	}

	private static void showDistance() {
		// Create copy of arrayList, convert copyArrayList to Integer [] array
		// and sort Integer [] array to Integer[] arraySorted
		ArrayList<Integer> copyArrayList = new ArrayList<Integer>();
		copyArrayList.addAll(arrayList);
		Integer[] array = copyArrayList.toArray(new Integer[copyArrayList
				.size()]);
		Integer[] arraySorted = sortBubble(array);
		// Show distance between min values
		int firstMinValue = copyArrayList.indexOf(arraySorted[0]);
		int secondMinValue = copyArrayList.indexOf(arraySorted[1]);
		System.out.print("Distance between unique values - ");
		System.out.println(Math.abs(firstMinValue - secondMinValue));
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
}
