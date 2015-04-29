package ua.com.goit.gojava4.distance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DistanceCalculator {
	public static final String SEPARATOR = " ";
	public static final int MINIMUM_ARRAY_SIZE = 2;
	public static final int EMPTY_INDEX = -1;

	private String lineOfNumbers;

	public DistanceCalculator(String lineOfNumbers) {
		this.lineOfNumbers = lineOfNumbers;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			try {
				System.out.println("Input numbers (or 'exit'):");
				String line = reader.readLine();
				if ("exit".equalsIgnoreCase(line)) {
					break;
				}

				System.out.println(new DistanceCalculator(line).getDistance());
			} catch (NumberFormatException e) {
				System.out.println("Incorrect numbers! Try again please");
			}
		}

		reader.close();
	}

	public int getDistance() throws NumberFormatException {
		int[] numbers = getNumbers();
		return calculateDistance(numbers);
	}

	private int[] getNumbers() throws NumberFormatException {
		String[] numbers = lineOfNumbers.split(SEPARATOR);
		int[] result = convert(numbers);
		if (!check(result)) {
			throw new NumberFormatException();
		}
		return result;
	}

	private int[] convert(String[] numbers) throws NumberFormatException {
		int[] result = new int[numbers.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = Integer.parseInt(numbers[i]);
		}
		return result;
	}

	private boolean check(int[] numbers) {
		return numbers.length >= MINIMUM_ARRAY_SIZE;
	}

	private int calculateDistance(int[] numbers) {
		int indexOfFirstMinimum = getIndexOfMinimum(numbers);
		int indexOfSecondMinimum = getIndexOfMinimum(numbers, indexOfFirstMinimum);

		return Math.abs(indexOfFirstMinimum - indexOfSecondMinimum);
	}

	private int getIndexOfMinimum(int[] numbers) {
		return getIndexOfMinimum(numbers, EMPTY_INDEX);
	}

	private int getIndexOfMinimum(int[] numbers, int exceptIndex) {
		int result = EMPTY_INDEX;
		for (int index = 0; index < numbers.length; index++) {
			if (index == exceptIndex) {
				continue;
			}
			result = calculateIndexOfMinimum(result, index, numbers);
		}
		return result;
	}

	private int calculateIndexOfMinimum(int indexOfMinimum, int currentIndex, int[] numbers) {
		if (indexOfMinimum == EMPTY_INDEX || numbers[indexOfMinimum] > numbers[currentIndex]) {
			return currentIndex;
		}
		return indexOfMinimum;
	}
}
