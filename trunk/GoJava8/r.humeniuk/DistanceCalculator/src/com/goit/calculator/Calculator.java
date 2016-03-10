package com.goit.calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

	private List<Integer> inputArray = new ArrayList<Integer>();

	Calculator(List<Integer> inputArray) {
		this.inputArray = inputArray;
	}

	public ArrayList<Integer> getDistance() {
		int first = findFirstMinimalValue();
		if (findSameValue(first).size() > 1) {
			return findDistanceBetweenSameElements(findSameValue(first));
		} else {
			int second = findSecondMinimalValue(first);
			return findDistanceBetweenDifferentElements(first, findSameValue(second));
		}
	}

	private int findFirstMinimalValue() {
		int storage = (int) inputArray.get(0);
		for (int i = 0; i < inputArray.size(); i++) {
			if (storage > (int) inputArray.get(i)) {
				storage = (int) inputArray.get(i);
			}
		}
		return storage;
	}

	private int findSecondMinimalValue(int firstMinimalValue) {
		int storage = Integer.MAX_VALUE;
		for (int i = 0; i < inputArray.size(); i++) {
			int currentValue = (int) inputArray.get(i);
			if (storage > currentValue && firstMinimalValue != currentValue) {
				storage = currentValue;
			}
		}
		return storage;
	}

	private ArrayList<Integer> findSameValue(int value) {
		ArrayList<Integer> indexHolder = new ArrayList<Integer>();
		for (int i = 0; i < inputArray.size(); i++) {
			if (value == (int) inputArray.get(i)) {
				indexHolder.add(i);
			}
		}
		return indexHolder;
	}

	private ArrayList<Integer> findDistanceBetweenDifferentElements(int firstValue, ArrayList<Integer> secondValues) {
		ArrayList<Integer> distance = new ArrayList<Integer>();
		for (int i = 0; i < secondValues.size(); i++) {
			distance.add(Math.abs(secondValues.get(i) - findSameValue(firstValue).get(0)));
		}
		return distance;
	}

	private ArrayList<Integer> findDistanceBetweenSameElements(ArrayList<Integer> values) {
		ArrayList<Integer> distance = new ArrayList<Integer>();
		for (int i = 0; i < values.size(); i++) {
			for (int j = i + 1; j < values.size(); j++) {
				distance.add(Math.abs(values.get(i) - values.get(j)));
			}
		}
		return distance;
	}
	
}