package com.sin.eugene.sorting;

import com.sin.eugene.Util;

public class BoubleSort implements SortingAlgoritm {

	@Override
	public void sort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = array.length-1; j > 0; j--) {
				if (array[j] < array[j-1]) {
					Util.swap(array, j, j-1);
				}
			}
		}
	}

}
