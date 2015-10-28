package ua.goit7.vovat;

import java.util.Arrays;
import java.util.Random;

public class Mergesort {

	public static void main(String[] args) {
		
		Random r = new Random(); 
		Comparable[] arr = new Comparable[10];
		for (int i = 0; i < 10; i++) {
			// рандом от 0 до 99
			arr[i] = r.nextInt(100);
			System.out.print(arr[i] + ", ");
		}
		System.out.println();
				
		Comparable[] inputArr = arr;
		//Comparable[] inputArr = { 45, 23, 11, 89, 77, 98, 4, 28, 65, 43 };
		//Comparable[] inputArr = { 38, 27, 43, 3, 9, 82, 10 };
		mergeSort(inputArr);
		System.out.println(Arrays.toString(inputArr));
	}

	public static void mergeSort(Comparable[] a) {
		Comparable[] tmp = new Comparable[a.length];
		mergeSort(a, tmp, 0, a.length - 1);
	}

	private static void mergeSort(Comparable[] a, Comparable[] tmp, int left, int right) {
		if (left < right) {
			int center = (left + right) / 2;
			mergeSort(a, tmp, left, center);
			mergeSort(a, tmp, center + 1, right);
			merge(a, tmp, left, center + 1, right);
		}
	}

	private static void merge(Comparable[] a, Comparable[] tmp, int left, int right, int rightEnd) {
		int leftEnd = right - 1;
		int k = left;
		int num = rightEnd - left + 1;

		while (left <= leftEnd && right <= rightEnd)
			if (a[left].compareTo(a[right]) <= 0)
				tmp[k++] = a[left++];
			else
				tmp[k++] = a[right++];

		while (left <= leftEnd) // Copy rest of first half
			tmp[k++] = a[left++];

		while (right <= rightEnd) // Copy rest of right half
			tmp[k++] = a[right++];

		// Copy tmp back
		for (int i = 0; i < num; i++, rightEnd--)
			a[rightEnd] = tmp[rightEnd];
	}
}
