package com.anmertrix.module1.distance;

import java.util.ArrayList;

public class Distance {

	public static void main(String[] args) {
		Reader reader = new Reader();
		String[] piecesList = reader.readUserNumbersLine().split(" ");
		ArrayList<Integer> numbersList = null;
		MinDistance minDistance = new MinDistance();
		
		numbersList = minDistance.parseUserNumbersLine(piecesList);
	
		int[] twoMinNumbers = minDistance.getTwoMinNumbers(numbersList);
		ArrayList<Integer> distanceList = minDistance.getDistanceList(numbersList, twoMinNumbers);
		minDistance.printDistanseList(distanceList);
	}
	
}
