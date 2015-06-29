package goit.nz.lesson1.distance;

import goit.nz.lesson1.Parser;
import goit.nz.lesson1.Reader;

public class Main {
	public static void main(String[] args) {
		Reader console = new Reader(
				"How many minimums need to find? Input a number bigger then zero:");
		Parser parser = new Parser("That is not an integer number!");
		do {
			int numberOfMins = 0;
			do {
				numberOfMins = parser.getFirstIntFromString(console.readLine());
			} while (!parser.successParsing || numberOfMins <= 0);
			DistanceFinder finder = new DistanceFinder(numberOfMins);
			finder.find();
		} while (console.askForRepeat());
	}
}
