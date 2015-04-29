package swap;

import java.util.Arrays;

public class SortBubble {

	public static void main(String[] args) {
		int[] array = { 15, 2, 20, 17, 3, 65, 42 };
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					swap(array, j);
				}
			}
		}
		System.out.println(Arrays.toString(array));
		for (int i = array.length - 1; i >= 0; i--) {
			for (int j = array.length - 1; j > array.length - 1 - i; j--) {
				if (array[j] > array[j - 1]) {
					swap(array, j - 1);
				}
			}
		}
		System.out.println(Arrays.toString(array));
	}

	private static void swap(int[] array, int i) {
		int k = array[i];
		array[i] = array[i + 1];
		array[i + 1] = k;
	}

}
