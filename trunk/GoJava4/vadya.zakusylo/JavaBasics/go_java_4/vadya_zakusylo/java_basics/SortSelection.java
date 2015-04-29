package swap;

import java.util.Arrays;

public class SortSelection {

	public static void main(String[] args) {
		int[] a = { 5, 3, 5, 6, 8, 9, 10, 2, 1, 6, 3 };

		for (int index = 0; index < a.length - 1; index++) {
			for (int scan = index + 1; scan < a.length; scan++) {
				if (a[index] > a[scan]) {
					swap(a, index, scan);
				}
			}
		}
		System.out.println(Arrays.toString(a));
	}

	private static void swap(int[] a, int index, int scan) {
		int temp = a[index];
		a[index] = a[scan];
		a[scan] = temp;
	}
}
