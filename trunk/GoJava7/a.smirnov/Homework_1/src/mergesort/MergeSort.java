package mergesort;

import java.util.Arrays;

public class MergeSort {

	public int[] sort(int[] inputedNumbers) {
		if (inputedNumbers.length < 2) {
			return inputedNumbers;
		} else {
			int amountOfNumbers = inputedNumbers.length;
			return merge(sort(Arrays.copyOfRange(inputedNumbers, 0, amountOfNumbers / 2)),
					sort(Arrays.copyOfRange(inputedNumbers, amountOfNumbers / 2, amountOfNumbers)));
		}
	}

	private int[] merge(int[] arrayOne, int[] arrayTwo) {
		int indexOne = 0;
		int indexTwo = 0;
		
		int amountInOne = arrayOne.length;
		int amountInTwo = arrayTwo.length;
		int amountInBoth = amountInOne + amountInTwo;
		int[] result = new int[arrayOne.length + arrayTwo.length];
		
		for (int barrier = 0; barrier < amountInBoth; barrier++) {
			if (indexTwo < amountInTwo 
					&& indexOne < amountInOne) {
				
				if (arrayOne[indexOne] > arrayTwo[indexTwo]) {
					result[barrier] = arrayTwo[indexTwo++];
				} else {
					result[barrier] = arrayOne[indexOne++];
				}
			} else if (indexTwo < amountInTwo) {
				result[barrier] = arrayTwo[indexTwo++];
			} else {
				result[barrier] = arrayOne[indexOne++];
			}
		}
		return result;
	}

}
