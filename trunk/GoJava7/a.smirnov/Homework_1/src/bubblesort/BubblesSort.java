package bubblesort;

public class BubblesSort {

	public int[] sort(int[] inputedNumbers) {
		int amountOfNumbers = inputedNumbers.length;
		int replacement;

		for (int barrier = amountOfNumbers - 1; barrier > 0; barrier--) {
			for (int index = 0; index < barrier; index++) {
				if (inputedNumbers[index] > inputedNumbers[index + 1]) {
					replacement = inputedNumbers[index];
					inputedNumbers[index] = inputedNumbers[index + 1];
					inputedNumbers[index + 1] = replacement;
				}
			}
		}
		return inputedNumbers;
	}
}
