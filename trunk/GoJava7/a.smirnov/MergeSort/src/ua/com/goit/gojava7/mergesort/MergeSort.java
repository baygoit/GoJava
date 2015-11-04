package ua.com.goit.gojava7.mergesort;

import java.util.Arrays;

public class MergeSort {

	public int[] sort(int[] storageOfUserNumbers) {
		int amountOfUserNumbers = storageOfUserNumbers.length;
		if (amountOfUserNumbers < 2) {
			return storageOfUserNumbers;
		}

		int middleIndex = amountOfUserNumbers / 2;

		return merge(sort(Arrays.copyOfRange(storageOfUserNumbers, 0, middleIndex)),
				sort(Arrays.copyOfRange(storageOfUserNumbers, middleIndex, amountOfUserNumbers)));
	}

	private int[] merge(int[] firstArray, int[] secondArray) {
		
		int indexFirstArray = 0;
		int lengthFirstArray = firstArray.length;

		int indexSecondArray = 0;
		int lengthSecondArray = secondArray.length;

		int[] result = new int[lengthFirstArray + lengthSecondArray];

		for (int barrier = 0; barrier < result.length; barrier++) {
			if (indexSecondArray < lengthSecondArray && indexFirstArray < lengthFirstArray) {
				
				if (firstArray[indexFirstArray] > secondArray[indexSecondArray]) {
					result[barrier] = secondArray[indexSecondArray++];
				} else {
					result[barrier] = firstArray[indexFirstArray++];
				}
			} else if (indexSecondArray < lengthSecondArray) {
				result[barrier] = secondArray[indexSecondArray++];
			} else {
				result[barrier] = firstArray[indexFirstArray++];
			}
		}
		return result;
	}
}
