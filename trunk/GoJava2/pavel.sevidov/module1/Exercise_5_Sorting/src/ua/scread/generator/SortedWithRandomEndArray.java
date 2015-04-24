package ua.scread.generator;

import java.util.Arrays;

public class SortedWithRandomEndArray implements GeneratorAlgorithm {
	
	@Override
	public Integer[] generate(int size) {
		Integer[] array = new Integer[size];
		//fill with random values from 0 to 100
		for(int i = 0; i < array.length; i++){
			array[i] = (int)(Math.random()*101);
		}
		Arrays.sort(array);
		//change last element to random value
		array[array.length - 1] = (int)(Math.random()*(size*10 + 1));
		return array;
	}
	@Override
	public String toString(){
		return SortedWithRandomEndArray.class.getSimpleName();
	}
}
