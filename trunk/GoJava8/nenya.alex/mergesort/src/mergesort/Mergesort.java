package mergesort;


public class MergeSort {

	private int[] numbers;
	private int[] helpArray;
	private int size;

	public int[] sort(int[] array) {
		if (array == null) {
			throw new NullPointerException();
		}
		if (array.length == 0) {
			return array;
		}
		this.numbers = array;
		size = array.length;
		this.helpArray = new int[size];
		mergesort(0, size - 1);

		return array;
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
