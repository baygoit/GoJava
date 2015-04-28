package ua.com.goit.gojava4.distance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DistanceCalculator {
	public static final String SEPARATOR = " ";
	public static final int MINIMUM_ARRAY_SIZE = 2;
	public static final int FIRST_INIT_INDEX = 0;
	public static final int SECOND_INIT_INDEX = 0;

	private String lineOfNumbers;

	public DistanceCalculator(String lineOfNumbers) {
		this.lineOfNumbers = lineOfNumbers;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		try {
			System.out.println("Input numbers:");
			String line = reader.readLine();
			System.out.println(new DistanceCalculator(line).getDistance());
		} catch (NumberFormatException e) {
			System.out.println("Incorrect numbers");
		} finally {
			reader.close();
		}
	}

	public int getDistance() throws NumberFormatException {
		int[] numbers = getNumbers(lineOfNumbers);
		check(numbers);
		return calculateDistance(numbers);
	}

	private void check(int[] numbers) throws NumberFormatException {
		if (numbers.length < MINIMUM_ARRAY_SIZE)
			throw new NumberFormatException();
	}

	private int[] getNumbers(String numbers) throws NumberFormatException {
		return convert(lineOfNumbers.split(SEPARATOR));
	}

	private int[] convert(String[] numbers) throws NumberFormatException {
		int[] result = new int[numbers.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = Integer.parseInt(numbers[i]);
		}
		return result;
	}

	private int calculateDistance(int[] numbers) {
		int indexOfFirstMinimum = FIRST_INIT_INDEX;
		int indexOfSecondMinimum = SECOND_INIT_INDEX;
		calculateIndexsOfTwoMinimums(indexOfFirstMinimum, indexOfSecondMinimum, numbers);
		
		int result = indexOfSecondMinimum - indexOfFirstMinimum;
		if (indexOfSecondMinimum < indexOfFirstMinimum) {
			result *= -1;
		}
		return result;
	}

	private void calculateIndexsOfTwoMinimums(int indexOfFirstMinimum,
			int indexOfSecondMinimum, int[] numbers) {
		for (int index = 2; index < numbers.length; index++) {
			if (checkIndexOfMinimum(indexOfFirstMinimum, index, numbers)) {
				setIndexOfMinimum(indexOfFirstMinimum, indexOfSecondMinimum,
						index, numbers);
			} else if (checkIndexOfMinimum(indexOfSecondMinimum, index, numbers)) {
				setIndexOfMinimum(indexOfSecondMinimum, indexOfFirstMinimum,
						index, numbers);
			}
		}
	}

	private void setIndexOfMinimum(int indexOfMinimum,
			int indexOfAdditionalMinimum, int currentIndex, int[] numbers) {

		if (numbers[indexOfAdditionalMinimum] > numbers[indexOfMinimum]) {
			indexOfAdditionalMinimum = indexOfMinimum;
		}
		indexOfMinimum = currentIndex;
	}

	private boolean checkIndexOfMinimum(int indexOfMinimum, int currentIndex,
			int[] numbers) {

		if (numbers[indexOfMinimum] > numbers[currentIndex]) {
			return true;
		}
		return false;
	}
}
