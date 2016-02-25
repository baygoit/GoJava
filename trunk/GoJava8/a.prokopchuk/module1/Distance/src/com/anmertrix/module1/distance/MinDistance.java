package com.anmertrix.module1.distance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinDistance {

	protected List<Integer> parseUserNumbersLine(String[] piecesList) {
		List<Integer> numbersLine = new ArrayList<Integer>();
		for (int i = 0; i < piecesList.length; i++) {

			if (piecesList[i].isEmpty()) {
				continue;
			}

			try {
				numbersLine.add(Integer.parseInt(piecesList[i]));
			} catch (NumberFormatException e) {
				System.out.println("You can enter only numbers. \""
						+ piecesList[i] + "\" is not a number. ");
			}
		}

		return numbersLine;
	}

	protected List<Integer> getTwoMinNumbers(List<Integer> numbersList) {

		List<Integer> sortList = new ArrayList<Integer>(numbersList);
		List<Integer> result = new ArrayList<Integer>();
		
		Collections.sort(sortList);
		
		try {
			result.add(sortList.get(0));
		} catch (IndexOutOfBoundsException e) {
			System.out.println("You have not entered a number.");
		}
		try {
			result.add(sortList.get(1));
		} catch (IndexOutOfBoundsException e) {
			System.out.println("You must entered 2 numbers or more.");
		}

		return result;
	}

	protected List<Integer> getDistanceList(List<Integer> numbersList, List<Integer> twoMinNumbers) {
		
		int minNumber1 = 0;
		int minNumber2 = 0;
		try {
			minNumber1 = twoMinNumbers.get(0);
			minNumber2 = twoMinNumbers.get(1);
		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
		}
			
		List<Integer> distanceList = new ArrayList<Integer>();

		for (int i = 0; i < numbersList.size(); i++) {
			for (int j = i + 1; j < numbersList.size(); j++) {
				if (numbersList.get(i) == minNumber1 && numbersList.get(j) == minNumber2
						|| numbersList.get(i) == minNumber2 && numbersList.get(j) == minNumber1) {
					distanceList.add(j - i);
				}
			}
		}

		return distanceList;
	}

	protected void printDistanseList(List<Integer> distanceList) {
		for (int i = 0; i < distanceList.size(); i++) {
			if (i != distanceList.size() - 1) {
				System.out.print(distanceList.get(i) + " ");
			} else {
				System.out.print(distanceList.get(i));
			}
		}
	}
}
