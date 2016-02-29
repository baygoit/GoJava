package com.anmertrix.module1.distance;

import java.util.List;

public class Distance {

	public static void main(String[] args)  {
		Reader reader = new Reader();
		String[] pieces = reader.readUserNumbersLine().split(" ");
		List<Integer> numbers = null;
		MinDistance minDistance = new MinDistance();

		numbers = minDistance.parseUserNumbersLine(pieces);

		List<Integer> twoMinNumbers = minDistance.getTwoMinNumbers(numbers);
		List<Integer> distances = minDistance.getDistances(numbers, twoMinNumbers);
		minDistance.printDistanseList(distances);
	}

}
