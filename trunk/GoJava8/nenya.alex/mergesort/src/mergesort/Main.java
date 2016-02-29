package mergesort;

import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) {
		MergeSort mergSort = new MergeSort();
		int[] array = { 23, 56, -45, 1, 0, 125, 56, 55, -32 };
		System.out.println("Before:	" + Arrays.toString(array));
		int[] result = null;
		try {
			result = mergSort.sort(array);
		} catch (EmptyArrayException e) {
			e.printStackTrace();
		}
		System.out.println("After:	" + Arrays.toString(result));
	}
}
