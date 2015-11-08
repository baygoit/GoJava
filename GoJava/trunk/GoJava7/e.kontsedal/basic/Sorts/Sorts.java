import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sorts {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		System.out.println("Enter length of random array");

		int[] array = new int[Integer.parseInt(reader.readLine())];
		reader.close();

		for (int i = 0; i < array.length; i++)
			array[i] = (int) (Math.random() * 100);

		quick(array);
		shell(array);
		bubble(array);

	}

	public static void quick(int[] array) {
		int[] quickArray = array;
		int low = 0;
		int high = quickArray.length - 1;
		long timer = -System.currentTimeMillis();
		quickSort(quickArray, low, high);
		timer += System.currentTimeMillis();
		System.out.println("Quick Sort time needed: " + timer);
	}

	public static void shell(int[] array) {
		int[] shellArray = array;
		long timer = -System.currentTimeMillis();
		shellSort(shellArray);
		timer += System.currentTimeMillis();
		System.out.println("Shell Sort time needed: " + timer);

	}

	public static void bubble(int[] array) {
		int[] bubbleArray = array;
		long timer = -System.currentTimeMillis();
		bubbleSort(bubbleArray);
		timer += System.currentTimeMillis();
		System.out.println("Bubble Sort time needed: " + timer);
	}

	public static void quickSort(int[] array, int low, int high) {
		if (array == null || array.length == 0)
			return;

		if (low >= high)
			return;

		int middle = low + (high - low) / 2;
		int pivot = array[middle];

		int i = low, j = high;
		while (i <= j) {
			while (array[i] < pivot) {
				i++;
			}

			while (array[j] > pivot) {
				j--;
			}

			if (i <= j) {
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
				j--;
			}
		}

		if (low < j)
			quickSort(array, low, j);

		if (high > i)
			quickSort(array, i, high);
	}

	private static void bubbleSort(int[] array) {
		int n = array.length;
		int temp = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {

				if (array[j - 1] > array[j]) {
					temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
				}

			}
		}

	}

	public static void shellSort(int[] array) {
		int inner, outer;
		int temp;

		int h = 1;
		while (h <= array.length / 3) {
			h = h * 3 + 1;
		}
		while (h > 0) {
			for (outer = h; outer < array.length; outer++) {
				temp = array[outer];
				inner = outer;

				while (inner > h - 1 && array[inner - h] >= temp) {
					array[inner] = array[inner - h];
					inner -= h;
				}
				array[inner] = temp;
			}
			h = (h - 1) / 3;
		}
	}

}
