package swap;

import java.util.Arrays;

public class SortInsertion {

	public static void main(String[] args) {
		int[] a = { 5, 3, 5, 6, 8, 9, 10, 2, 1, 6, 3 };
		for (int i = 1; i < a.length; i++) {
			int currElem = a[i];
			int prevKey = i - 1;
			while (prevKey >= 0 && a[prevKey] > currElem) {
				a[prevKey + 1] = a[prevKey];
				a[prevKey] = currElem;
				prevKey--;
			}
		}
		System.out.println(Arrays.toString(a));
	}
}