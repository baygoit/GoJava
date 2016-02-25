package com.anmertrix.module1.distance;

import java.util.List;

public class Distance {

	public static void main(String[] args)  {
		Reader reader = new Reader();
		String[] piecesList = reader.readUserNumbersLine().split(" ");
		List<Integer> numbersList = null;
		MinDistance minDistance = new MinDistance();

		numbersList = minDistance.parseUserNumbersLine(piecesList);

		List<Integer> twoMinNumbers = minDistance.getTwoMinNumbers(numbersList);
		List<Integer> distanceList = minDistance.getDistanceList(numbersList, twoMinNumbers);
		minDistance.printDistanseList(distanceList);
	}

}
