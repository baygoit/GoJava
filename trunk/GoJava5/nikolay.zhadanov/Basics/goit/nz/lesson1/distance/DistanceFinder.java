package goit.nz.lesson1.distance;

import goit.nz.lesson1.Parser;
import goit.nz.lesson1.Reader;

import java.util.Arrays;

public class DistanceFinder {
	private final String INPUT_PROMPT = "Input row of integer numbers separated by whitespaces:";
	private Reader console;
	private Parser parser;
	private int numberOfMinsToFind;
	private int[] array;
	private int[] mins;
	private int[] minIndexes;

	public DistanceFinder(int numberOfMins) {
		console = new Reader(INPUT_PROMPT);
		parser = new Parser("Row cointains not only integer numbers!");
		numberOfMinsToFind = numberOfMins;
	}

	public void find() {
		do {
			this.array = parser.stringToInt(console.readLine());
		} while (!parser.successParsing);
		this.performFind();
	}
	
	private void performFind() {
		if (this.array.length < 2) {
			this.showOutput(0);
		}
		int[] clone = Arrays.copyOf(array, array.length);
		Arrays.sort(clone);
		int minCount = this.numberOfMinsToFind > clone.length ? clone.length
				: this.numberOfMinsToFind;
		this.mins = Arrays.copyOf(clone, minCount);
		this.minIndexes = new int[minCount];
		for (int i = 0; i < this.mins.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[j] == this.mins[i] && !isInMinIndex(j)) {
					this.minIndexes[i] = j;
					break;
				}
			}
		}
		Arrays.sort(this.minIndexes);
		this.showOutput(this.minIndexes[this.minIndexes.length - 1]
				- this.minIndexes[0]);
	}
	
	private boolean isInMinIndex(int index) {
		for (int i = 0; i < this.minIndexes.length; i++) {
			if (index == this.minIndexes[i]) {
				return true;
			}
		}
		return false;
	}
	
	private void showOutput(int distance) {
		System.out.println("For a list of numbers entered:");
		for (int i = 0; i < this.array.length; i++) {
			System.out.print(this.array[i] + " ");
		}
		System.out.println();
		System.out.println("The result is:");
		System.out.println("Minimums found: " + Arrays.toString(this.mins));
		System.out.println("Distance = " + distance);
	}
}
