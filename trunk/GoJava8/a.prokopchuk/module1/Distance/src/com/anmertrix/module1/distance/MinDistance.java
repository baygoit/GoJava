package com.anmertrix.module1.distance;

import java.util.ArrayList;

public class MinDistance {
	
	protected ArrayList<Integer> parseUserNumbersLine(String[] piecesList) {
		ArrayList<Integer> numbersLine = new ArrayList<Integer>();
		for (int i = 0; i < piecesList.length; i++) {
			
			if (piecesList[i].isEmpty()) {
				continue;
			}
			
			try {	
				numbersLine.add(Integer.parseInt(piecesList[i]));
			} catch(NumberFormatException e) {
				System.out.println("You can enter only numbers. " + piecesList[i] + " is not a number. ");
			}  
		}
		
		return numbersLine;
	}
	
	protected int[] getTwoMinNumbers(ArrayList<Integer> numbersList) {
		int minNumber1 = 0;
		int minNumber2 = 0;
		try{
			minNumber1 = numbersList.get(0);
			minNumber2 = numbersList.get(0);
		} catch(IndexOutOfBoundsException e){
			// TODO Auto-generated catch block
			System.out.println("You have not entered a number.");
		}
		for (int i = 0; i < numbersList.size(); i++) {
			if (numbersList.get(i) <= minNumber1) {
				minNumber2 = minNumber1;
				minNumber1 = numbersList.get(i);
			}
			else if (numbersList.get(i) <= minNumber2) {
				minNumber2 = numbersList.get(i);
			}
		}
		int[] result = {minNumber1, minNumber2};
		
		return result;
	}
	
	protected ArrayList<Integer> getDistanceList(ArrayList<Integer> numbersList, int[] twoMinNumbers) {

		int minNumber1 = twoMinNumbers[0];
		int minNumber2 = twoMinNumbers[1];
		ArrayList<Integer> distanceList = new ArrayList<Integer>();
		
		for (int i = 0; i < numbersList.size(); i++) {
			for (int j = i + 1; j < numbersList.size(); j++) {
				if (numbersList.get(i) == minNumber1 && numbersList.get(j) == minNumber2 || numbersList.get(i) == minNumber2 && numbersList.get(j) == minNumber1) {
					distanceList.add(j - i);
				}
			}
		}
		
		return distanceList;
	}
	
	protected void printDistanseList(ArrayList<Integer> distanceList) {
		for (int i = 0; i < distanceList.size(); i++) {
			if (i != distanceList.size() - 1) {
				System.out.print(distanceList.get(i) + " ");
			} else {
				System.out.print(distanceList.get(i));
			}
		}
	}
}
