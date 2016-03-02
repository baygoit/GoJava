package com.anmertrix.module1.mergesort;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		Integer[] data = { 2, 6, 3, 5, 1 };
		mergeSort(data);
		System.out.println(Arrays.toString(data));
	}

	public static void mergeSort(Comparable[] data) {
		Comparable[] tmp = new Comparable[data.length];
		mergeSort(data, tmp, 0, data.length - 1);
	}

	private static void mergeSort(Comparable[] data, Comparable[] tmp, int left, int right) {
		if (left < right) {
			int center = (left + right) / 2;
			mergeSort(data, tmp, left, center);
			mergeSort(data, tmp, center + 1, right);
			merge(data, tmp, left, center + 1, right);
		}
	}

	private static void merge(Comparable[] data, Comparable[] tmp, int left, int right, int rightEnd) {
		int leftEnd = right - 1;
		int count = left;
		int num = rightEnd - left + 1;

		while (left <= leftEnd && right <= rightEnd) {
			if (data[left].compareTo(data[right]) <= 0) {
				tmp[count++] = data[left++];
			} else {
				tmp[count++] = data[right++];
			}
		}
		while (left <= leftEnd) { // Copy rest of first half
			tmp[count++] = data[left++];
		}

		while (right <= rightEnd) { // Copy rest of right half
			tmp[count++] = data[right++];
		}

		// Copy tmp back
		for (int i = 0; i < num; i++, rightEnd--) {
			data[rightEnd] = tmp[rightEnd];
		}
	}

}
