package ua.com.goit.gojava4.distance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DistanceCalculator {
	public static final String SEPARATOR = " ";
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
		return getDistance(lineOfNumbers.split(" "));
	}

	public int getDistance(String[] numbers) throws NumberFormatException {
		int[] ints = new int[numbers.length];
		for (int i = 0; i < ints.length; i++) {
			ints[i] = Integer.parseInt(numbers[i]);
		}
		return getDistance(ints);
	}

	public int getDistance(int[] numbers) throws NumberFormatException {
		if (numbers.length < 2)
			throw new NumberFormatException();
		return calculateDistance(numbers);
	}

	private int calculateDistance(int[] numbers) {
		int indexOfMin1 = 0;
		int indexOfMin2 = 1;
		for (int i = 2; i < numbers.length; i++) {
			if (numbers[indexOfMin1] > numbers[i]) {
				if (numbers[indexOfMin2] > numbers[indexOfMin1]) {
					indexOfMin2 = indexOfMin1;
				}
				indexOfMin1 = i;
			} else if (numbers[indexOfMin2] > numbers[i]) {
				if (numbers[indexOfMin1] > numbers[indexOfMin2]) {
					indexOfMin1 = indexOfMin2;
				}
				indexOfMin2 = i;
			}
		}

		return indexOfMin2 > indexOfMin1 ? indexOfMin2 - indexOfMin1
				: indexOfMin1 - indexOfMin2;
	}
}
