package go_java_4.vadya_zakusylo.java_basics;

import java.util.Arrays;

public class SortSelection {

	public static void main(String[] args) {
		int[] a = { 5, 3, 5, 6, 8, 9, 10, 2, 1, 6, 3 };

		for (int index = 0; index < a.length - 1; index++) {
			for (int workedIndex = index + 1; workedIndex < a.length; workedIndex++) {
				if (a[index] > a[workedIndex]) {
					swap(a, index, workedIndex);
				}
			}
		}
		System.out.println(Arrays.toString(a));
	}

	private static void swap(int[] a, int index, int workedIndex) {
		int temporaryIndex = a[index];
		a[index] = a[workedIndex];
		a[workedIndex] = temporaryIndex;
	}
}