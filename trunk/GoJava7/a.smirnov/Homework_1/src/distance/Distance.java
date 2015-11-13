package distance;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Distance {
	private static final String START_OF_DISTANCE = "Distance between numbers [";
	private static final String MIDDLE_OF_DISTANCE = "] and [";
	private static final String END_OF_DISTANCE = "] is: ";
	private static final String MOVE_TO_THE_NEXT_LINE = "\n";

	public String getDistances (List<Integer> inputedNumbers) {
		List<Integer> listNumbers = inputedNumbers;

		int smallestElement = getSmallestElement(listNumbers);
		int secondSmallestElement = getSecondSmallestElment(listNumbers);

		if (secondSmallestElement == Integer.MAX_VALUE) {
			return "There is no second smallest element";
		} else {
			
			Map<Integer, Integer> smallestElementsAndPositions = getElementsAndPositions(
					inputedNumbers, smallestElement);
			Map<Integer, Integer> secondSmallestElementsAndPositions = getElementsAndPositions(
					inputedNumbers, secondSmallestElement);
			
			String result = findDistance(smallestElementsAndPositions, secondSmallestElementsAndPositions);
			return result;
		}

	}

	private int getSmallestElement(List<Integer> inputedNumbers) {
		Collections.sort(inputedNumbers);
		return inputedNumbers.get(0);
	}

	private int getSecondSmallestElment(List<Integer> inputedNumbers) {
		int secondSmallestNumber = Integer.MAX_VALUE;

		for (int number : inputedNumbers) {
			if (number > inputedNumbers.get(0)) {
				secondSmallestNumber = number;
				break;
			}
		}
		return secondSmallestNumber;
	}

	private Map<Integer, Integer> getElementsAndPositions(List<Integer> numbers, int smallestNumber) {
		Map<Integer, Integer> elementsAndPositions = new HashMap<>();
		int amountOfNumbers = numbers.size();
		for (int index = 0; index < amountOfNumbers; index ++) {
			if (smallestNumber == numbers.get(index)) {
				elementsAndPositions.put(index, smallestNumber);
			}
		}
		return elementsAndPositions;
	}
	
	private String findDistance (Map<Integer, Integer> smallestElementsAndPositions, 
			Map<Integer, Integer> secondsmallestElementsAndPositions) {
		
		StringBuilder result = new StringBuilder();
		for (Map.Entry<Integer, Integer> firstEntry : smallestElementsAndPositions.entrySet()) {
			for (Map.Entry<Integer, Integer> secondEntry : secondsmallestElementsAndPositions.entrySet()) {
				result.
					append(START_OF_DISTANCE).
					append(firstEntry.getValue()).
					append(MIDDLE_OF_DISTANCE).
					append(secondEntry.getValue()).
					append(END_OF_DISTANCE).
					append(Math.abs(firstEntry.getKey() - secondEntry.getKey())).
					append(MOVE_TO_THE_NEXT_LINE);
			}
		}
		return result.toString();
	}
}
