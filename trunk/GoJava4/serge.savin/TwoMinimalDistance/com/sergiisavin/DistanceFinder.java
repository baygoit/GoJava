/*
 * Сервисный клас содержит статический метод вычисляющий расстояние между двумя минимальными елементами массива
 * в случае если массив содержит больше двух минимальных елементов, вычисляется расстояние между крайними елементами в массиве
 * индексы повторяющихся елементов вычисляются, так что можно добавить другие варианты расчёта
 * 
 */



package com.sergiisavin;

import java.util.Arrays;

public class DistanceFinder {


	public static int findDistance(double[] numbers)
			throws IllegalArgumentException {
		int distance = 0;
		int[] indexes = new int[numbers.length];
		
		//clonning initial array not to corrupt it
		double[] numbersCloned = numbers.clone();
		
		Arrays.sort(numbersCloned);
		
		//some input data check
		if (numbers == null) {
			throw new IllegalArgumentException("параметр не должен быть null");
		} else if (numbers.length == 0) {
			throw new IllegalArgumentException(
					"параметр не должен быть массивом нулевой длинны");
		} else if (numbers.length == 1) {
			return 0;
		}
		
		//if the first and second elements in the array are different then find their indexes and calculate distance
		if(numbersCloned[0] != numbersCloned[1]){
			distance = findIndex(numbers, numbersCloned[1]) - findIndex(numbers, numbersCloned[0]);
		}else{
			
			//there are more than two minimal elements in the array
			//fill an array of indexes of all minimal elements
			int counter = 0;
			for(int i = 0; i < numbers.length; i++){
				if(numbers[i] == numbersCloned[0]){
					indexes[counter] = i;
					counter++;
				}
		}
			//by default calculate distance between the first and the last the same minimal number
			int firstIndex = indexes[0];
			int secondIndex = indexes[counter-1];
			distance = secondIndex - firstIndex;
		}
		
		return Math.abs(distance);
	}

	private static int findIndex(double[] numbers, double d) {
		int index = 0;
		
		for(int i = 0; i < numbers.length; i++ ){
			if(numbers[i] == d){
				index = i;
				break;
			}
		}
		
		return index;
	}
}
