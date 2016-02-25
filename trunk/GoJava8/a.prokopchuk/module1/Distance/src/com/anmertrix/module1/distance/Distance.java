package com.anmertrix.module1.distance;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Distance {

	public static void main(String[] args) throws IOException {
		String[] piecesList = readUserNumbersLine().split(" ");
		ArrayList<Integer> numbersList = parseUserNumbersLine(piecesList);
		int[] twoMinNumbers = getTwoMinNumbers(numbersList);
		ArrayList<Integer> distanceList = getDistanceList(numbersList, twoMinNumbers);
		printDistanseList(distanceList);
	}
	
	private static String readUserNumbersLine() throws IOException {
		BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
		String numbersLine = reader.readLine();
		reader.close();
		
		return numbersLine;
	}
	
	private static ArrayList<Integer> parseUserNumbersLine(String[] piecesList) {
		ArrayList<Integer> numbersLine = new ArrayList<Integer>();
		for (int i = 0; i < piecesList.length; i++) {
			try {
				numbersLine.add(Integer.parseInt(piecesList[i]));
			} catch(Exception e) {
				System.out.println("You can enter only numbers. " + piecesList[i] + " is not a number.");
			}   
		}
		
		return numbersLine;
	}
	
	private static int[] getTwoMinNumbers(ArrayList<Integer> numbersList) {
		int minNumber1 = numbersList.get(0);
		int minNumber2 = numbersList.get(0);
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
	
	private static ArrayList<Integer> getDistanceList(ArrayList<Integer> numbersList, int[] twoMinNumbers) {

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
	
	private static void printDistanseList(ArrayList<Integer> distanceList) {
		for (int i = 0; i < distanceList.size(); i++) {
			if (i != distanceList.size() - 1) {
				System.out.print(distanceList.get(i) + " ");
			} else {
				System.out.print(distanceList.get(i));
			}
		}
	}
}
