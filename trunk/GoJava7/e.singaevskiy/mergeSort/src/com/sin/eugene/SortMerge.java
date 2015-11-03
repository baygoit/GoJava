package com.sin.eugene;

public class SortMerge {

	// OLEG array... So many meaning... But may be there it is OK
	public static void sort(int[] array) {
		// OLEG there is nothing persistent then temporal. Rename it to something meanful
		// OLEG why we need it at all?
		int[] tmpArray = new int[array.length];
		split(array, tmpArray, 0, array.length - 1);
	}

	// OLEG we use tmpArray for...?
	private static void split(int[] array, int[] tmpArray, int firstIndex, int lastIndex) {

		if (lastIndex > firstIndex) {
			int midIndex = (lastIndex + firstIndex) / 2;

			// OLEG we use tmpArray for?
			split(array, tmpArray, firstIndex, midIndex);
			split(array, tmpArray, midIndex + 1, lastIndex);

			sortAndMerge(array, tmpArray, firstIndex, midIndex, lastIndex);
		}
		
	}

	private static void sortAndMerge(int[] array, int[] tmpArray, int firstIndex, int midIndex, int lastIndex) {
		// OLEG commented code? WTF?
		//int[] tmpArray = new int[lastIndex-firstIndex+1];
		
		// OLEG nice nice, but tmpArray was created not here the first time. Can we refactor our code so it becames understandable without this long comment?
		// OLEG again, what is purpose for tmpArray? Why we pass array and tmpArray?
		// Instead of creating another new tmpArray each time, we can use the same tmpArray everytime.
		// We will just use its range in two pieces: 
		//  - from firstIndex to midIndex
		//  - from midIndex+1 to lastIndex

		// OLEG curson with curson and curson above. What are they for? I cannot understand without deep code analysing
		// OLEG and again thing *Tmp. And why tmpArray but cursorTmp?
		int cursorTmp = 0;
		int cursor1 = firstIndex;
		int cursor2 = midIndex+1;
		
		// OLEG too tired to check this algorithm :)
		while (cursor1 <= midIndex && cursor2 <= lastIndex) {
			if (array[cursor1] < array[cursor2]) {
				tmpArray[cursorTmp++] = array[cursor1++];
			} else {
				tmpArray[cursorTmp++] = array[cursor2++];
			}
		}
		
		// OLEG and here
		while (cursor1 <= midIndex) {
			tmpArray[cursorTmp++] = array[cursor1++];
		}
		// OLEG and there, later
		while (cursor2 <= lastIndex) {
			tmpArray[cursorTmp++] = array[cursor2++];
		}
		
		// OLEG later
		for (cursorTmp = 0; cursorTmp < lastIndex-firstIndex+1; cursorTmp++)
			array[firstIndex+cursorTmp] = tmpArray[cursorTmp];
		
	}
	
}
