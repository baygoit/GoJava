package com.sin.eugene.sorting;

import com.sin.eugene.Util;

public class QuickSort implements SortingAlgoritm {

	@Override
	public void sort(int[] array) {
		qsort(array, 0, array.length - 1);
	}
	
	private void qsort(int[] array, int firstIndex, int lastIndex) {
		 
		if (firstIndex >= lastIndex)
			return;
 
		int midIndex = firstIndex + (lastIndex - firstIndex) / 2;
		int midValue = array[midIndex];
 
		int i = firstIndex, j = lastIndex;
		while (i <= j) {
			while (array[i] < midValue) {
				i++;
			}
 
			while (array[j] > midValue) {
				j--;
			}
 
			if (i <= j) {
				Util.swap(array, i, j);
				i++;
				j--;
			}
		}
 
		if (firstIndex < j)
			qsort(array, firstIndex, j);
 
		if (lastIndex > i)
			qsort(array, i, lastIndex);
    }

}
