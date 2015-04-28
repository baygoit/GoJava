/*
 * Service class. Singleton. Contains a method that calculates the distance between two minimal numbers in the array
 * if there are more than two minimal elements the method calculates the distance between the most distant elements
 * the indexes of all minimal elements are calculated, so that other variants of calculation can be realized later
 * 
 */



package com.sergiisavin;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DistanceFinder {

	private static DistanceFinder distanceFinder = null;
	
	private int numberOfRepeatedElements = 0;
	double[] numbersCopy = null;
	int[] indexesOfRepeatedElements = null;
	
	double firstNumber;
	double secondNumber;
	double thirdNumber;
	
	private DistanceFinder(){};
	
	//get singleton
	public static DistanceFinder getDistanceFinder(){
		if(distanceFinder == null){
			distanceFinder =  new DistanceFinder();
		}
		
		return distanceFinder; 
	}
	
	public int findDistance(double[] numbers) throws IllegalArgumentException {
		
		int result = 0;
		
		int indexOfFirstMinimalElement = 0;
		int indexOfSecondMinimalElement = 0;
						
		checkValidity(numbers);
		
		numbersCopy = numbers.clone();
		Arrays.sort(numbersCopy);
		
		//return evident result
		if (numbers.length == 1) {
			return 0;
		}else if(numbers.length == 2){
			return 1;
		}
		
		firstNumber = numbersCopy[0];
		secondNumber = numbersCopy[1];
		thirdNumber = numbersCopy[2];
				
		indexOfFirstMinimalElement = findIndex(numbers, firstNumber);
		indexOfSecondMinimalElement = findIndexOfSecondMinimalElement(numbers, indexOfFirstMinimalElement);
		result = Math.abs(indexOfSecondMinimalElement - indexOfFirstMinimalElement);
			
		return result;
	}
	
	private int findIndexOfSecondMinimalElement(double[] numbers, int indexOfFirstMinimalElement) {
		int result = 0;

		switch(numberOfUniqueElements(firstNumber, secondNumber, thirdNumber)) {
		case 3:
			result =  findIndex(numbers, secondNumber);
			break;
		case 2:
		case 1:
			indexesOfRepeatedElements = getElementIndexes(secondNumber, numbers);
			result = getIndexOfMostDistantElement(indexesOfRepeatedElements, indexOfFirstMinimalElement);
		}
		return result;
	}

	private int getIndexOfMostDistantElement(int[] indexesOfRepeatedNumbers, int indexOfFirstMinimalElement) {
		
		int distance = 0;
		int targetIndex = 0; 
		
		for(int index = 0; index < numberOfRepeatedElements; index++){
			if(Math.abs(indexesOfRepeatedNumbers[index] - indexOfFirstMinimalElement) > distance){
				distance = Math.abs(indexesOfRepeatedNumbers[index] - indexOfFirstMinimalElement);
				targetIndex = index;
			}
		}
		
		return indexesOfRepeatedNumbers[targetIndex];
	}

	private int[] getElementIndexes(double element, double[] numbers) {
		
		int[] indexesOfRepeatedNumbers = new int[numbers.length];
		
		int indexOfRepeatedNumber = 0;
		for(int index = 0; index < numbers.length; index++){
			if(numbers[index] == element){
				indexesOfRepeatedNumbers[indexOfRepeatedNumber] = index;
				indexOfRepeatedNumber++;
			}
		}
		
		//numberOfRepeatedElements is the class field which is saved for further use by different methods
		numberOfRepeatedElements = indexOfRepeatedNumber;
		return indexesOfRepeatedNumbers;
	}

	private int numberOfUniqueElements(double ... numbers) {

		Set<Double> set = new HashSet<Double>();
		
		for(double number : numbers){
			set.add(number);
		}
		
		return set.size();
	}

	private static void checkValidity(double[] numbers) {
		if (numbers == null) {
			throw new IllegalArgumentException("parameter should not be null");
		} else if (numbers.length == 0) {
			throw new IllegalArgumentException(
					"the length of the array should not be 0");
		}
	}

	private static int findIndex(double[] numbers, double number) {
		int result = 0;
		
		for(int index = 0; index < numbers.length; index++ ){
			if(numbers[index] == number){
				result = index;
				break;
			}
		}
		
		return result;
	}
}
