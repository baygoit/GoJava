package goit.nz.lesson1.distance;

import goit.nz.lesson1.Parser;
import goit.nz.lesson1.Reader;

import java.util.Arrays;

public class DistanceFinder {
	private Reader console;
	private Parser parser;
	private int numberOfMinsToFind;
	private int[] originalNumbers;
	private int[] mins;
	private int[] minIndexes;

	public DistanceFinder(int numberOfMins) {
		console = new Reader(DistanceStrings.NUMBERS_PROMPT);
		parser = new Parser(DistanceStrings.PARSER_WARNING);
		numberOfMinsToFind = numberOfMins;
	}

	public void find() {
		do {
			originalNumbers = parser.stringToInt(console.readLine());
		} while (!parser.isParsingSuccessful);
		performFind();
	}

	private void performFind() {
		if (originalNumbers.length < 2) {
			showOutput(0);
		}
		int[] clone = Arrays.copyOf(originalNumbers, originalNumbers.length);
		Arrays.sort(clone);
		int minCount = 
				numberOfMinsToFind > clone.length 
				? clone.length
				: numberOfMinsToFind;
		mins = Arrays.copyOf(clone, minCount);
		minIndexes = new int[minCount];
		for (int i = 0; i < mins.length; i++) {
			for (int j = 0; j < originalNumbers.length; j++) {
				if (originalNumbers[j] == mins[i] && !isInMinIndex(j)) {
					minIndexes[i] = j;
					break;
				}
			}
		}
		Arrays.sort(minIndexes);
		showOutput(minIndexes[minIndexes.length - 1] - minIndexes[0]);
	}

	private boolean isInMinIndex(int index) {
		for (Integer minIndex : minIndexes) {
			if (index == minIndex) {
				return true;
			}
		}
		return false;
	}

	private void showOutput(int distance) {
		System.out.println("For a list of numbers entered:");
		for (Integer number : originalNumbers) {
			System.out.print(number + " ");
		}
		System.out.println();
		System.out.println("The result is:");
		System.out.println("Minimums found: " + Arrays.toString(mins));
		System.out.println("Distance = " + distance);
	}
}
