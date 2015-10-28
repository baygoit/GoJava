package ua.scread.generator;

import java.util.Arrays;

/**
 * Generates sorted array <i>(values are from 0 to 100)</i>.
 * @author ScreaD
 *
 */
public class SortedArray implements GeneratorAlgorithm {
	
	@Override
	public Integer[] generate(int size) {
		Integer[] array = new Integer[size];
		//fill with random values from 0 to size*10
		for(int i = 0; i < array.length; i++){
			array[i] = (int)(Math.random()*(size*10 + 1));
		}
		Arrays.sort(array);
		return array;
	}
	@Override
	public String toString(){
		return SortedArray.class.getSimpleName();
	}
}