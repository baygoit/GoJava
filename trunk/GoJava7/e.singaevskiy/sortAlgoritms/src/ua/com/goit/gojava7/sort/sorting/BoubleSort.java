package ua.com.goit.gojava7.sort.sorting;

import ua.com.goit.gojava7.sort.Util;

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
