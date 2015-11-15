package ua.com.goit.gojava7.sort.sorting;

public class MergeSort implements SortingAlgoritm {

	@Override
	public void sort(int[] array) {
		int[] tmpArray = new int[array.length];
		split(array, tmpArray, 0, array.length - 1);
	}

	private void split(int[] array, int[] tmpArray, int firstIndex, int lastIndex) {

		if (lastIndex > firstIndex) {
			int midIndex = (lastIndex + firstIndex) / 2;

			split(array, tmpArray, firstIndex, midIndex);
			split(array, tmpArray, midIndex + 1, lastIndex);

			sortAndMerge(array, tmpArray, firstIndex, midIndex, lastIndex);
		}

	}

	private void sortAndMerge(int[] array, int[] tmpArray, int firstIndex, int midIndex, int lastIndex) {

		// int[] tmpArray = new int[lastIndex-firstIndex+1];

		// Instead of creating another new tmpArray each time, we can use the
		// same tmpArray everytime.
		// We will just use its range in two pieces:
		// - from firstIndex to midIndex
		// - from midIndex+1 to lastIndex

		int cursorTmp = 0;
		int cursor1 = firstIndex;
		int cursor2 = midIndex + 1;

		while (cursor1 <= midIndex && cursor2 <= lastIndex) {
			if (array[cursor1] < array[cursor2]) {
				tmpArray[cursorTmp++] = array[cursor1++];
			} else {
				tmpArray[cursorTmp++] = array[cursor2++];
			}
		}

		while (cursor1 <= midIndex) {
			tmpArray[cursorTmp++] = array[cursor1++];
		}
		while (cursor2 <= lastIndex) {
			tmpArray[cursorTmp++] = array[cursor2++];
		}

		for (cursorTmp = 0; cursorTmp < lastIndex - firstIndex + 1; cursorTmp++)
			array[firstIndex + cursorTmp] = tmpArray[cursorTmp];

	}

}
