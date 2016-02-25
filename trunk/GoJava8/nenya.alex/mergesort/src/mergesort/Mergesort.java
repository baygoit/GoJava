package mergesort;

import java.util.Arrays;

public class Mergesort {

	private int[] numbers;
	private int[] helpArray;
	private int size;

	public static void main(String[] args) {
		int[] array = { 23, 56, -45, 1, 0, 125, 56, 55, -32 };
		System.out.println("Before:	" + Arrays.toString(array));
		new Mergesort().sort(array);
		System.out.println("After:	" + Arrays.toString(array));
	}

	public void sort(int[] array) {
		this.numbers = array;
		size = array.length;
		this.helpArray = new int[size];
		mergesort(0, size - 1);
	}

	private void mergesort(int low, int high) {
		if (low < high) {
			int middle = low + (high - low) / 2;
			mergesort(low, middle);
			mergesort(middle + 1, high);
			merge(low, middle, high);
		}
	}

	private void merge(int low, int middle, int high) {
		for (int i = low; i <= high; i++) {
			helpArray[i] = numbers[i];
		}

		int i = low;
		int j = middle + 1;
		int k = low;
		while (i <= middle && j <= high) {
			if (helpArray[i] <= helpArray[j]) {
				numbers[k] = helpArray[i];
				i++;
			} else {
				numbers[k] = helpArray[j];
				j++;
			}
			k++;
		}
		while (i <= middle) {
			numbers[k] = helpArray[i];
			k++;
			i++;
		}

	}
}
