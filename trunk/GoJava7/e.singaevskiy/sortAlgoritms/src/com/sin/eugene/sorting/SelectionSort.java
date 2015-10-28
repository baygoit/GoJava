package com.sin.eugene.sorting;

import com.sin.eugene.Util;

public class SelectionSort implements SortingAlgoritm {

	@Override
	public void sort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i; j < array.length; j++) {
				if (array[i] > array[j]) {
					Util.swap(array, i, j);
				}
			}
		}
	}

}
